package com.bs.model;

import java.sql.Date;

public class CompareDTO {

	private String playerName;
	private int atBat; //타수
	private int hits; //안타
	private int homeRun; // 홈런
	private int still; // 도루
	private int samjin; //삼진
	private double battingAverage; //타율
	private double onBase; //출루율
	private double slugging; //장타율
	private double ops; //OPS
	private int playerId; //선수 id , 참조값
	private int rbi; //RBI
	private int fourBall; // 타자 볼넷
	
	
	
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getAtBat() {
		return atBat;
	}
	public void setAtBat(int atBat) {
		this.atBat = atBat;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getHomeRun() {
		return homeRun;
	}
	public void setHomeRun(int homeRun) {
		this.homeRun = homeRun;
	}
	public int getStill() {
		return still;
	}
	public void setStill(int still) {
		this.still = still;
	}
	public int getSamjin() {
		return samjin;
	}
	public void setSamjin(int samjin) {
		this.samjin = samjin;
	}
	
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}
	public double getOnBase() {
		return onBase;
	}
	public void setOnBase(double onBase) {
		this.onBase = onBase;
	}
	public double getSlugging() {
		return slugging;
	}
	public void setSlugging(double slugging) {
		this.slugging = slugging;
	}
	public double getOps() {
		return ops;
	}
	public void setOps(double ops) {
		this.ops = ops;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getRbi() {
		return rbi;
	}
	public void setRbi(int rbi) {
		this.rbi = rbi;
	}
	public int getFourBall() {
		return fourBall;
	}
	public void setFourBall(int fourBall) {
		this.fourBall = fourBall;
	}
	
	
}
