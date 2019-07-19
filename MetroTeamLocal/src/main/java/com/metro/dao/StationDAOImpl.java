package com.metro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("stationDAO")
public class StationDAOImpl implements StationDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<String> selectStationByName(String stationName) {
		
		return mybatis.selectList("station.selectByName", stationName);		
	}

}
