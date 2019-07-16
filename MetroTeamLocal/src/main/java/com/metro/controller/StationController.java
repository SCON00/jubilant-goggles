package com.metro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metro.service.StationService;

@Controller	// 역 관련 서비스 컨트롤러
@RequestMapping("station/")
public class StationController {
	
	@Autowired
	private StationService stationService;

	@RequestMapping(value="{url}.do")	// 단순 경로 테스트용
	public String common(@PathVariable String url) {
		return "station/" + url;
	}
	
	@RequestMapping(value="station.do/{stationName}", method = RequestMethod.GET)
	public ModelAndView station(@PathVariable("stationName") String stationName) {
		ModelAndView mv = new ModelAndView();
		System.out.println(stationName + ": Controller");
		String result = stationService.stationInfo(stationName);
		mv.addObject("result", result);
		mv.setViewName("station/station");
		return mv;
	}
}
