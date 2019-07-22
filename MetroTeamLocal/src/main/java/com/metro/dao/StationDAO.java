package com.metro.dao;

import java.util.List;

import com.metro.domain.StationVO;

public interface StationDAO {

	/*
	 * 역 관련 서비스용 모델 인터페이스
	 * 	- 메소드 추가 후 Impl 클래스에서 구현
	 */
	List<StationVO> selectStationByName(String stationName);
	
}
