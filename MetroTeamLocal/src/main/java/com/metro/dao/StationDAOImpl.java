package com.metro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metro.domain.StationVO;

@Repository("stationDAO")
public class StationDAOImpl implements StationDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public StationVO selectStationByID(String stationCode) {
		
		return mybatis.selectOne("station.selectStationByID", stationCode);		
	}

	/**
	 * 역 출구정보 조회
	 */
	@Override
	public Map<String,String> selectExitInfo(String stationCode) {
		
		System.out.println("IN: " + stationCode);
		// 역의 대표 코드 조회
		stationCode = mybatis.selectOne("station.selectStationCode", stationCode);
		System.out.println("OUT: " + stationCode);
		// station_exits 테이블에서 출구번호 조회
		List<String> list = mybatis.selectList("station.selectExitNumber", stationCode);
		
		Map<String,String> dataMap = new HashMap<String,String>(); 
			
		for(String s : list) {
			
			Map<String,String> map = new HashMap<String,String>();
			
			map.put("stationCode", stationCode);
			map.put("exitNumber", s);
				
			// 출구별 정보조회
			List<String> data = mybatis.selectList("station.selectExitInfo", map);
			
			dataMap.put(s, data.toString());
		}
		return dataMap;
	}

}
