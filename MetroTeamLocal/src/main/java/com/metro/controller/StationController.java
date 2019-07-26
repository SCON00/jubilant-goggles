package com.metro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metro.domain.StationVO;
import com.metro.service.StationService;

@Controller	// 역 관련 서비스 컨트롤러
@RequestMapping("station/")
public class StationController {
	
	@Autowired
	private StationService stationService;
	
	@RequestMapping(value="{url}.do") // 단순 경로 테스트용 
	public String common(@PathVariable String url) { return "station/" + url; }
	
	/**
	 * 역 세부 정보 화면
	 * @param stationCode
	 * @return
	 */
	@RequestMapping(value="station.do/{stationCode}", method = RequestMethod.GET)
	public ModelAndView stationInfo(@PathVariable("stationCode") String stationCode) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("Controller: " + stationCode);
		
		StationVO result = stationService.stationInfo(stationCode);		// 역 정보 조회 
		result.setsExits(stationService.getExitInfo(stationCode));		// 출구 정보 조회
		
		mv.addObject("result", result);
		mv.addObject("lines", stationService.getLineList(stationCode));	// 노선 기준 주변 역 리스트
		mv.addObject("codes", stationService.getCodes(stationCode));	// 해당 역 코드 복수 조회
		mv.setViewName("station/station");
		return mv;
	}
}
