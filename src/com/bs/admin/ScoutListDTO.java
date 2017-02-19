package com.bs.admin;

import javax.servlet.http.HttpServlet;

public class ScoutListDTO extends HttpServlet{
	
	private String playerId; 	//선수id
	private String playerName;	//선수명
	private int salary;	//연봉
	
	//투수리스트
	private int pWin;		//승	
	private int pLose;		//패
	private int pSave;		//세이브
	private int pHold;		//홀드
	private double pInning;//이닝
	private int pAnta;		//피안타
	private int pHomerun;	//피홈런
	private int pBallnet;	//볼넷
	private int pSamjin;	//탈삼진	
	private double pBangEo;//방어율
	private double whip;	//WHIP
	
	
	//타자리스트
	private int atBat; 		//타수
	private int hits;			//안타
	private int homeRun;		//홈런
	private int still;			//도루
	private int samJin;		//삼진
	private int fourBall;		//볼넷
	private double battingAverage;//타율
	private double onBase;		//출루율
	private double slugging;	//장타율
	private double ops;		//ops
	private int error;		//실책
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
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
	public int getpWin() {
		return pWin;
	}
	public void setpWin(int pWin) {
		this.pWin = pWin;
	}
	public int getpLose() {
		return pLose;
	}
	public void setpLose(int pLose) {
		this.pLose = pLose;
	}
	public int getpSave() {
		return pSave;
	}
	public void setpSave(int pSave) {
		this.pSave = pSave;
	}
	public int getpHold() {
		return pHold;
	}
	public void setpHold(int pHold) {
		this.pHold = pHold;
	}
	public double getpInning() {
		return pInning;
	}
	public void setpInning(double pInning) {
		this.pInning = pInning;
	}
	public int getpAnta() {
		return pAnta;
	}
	public void setpAnta(int pAnta) {
		this.pAnta = pAnta;
	}
	public int getpHomerun() {
		return pHomerun;
	}
	public void setpHomerun(int pHomerun) {
		this.pHomerun = pHomerun;
	}
	public int getpBallnet() {
		return pBallnet;
	}
	public void setpBallnet(int pBallnet) {
		this.pBallnet = pBallnet;
	}
	public int getpSamjin() {
		return pSamjin;
	}
	public void setpSamjin(int pSamjin) {
		this.pSamjin = pSamjin;
	}
	public double getpBangEo() {
		return pBangEo;
	}
	public void setpBangEo(double pBangEo) {
		this.pBangEo = pBangEo;
	}
	public double getWhip() {
		return whip;
	}
	public void setWhip(double whip) {
		this.whip = whip;
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
	public int getSamJin() {
		return samJin;
	}
	public void setSamJin(int samJin) {
		this.samJin = samJin;
	}
	public int getFourBall() {
		return fourBall;
	}
	public void setFourBall(int fourBall) {
		this.fourBall = fourBall;
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
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	
	
	
	
}
