package com.metro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	// 열차 관련 서비스 컨트롤러
@RequestMapping("train/")
public class TrainController {

	@RequestMapping(value="{url}.do")	// 단순 경로 테스트용 
	public String common(@PathVariable String url) {
		return "train/" + url;
	}
}
