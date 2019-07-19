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
import com.metro.dao.MgtDAO;
import com.metro.domain.CsVO;
import com.metro.domain.MemberVO;
import com.metro.domain.StationVO;
import com.metro.domain.TrainVO;

@Service("mgtService")
public class MgtServiceImpl implements MgtService {

	private static String apiKey = "5651457766776f6f38366244585056";
	private static String apiUrl = "http://openapi.seoul.go.kr:8088/";
	private static String qString = "/json/octastatapi262/1/5/";
	private static String sName = "";
	
	private static int perPage = 10;

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

	/**
	 * 회원 목록
	 */
	@Override
	public List<MemberVO> getMembers() {
		
		return mgtDAO.selectAllMember();
	}

	/**
	 * 역 목록
	 */
	@Override
	public List<StationVO> getStations() {
		
		return mgtDAO.selectAllStation();
	}

	/**
	 * 공지 목록
	 */
	@Override
	public List<CsVO> getNotice() {
		
		return mgtDAO.selectAllNotice();
	}

	/**
	 * 출구 정보
	 */
	@Override
	public String getExitInfo(String stationCode) {
		String result = new Gson().toJson(mgtDAO.selectExitInfo(stationCode));	// JSON 비동기 전송
		return result;
	}

	/**
	 * 검색어, 페이지, 노선 포함 역 목록 조회
	 */
	@Override
	public String getStations(String searchWord, int page, String line) {
		int startIndex = (page - 1) * perPage + 1;
		int endIndex = startIndex + perPage -1;
		Map map = new HashMap();
		map.put("searchWord", searchWord);
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		map.put("line", line);
		String result = new Gson().toJson(mgtDAO.selectStations(map));
		return result;
	}

	/**
	 * 조회용 역 코드 검색
	 */
	@Override
	public String getStationCode(String stationCode) {
		
		return mgtDAO.selectStationCode(stationCode);
	}

	/**
	 * 페이지 기준 역 목록
	 */
	@Override
	public List<StationVO> getStations(int page) {
		int startIndex = (page - 1) * perPage + 1;
		int endIndex = startIndex + perPage -1;
		return mgtDAO.selectStations(startIndex, endIndex);
	}

	/**
	 * 열차 스케줄 조회 (역 기준)
	 */
	@Override
	public List<TrainVO> getSchedule() {
		String pathVariable = "/json/SearchSTNTimeTableByIDService/1/";		// api name
		String count = "1/";												// 데이타 수
		String stationCode = "0151";										// 역 코드
		String weekCode = "/1";												// 요일 구분
		String directionCode = "/1/";										// 열차 방향
		
		URL url;
		
		try {	// api 호출한 값 json으로 처리하는 테스트
			url = new URL(apiUrl + apiKey + pathVariable + count + stationCode + weekCode + directionCode);

			HttpURLConnection connection;

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();

			BufferedReader json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));          

			// JSON 객체로 변환
			JsonObject train = new Gson().fromJson(json, JsonObject.class);

			// 객체 내 전체 데이타 값 추출
			String totalCount = train.getAsJsonObject("SearchSTNTimeTableByIDService").get("list_total_count").getAsString() + "/";  
			
			connection.disconnect();
			
			// 전체 데이타 조회 용
			url = new URL(apiUrl + apiKey + pathVariable + totalCount + stationCode + weekCode + directionCode); 
			
			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();
			
			json  = new BufferedReader(new InputStreamReader(connection.getInputStream()));          

			train = new Gson().fromJson(json, JsonObject.class);
			
			// 스케줄 리스트 추출
			JsonArray schedule = train.getAsJsonObject("SearchSTNTimeTableByIDService").get("row").getAsJsonArray();
			
			// 리턴용 객체 리스트
			List<TrainVO> trainVO = new ArrayList<TrainVO>();
			
			for(int i=0; i < schedule.size(); i++){
				
				// 리스트 용 입력 항목으로 전환				
				JsonObject obj = schedule.get(i).getAsJsonObject();
				TrainVO vo = new TrainVO();
				vo.setStationCode(obj.get("STATION_CD").getAsString());
				vo.setStationName(obj.get("STATION_NM").getAsString());
				vo.setTrainCode(obj.get("TRAIN_NO").getAsString());
				vo.setArrivalTime(obj.get("ARRIVETIME").getAsString());
				vo.setWeekCode(obj.get("WEEK_TAG").getAsInt());
				vo.setDestinationName(obj.get("SUBWAYENAME").getAsString());
				vo.setDirectionCode(obj.get("INOUT_TAG").getAsInt());
				vo.setTrainType(obj.get("EXPRESS_YN").getAsCharacter());
				vo.setBranchLine(obj.get("BRANCH_LINE").getAsString());
				trainVO.add(vo);
			}
			return trainVO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
