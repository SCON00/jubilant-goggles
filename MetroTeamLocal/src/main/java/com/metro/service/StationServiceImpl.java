package com.metro.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.metro.dao.StationDAO;
import com.metro.domain.StationVO;


@Service("stationService")
public class StationServiceImpl implements StationService{
	
	@Autowired
	private StationDAO stationDAO;
	
	@Override
	public StationVO stationInfo(String stationName) {
		
		
		// 해당 역 코드 전체 조회
		List<String> result = stationDAO.selectStationByName(stationName);
		System.out.println(result.get(0).toString());
		String apiUrl = 
				"http://openapi.seoul.go.kr:8088/5651457766776f6f38366244585056/json/SearchLocationOfSTNByIDService/1/5/" 
						+ result.get(0);
		URL url;
		
		try {	// api 호출한 값 json으로 처리하는 테스트
			url = new URL(apiUrl);

			HttpURLConnection connection;

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();

			BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));          

			JsonObject train = new Gson().fromJson(json, JsonObject.class);

			System.out.println("Id: " + train.getAsJsonObject("SearchLocationOfSTNByIDService").get("row").toString());  
			
			connection.disconnect();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
