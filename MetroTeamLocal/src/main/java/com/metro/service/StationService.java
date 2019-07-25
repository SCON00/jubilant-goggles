package com.metro.service;

import java.util.List;
import java.util.Map;

import com.metro.domain.StationVO;

public interface StationService {

	/*
	 * 역 정보 서비스 인터페이스
	 */
	StationVO stationInfo(String stationName);	// 역 정보
	
	Map<String,String> getExitInfo(String stationName);		// 출구정보 조회

	Map<String, List<StationVO>> getLineList(String stationCode);	// 역 기준 노선 조회


	
}
