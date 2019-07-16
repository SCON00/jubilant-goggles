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
	public String selectStationByName(String stationName) {
		System.out.println(stationName + ": DAO");
		Map<String, String> map = new HashMap<String, String>();
		map.put("stationName", stationName);
		List<String> list = mybatis.selectList("station.selectByName", map);
		String result = "";
		for(String s : list) {
			result += "<" + s + ">";			
		}
		System.out.println(result);
		return result;
	}

}
