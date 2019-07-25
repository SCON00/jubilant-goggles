package com.metro.domain;

import java.util.Map;

public class StationVO {

	private String stationCode;				// 역코드 - 복수 존재
	private String stationName;				// 역명 - 테이블마다 다를 수 있다
	private String stationNameEng;			// 영문명
	private String line;					// 호선
	private String fCode;					// 외부코드
	private String xCoord;					// X 좌표
	private String yCoord;					// Y 좌표
	private String ure;						// 설명
	private String useful;					// 편의시설
	private String sAddress;				// 역 주소
	private String sAddressEng;				// 영문 주소 - 안중요
	private String sPhone;					// 전화번호
	private String sToilet;					// 화장실 구조
	private Map<String,String> sExits;		// 출구별 정보
	
	public Map<String,String> getsExits() {
		return sExits;
	}
	public void setsExits(Map<String,String> sExits) {
		this.sExits = sExits;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationNameEng() {
		return stationNameEng;
	}
	public void setStationNameEng(String stationNameEng) {
		this.stationNameEng = stationNameEng;
	}
	
	public String getfCode() {
		return fCode;
	}
	public void setfCode(String fCode) {
		this.fCode = fCode;
	}
	public String getxCoord() {
		return xCoord;
	}
	public void setxCoord(String xCoord) {
		this.xCoord = xCoord;
	}
	public String getyCoord() {
		return yCoord;
	}
	public void setyCoord(String yCoord) {
		this.yCoord = yCoord;
	}
	public String getUre() {
		return ure;
	}
	public void setUre(String ure) {
		this.ure = ure;
	}
	public String getUseful() {
		return useful;
	}
	public void setUseful(String useful) {
		this.useful = useful;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getsAddressEng() {
		return sAddressEng;
	}
	public void setsAddressEng(String sAddressEng) {
		this.sAddressEng = sAddressEng;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsToilet() {
		return sToilet;
	}
	public void setsToilet(String sToilet) {
		this.sToilet = sToilet;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	
	
}
