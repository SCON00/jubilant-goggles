package com.metro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.dao.StationDAO;


@Service("stationService")
public class StationServiceImpl implements StationService{
	
	@Autowired
	private StationDAO stationDAO;
	
	@Override
	public int stationInfo(String stationName) {
		
		System.out.println(stationName + ": Service");
		int result = stationDAO.selectStationByName(stationName);
		return result;
	}

}
