package com.metro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metro.domain.CsVO;
import com.metro.domain.MemberVO;
import com.metro.domain.StationVO;

@Repository("mgtDAO")
public class MgtDAOImpl implements MgtDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	/**
	 * api 키 저장
	 */
	@Override
	public int insertKey(String apiKey) {		
		int result = mybatis.insert("mgt.insertKey", apiKey);
		return result;
	}

	/**
	 * 회원 목록 전체 조회
	 */
	@Override
	public List<MemberVO> selectAllMember() {
		return mybatis.selectList("mgt.selectMember");
	}

	/**
	 * 역 목록 전체 조회
	 */
	@Override
	public List<StationVO> selectAllStation() {
		return mybatis.selectList("mgt.selectStation");
		
	}

	/**
	 * 공지 사항 전체 조회
	 */
	@Override
	public List<CsVO> selectAllNotice() {		
		return mybatis.selectList("mgt.selectNotice");
	}

	/**
	 * 역 출구정보 조회
	 */
	@Override
	public Map selectExitInfo(String stationCode) {
		
		// stations 테이블에서 역이름 조회
		String stationName = mybatis.selectOne("mgt.selectByStationCode", stationCode);
		// station_exits 테이블에서 출구번호 조회
		List<String> list = mybatis.selectList("mgt.selectExitNumber", stationName);
		
		Map dataMap = new HashMap(); 
		
		for(String s : list) {
			
			Map map = new HashMap();
			
			map.put("stationName", stationName);
			map.put("exitNumber", s);
			
			// 출구별 정보조회
			List<String> data = mybatis.selectList("mgt.selectExitInfo", map);
			dataMap.put(s, data.toString());
		}
		return dataMap;
	}

	/**
	 * 검색어, 페이지, 노선별 역 목록 조회
	 */
	@Override
	public List<StationVO> selectStations(Map map) {
		
		return mybatis.selectList("mgt.selectStation", map);
	}

	/**
	 * 조회용 역 코드 검색
	 */
	@Override
	public String selectStationCode(String stationCode) {
		
		return mybatis.selectOne("mgt.selectStationCode", stationCode);
	}

	/**
	 * 페이지 내 역 목록 조회
	 */
	@Override
	public List<StationVO> selectStations(int startIndex, int endIndex) {
		Map map = new HashMap();
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		return mybatis.selectList("mgt.selectStation", map);
	}

	
}
