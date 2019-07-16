package com.metro.dao;

import java.util.List;
import java.util.Map;

import com.metro.domain.CsVO;
import com.metro.domain.MemberVO;
import com.metro.domain.StationVO;

public interface MgtDAO {

	/*
	 * 관리자 모듈용 모델 인터페이스
	 * 	- 메소드 추가 후 Impl 클래스에서 구현
	 */
	int insertKey(String apiKey);			// 공공데이터 api key 저장

	List<MemberVO> selectAllMember();		// 회원목록 조회

	List<StationVO> selectAllStation();		// 역 정보 조회

	List<CsVO> selectAllNotice();			// 공지사항 조회

	Map selectExitInfo(String stationCode);	// 출구정보 조회
	
}
