package com.metro.service;

import com.metro.domain.StationVO;

public interface StationService {

	/*
	 * 역 정보 서비스 인터페이스
	 */
	StationVO stationInfo(String stationName);
	
}
