package com.bs.model;

import java.sql.Date;

public class PitcherRecordDTO { //투수 성적 DTO
	
	private int pitcherRecordId; // 투수 성적 id
	private Date playDate; //경기 일자
	private int pWin; //승
	private int pLose; //패
	private int pSave; //세이브
	private int pHold; //홀드
	private int pInning; //이닝
	private int pToogoosoo; //투구수
	private int pAnta; //피안타
	private int pHomerun; //피홈런
	private int pSiljum; // 실점
	private int pSamjin; // 삼진
	private int pBallnet; //볼넷
	private int pJacheck; //자책점
	private int pBangEo; // 방어율
	private int whip; //WHIP
	private int perr; //실책
	private int playerId; //선수 id , 참조값
	
	
	public int getPitcherRecordId() {
		return pitcherRecordId;
	}
	public void setPitcherRecordId(int pitcherRecordId) {
		this.pitcherRecordId = pitcherRecordId;
	}
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
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
	public int getpInning() {
		return pInning;
	}
	public void setpInning(int pInning) {
		this.pInning = pInning;
	}
	public int getpToogoosoo() {
		return pToogoosoo;
	}
	public void setpToogoosoo(int pToogoosoo) {
		this.pToogoosoo = pToogoosoo;
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
	public int getpSiljum() {
		return pSiljum;
	}
	public void setpSiljum(int pSiljum) {
		this.pSiljum = pSiljum;
	}
	public int getpSamjin() {
		return pSamjin;
	}
	public void setpSamjin(int pSamjin) {
		this.pSamjin = pSamjin;
	}
	public int getpBallnet() {
		return pBallnet;
	}
	public void setpBallnet(int pBallnet) {
		this.pBallnet = pBallnet;
	}
	public int getpJacheck() {
		return pJacheck;
	}
	public void setpJacheck(int pJacheck) {
		this.pJacheck = pJacheck;
	}
	public int getpBangEo() {
		return pBangEo;
	}
	public void setpBangEo(int pBangEo) {
		this.pBangEo = pBangEo;
	}
	public int getWhip() {
		return whip;
	}
	public void setWhip(int whip) {
		this.whip = whip;
	}
	public int getPerr() {
		return perr;
	}
	public void setPerr(int perr) {
		this.perr = perr;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
}













