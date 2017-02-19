package com.bs.model;

import java.sql.Date;

public class BatterRecordDTO { //타자 성적 DTO
	
	private int batterRecordId; //타자성적 id
	private Date playDate;	//경기일자 //Date -> sql
	private int bat; // 타석
	private int atBat; //타수
	private int hits; //안타
	private int twoHit; // 2루타
	private int threeHit; // 3루타
	private int homeRun; // 홈런
	private int rbi; // 타점
	private int score; // 득점
	private int still; // 도루
	private int fourBall; //볼넷
	private int samjin; //삼진
	private int doublePlay; //병살
	private int battingAverage; //타율
	private int onBase; //출루율
	private int slugging; //장타율
	private int ops; //OPS
	private int error; //실책
	private int playerId; //선수 id , 참조값
	
	
	public int getBatterRecordId() {
		return batterRecordId;
	}
	public void setBatterRecordId(int batterRecordId) {
		this.batterRecordId = batterRecordId;
	}
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	public int getBat() {
		return bat;
	}
	public void setBat(int bat) {
		this.bat = bat;
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
	public int getTwoHit() {
		return twoHit;
	}
	public void setTwoHit(int twoHit) {
		this.twoHit = twoHit;
	}
	public int getThreeHit() {
		return threeHit;
	}
	public void setThreeHit(int threeHit) {
		this.threeHit = threeHit;
	}
	public int getHomeRun() {
		return homeRun;
	}
	public void setHomeRun(int homeRun) {
		this.homeRun = homeRun;
	}
	public int getRbi() {
		return rbi;
	}
	public void setRbi(int rbi) {
		this.rbi = rbi;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStill() {
		return still;
	}
	public void setStill(int still) {
		this.still = still;
	}
	public int getFourBall() {
		return fourBall;
	}
	public void setFourBall(int fourBall) {
		this.fourBall = fourBall;
	}
	public int getSamjin() {
		return samjin;
	}
	public void setSamjin(int samjin) {
		this.samjin = samjin;
	}
	public int getDoublePlay() {
		return doublePlay;
	}
	public void setDoublePlay(int doublePlay) {
		this.doublePlay = doublePlay;
	}
	public int getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(int battingAverage) {
		this.battingAverage = battingAverage;
	}
	public int getOnBase() {
		return onBase;
	}
	public void setOnBase(int onBase) {
		this.onBase = onBase;
	}
	public int getSlugging() {
		return slugging;
	}
	public void setSlugging(int slugging) {
		this.slugging = slugging;
	}
	public int getOps() {
		return ops;
	}
	public void setOps(int ops) {
		this.ops = ops;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
}

















