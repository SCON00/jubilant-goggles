package com.metro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="getLines.do")
	@ResponseBody
	public int updateInfo() {
		int result = mgtService.updateLines();
		return result;
	}
}
