package com.metro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public int station(@PathVariable("stationName") String stationName) {
		System.out.println(stationName + ": Controller");
		int result = stationService.stationInfo(stationName);
		return result;
	}
}
