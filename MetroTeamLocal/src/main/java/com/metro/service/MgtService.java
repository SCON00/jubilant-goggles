package com.metro.service;

import java.util.List;

import com.metro.domain.CsVO;
import com.metro.domain.MemberVO;
import com.metro.domain.StationVO;

public interface MgtService {
	
	/*
	 * 관리자모듈 서비스 인터페이스
	 */
	int updateLines();

	int addKey(String apiKey);				// api key 등록
	
	List<MemberVO> getMembers();			// 회원 정보 조회

	List<StationVO> getStations();			// 역 정보 조회

	List<CsVO> getNotice();					// 공지사항 조회

	String getExitInfo(String stationCode);	// 출구정보 조회
}
