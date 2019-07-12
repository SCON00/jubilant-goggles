package com.metro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("stationDAO")
public class StationDAOImpl implements StationDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public int selectStationByName(String stationName) {
		System.out.println(stationName + ": DAO");
		Map<String, String> map = new HashMap<String, String>();
		map.put("stationName", stationName);
		List<String> list = mybatis.selectList("station.selectByName", map);
		for(String s : list) {
			System.out.println(s);
		}
		return 0;
	}

}
