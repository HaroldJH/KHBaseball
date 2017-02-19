/**
 * 
 */
package com.bs.cast;

/**
 * @author YJH
 *
 */
public class BatterRecordDTO {
	private int batterRecordId;
	private String playDate;
	private int playerId;
	private int bat;
	private int atBat;
	private int hits;
	private int twoHit;
	private int threeHit;
	private int homeRun;
	private int still;
	private int fourBall;
	private int samjin;
	private int doublePlay;
	private int battingAverage;
	private int onBase;
	private int Slugging;
	private int OPS;
	private int error;
	private int score;
	private int RBI;
	
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRBI() {
		return RBI;
	}
	public void setRBI(int rBI) {
		RBI = rBI;
	}
	public int getBatterRecordId() {
		return batterRecordId;
	}
	public void setBatterRecordId(int batterRecordId) {
		this.batterRecordId = batterRecordId;
	}
	public String getPlayDate() {
		return playDate;
	}
	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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
		return Slugging;
	}
	public void setSlugging(int slugging) {
		Slugging = slugging;
	}
	public int getOPS() {
		return OPS;
	}
	public void setOPS(int oPS) {
		OPS = oPS;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
}
