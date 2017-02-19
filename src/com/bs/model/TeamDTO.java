package com.bs.model;

public class TeamDTO { // 구단 DTO
	
	private int teamId; //팀 id
	private String teamName; //팀 이름
	private String teamCoach; //감독
	private String groundName; // 구장 이름
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCoach() {
		return teamCoach;
	}
	public void setTeamCoach(String teamCoach) {
		this.teamCoach = teamCoach;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	
	
	

}
