package com.metro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	// 회원정보 관리용 컨트롤러
@RequestMapping("member/")
public class MemberController {
	@RequestMapping(value="{url}.do")	// 단순 경로 테스트용
	public String common(@PathVariable String url) {
		return "member/" + url;
	}
}
