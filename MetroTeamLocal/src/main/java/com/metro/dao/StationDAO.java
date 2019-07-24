package com.metro.dao;

import java.util.List;
import java.util.Map;

import com.metro.domain.StationVO;

public interface StationDAO {

	/*
	 * 역 관련 서비스용 모델 인터페이스
	 * 	- 메소드 추가 후 Impl 클래스에서 구현
	 */
	

	Map<String,String> selectExitInfo(String stationName);					// 출구정보 조회

	StationVO selectStationByID(String stationCode);	// 역코드로 조회
	
}
