package com.metro.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.metro.dao.StationDAO;
import com.metro.domain.StationVO;


@Service("stationService")
public class StationServiceImpl implements StationService{
	
	@Autowired
	private StationDAO stationDAO;
	
	@Override
	public StationVO stationInfo(String stationCode) {
		
		System.out.println("StationServiceImpl.stationInfo :IN");
		
		// 해당 역 정보 코드로 조회
		StationVO vo = stationDAO.selectStationByID(stationCode);
		
		String apiUrl = 
				"http://openapi.seoul.go.kr:8088/447a617656776f6f34366b6b554177/json/SearchSTNInfoByIDService/1/5/" 
						+ stationCode;
		URL url;
		
		try {	// 지하철 역 정보 api 호출
			url = new URL(apiUrl);

			HttpURLConnection connection;

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();

			BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));          

			JsonObject train = new Gson().fromJson(json, JsonObject.class);
			
			JsonArray result = train.getAsJsonObject("SearchSTNInfoByIDService").get("row").getAsJsonArray();
			
			int count = train.getAsJsonObject("SearchSTNInfoByIDService").get("list_total_count").getAsInt();
						
			connection.disconnect();	
			
			return toStationVO(vo, result.get(count-1).getAsJsonObject());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			System.out.println("StationServiceImpl.stationInfo :OUT");
		}
		
		return vo;
	}

	private StationVO toStationVO(StationVO vo, JsonObject jo) {

		// 편의시설 한글 변환
		Map<String, String> usefulMap = new HashMap<String, String>();
		usefulMap.put("MINWON", "현장민원소");
		usefulMap.put("INFOTESK", "관광안내소");
		usefulMap.put("CULTURE", "문화공간");
		usefulMap.put("TICKET", "항공권판매");
		usefulMap.put("OBSTACLE", "장애인시설");
		usefulMap.put("MEETPLACE", "만남의장소");
		usefulMap.put("PARKING", "주차장");
		usefulMap.put("BICYCLE", "자전거보관소");
		usefulMap.put("MUIN", "무인민원발급기");
		usefulMap.put("OFFICE", "역무실");
		usefulMap.put("NURSING", "수유방");
		usefulMap.put("ELEVATOR", "엘레베이터");
		usefulMap.put("ESCALATOR", "에스컬레이터");
		usefulMap.put("WHEELCHAIR", "휠체어리프트시설");
		usefulMap.put("SPEEDNATE", "스피드게이트");
		
		vo.setsPhone(jo.get("TEL").getAsString());				
		vo.setsAddress(jo.get("ADDRESS").getAsString());
		vo.setUre(jo.get("URE").getAsString());
		
		// 편의시설 객체 저장
		List<String> usefulList = new ArrayList<String>();
		for(String key : jo.keySet()) {
			if("Y".equals(jo.get(key).getAsString())) {
				
				usefulList.add(usefulMap.get(key));
			}
		};
		vo.setUseful(usefulList.toString());
		
		vo.setsToilet(jo.get("TOILET").getAsString());
		vo.setxCoord(jo.get("XPOINT_WGS").getAsString());
		vo.setyCoord(jo.get("YPOINT_WGS").getAsString());
		
		return vo;
	}

	@Override
	public Map<String,String> getExitInfo(String stationCode) {
		
		return stationDAO.selectExitInfo(stationCode);
	}

	@Override
	public Map<String, List<StationVO>> getLineList(String stationCode) {
		
		return stationDAO.selectLines(stationCode);
	}
}
