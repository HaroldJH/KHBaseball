package com.bs.model;

public class PlayerDTO { //선수 DTO
	
	private int playerId; //선수 id
	private int teamId; //팀 id
	private String playerKind; //선수 종류
	private String playerName; //선수 이름
	private int salary; // 연봉
	private int backNum; //등번호
	private int pMatches; //경기수
	private String isPosu; //포수 여부?
	private String playerFace; //선수 얼굴
	private int isActive; //구단 소속(1), 무소속(0)
	
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	
	public String getPlayerKind() {
		return playerKind;
	}
	public void setPlayerKind(String playerKind) {
		this.playerKind = playerKind;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBackNum() {
		return backNum;
	}
	public void setBackNum(int backNum) {
		this.backNum = backNum;
	}
	public int getpMatches() {
		return pMatches;
	}
	public void setpMatches(int pMatches) {
		this.pMatches = pMatches;
	}
	public String getIsPosu() {
		return isPosu;
	}
	public void setIsPosu(String isPosu) {
		this.isPosu = isPosu;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getPlayerFace() {
		return playerFace;
	}
	public void setPlayerFace(String playerFace) {
		this.playerFace = playerFace;
	}
	
	
	
	
}
