package com.metro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	// 고객관리 서비스 컨트롤러
@RequestMapping("cs/")
public class CsController {								
	
	@RequestMapping(value="{url}.do")	// 단순 경로 테스트용
	public String common(@PathVariable String url) {
		return "cs/" + url;
	}
}
