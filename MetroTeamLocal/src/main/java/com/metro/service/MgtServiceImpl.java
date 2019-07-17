package com.metro.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.metro.dao.MgtDAO;
import com.metro.domain.CsVO;
import com.metro.domain.MemberVO;
import com.metro.domain.StationVO;

@Service("mgtService")
public class MgtServiceImpl implements MgtService {

	private static String apiKey = "5651457766776f6f38366244585056";
	private static String apiUrl = "http://openapi.seoul.go.kr:8088/";
	private static String qString = "/json/octastatapi262/1/5/";
	private static String sName = "";

	@Autowired
	private MgtDAO mgtDAO;
	
	@Override
	public int updateLines() {
		
		URL url;
		
		try {	// api 호출한 값 json으로 처리하는 테스트
			url = new URL(apiUrl + apiKey + qString + sName);

			HttpURLConnection connection;

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();

			BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));          

			JsonObject train = new Gson().fromJson(json, JsonObject.class);

			System.out.println("Id: " + train.getAsJsonObject("octastatapi262").get("row").toString());  
			
			connection.disconnect();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int addKey(String apiKey) {			// apiKey 추가등록
		int result = mgtDAO.insertKey(apiKey);
		return result;
	}

	@Override
	public List<MemberVO> getMembers() {
		
		return mgtDAO.selectAllMember();
	}

	@Override
	public List<StationVO> getStations() {
		
		return mgtDAO.selectAllStation();
	}

	@Override
	public List<CsVO> getNotice() {
		
		return mgtDAO.selectAllNotice();
	}

	@Override
	public String getExitInfo(String stationCode) {
		String result = new Gson().toJson(mgtDAO.selectExitInfo(stationCode));
		return result;
	}

	@Override
	public String getStations(String searchWord) {
		String result = new Gson().toJson(mgtDAO.selectStations(searchWord));
		return result;
	}

	@Override
	public String getStationCode(String stationCode) {
		
		return mgtDAO.selectStationCode(stationCode);
	}

}
