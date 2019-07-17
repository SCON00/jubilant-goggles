package com.metro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.metro.domain.CsVO;
import com.metro.domain.MemberVO;
import com.metro.domain.StationVO;
import com.metro.service.MgtService;

@Controller	// 관리자 모듈 컨트롤러
@RequestMapping("mgt/")
public class MgtController {
	
	@Autowired
	private MgtService mgtService;
	
	@RequestMapping(value="{url}.do")	// 단순 경로 테스트용
	public String common(@PathVariable String url) {
		return "mgt/" + url;
	}
	
	@RequestMapping(value="getLines.do")	// ajax 테스트
	@ResponseBody
	public int updateInfo() {
		int result = mgtService.updateLines();
		return result;
	}
	@RequestMapping(value="addKey.do/{apiKey}")		// apiKey 서버 등록
	@ResponseBody
	public int addKey(@PathVariable("apiKey") String apiKey) {
		int result = mgtService.addKey(apiKey);
		return result;
	}
	
	@RequestMapping(value="exitInfo.do", produces="application/text; charset=utf8")		// 역 출구 정보 조회
	@ResponseBody
	public String exitInfo(@RequestParam("stationCode") String stationCode) {
		String result = mgtService.getExitInfo(stationCode);
		return result;
	}
	
	/**
	 * 검색어로 역정보 조회
	 * @param searchWord
	 * @return
	 */
	@RequestMapping(value="stationInfo.do/{searchWord}", produces="application/text; charset=utf8")
	@ResponseBody
	public String stationInfo(@PathVariable("searchWord") String searchWord) {
		String result = mgtService.getStations(searchWord);
		return result;
	}

	/**
	 * 역 마다 복수 개의 역코드 보유
	 * 가장 빠른 번호를 이용하여 정보 조회
	 * @param stationCode
	 * @return 역코드 중 가장 빠른 번호
	 */
	@RequestMapping(value="stationCode.do/{stationCode}", produces="application/text; charset=utf8")
	@ResponseBody
	public String stationCode(@PathVariable("stationCode") String stationCode) {
		System.out.println("Controller: " + stationCode);
		String result = mgtService.getStationCode(stationCode);
		return result;
	}
	
	@RequestMapping(value="dashboard.do/{boardName}")	// 관리자 사이드 탭 이동
	public ModelAndView admin(@PathVariable("boardName") String boardName) {
		
		ModelAndView mv = new ModelAndView();
		
		if(boardName == null || boardName.equals("")) {
			boardName = "memberBoard";
		}
		
		String type = boardName.replaceAll("Board", "");
		String[]colorWheel = {"primary","secondary","success", "danger","warning","info","dark"};
		mv.addObject("colorWheel", colorWheel);
		
		// 탭 구분 정보 조회
		if(type.equals("member")) {								// 관리자 모듈 - 회원 관리
			List<MemberVO> list = mgtService.getMembers();		// 회원 리스트
			mv.addObject("list", list);
		} else if(type.equals("station")) {						// 관리자 모듈 - 역 정보 관리
			List<StationVO> list = mgtService.getStations();	// 역 리스트
			mv.addObject("list", list);
		} else if(type.equals("schedule")) {
		
		} else if(type.equals("notice")) {						// 관리자 모듈 - 공지사항 관리
			List<CsVO> list = mgtService.getNotice();			// 공지 리스트
			mv.addObject("list", list);
		} else if(type.equals("qna")) {							// 관리자 모듈 - 문의사항 관리
			//List<CsVO> list = mgtService.getQna();
		}
		
		mv.addObject("boardName", boardName);
		mv.setViewName("mgt/dashboard");
		return mv;
	}
}
