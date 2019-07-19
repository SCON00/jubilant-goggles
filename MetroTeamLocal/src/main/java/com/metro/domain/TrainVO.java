package com.metro.domain;

public class TrainVO {

	private String stationCode;
	private String stationName;
	private String trainCode;
	private String arrivalTime;
	private String destinationName;
	private char trainType;					// G : 일반, ㅇ : 급행
	private int weekCode;					// 1 : 평일, 2 : 토, 3 : 일/휴일
	private int directionCode;				// 1 : 상행,내선 2 : 하행,외선
	private String branchLine;				// 지선 ...
	
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
	public String getTrainCode() {
		return trainCode;
	}
	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public char getTrainType() {
		return trainType;
	}
	public void setTrainType(char trainType) {
		this.trainType = trainType;
	}
	public int getWeekCode() {
		return weekCode;
	}
	public void setWeekCode(int weekCode) {
		this.weekCode = weekCode;
	}
	public int getDirectionCode() {
		return directionCode;
	}
	public void setDirectionCode(int directionCode) {
		this.directionCode = directionCode;
	}
	public String getBranchLine() {
		return branchLine;
	}
	public void setBranchLine(String branchLine) {
		this.branchLine = branchLine;
	}
	
	
}
