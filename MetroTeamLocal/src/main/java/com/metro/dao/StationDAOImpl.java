package com.metro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metro.domain.StationVO;

@Repository("stationDAO")
public class StationDAOImpl implements StationDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<StationVO> selectStationByName(String stationName) {
		
		return mybatis.selectList("station.selectStationByName", stationName);		
	}

}
