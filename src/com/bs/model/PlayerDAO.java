package com.bs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class PlayerDAO {
	
	private Connection con = null;
	private Statement stat = null;
	
	public PlayerDAO() {
		
		try{
			//DB연결
			stat = DBUtil.connect().createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 타자 비교선수 목록 가져오기(CompareList.java)
	 */
	public ArrayList<CompareDTO> compareList() {
		ArrayList<CompareDTO> list = new ArrayList<CompareDTO>();
		
		try {
			String sql = "select p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits,sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops,sum(b.rbi) as rbi, sum(b.fourBall) as fourBall from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = 1 group by p.playerId, p.playerName order by playerId asc";
			
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				CompareDTO dto = new CompareDTO();
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setAtBat(rs.getInt("atBat"));
				dto.setHits(rs.getInt("hits"));
				dto.setHomeRun(rs.getInt("homeRun"));
				dto.setStill(rs.getInt("still"));
				dto.setSamjin(rs.getInt("samjin"));
				dto.setBattingAverage(rs.getDouble("battingAverage"));
				dto.setOnBase(rs.getDouble("onBase"));
				dto.setSlugging(rs.getDouble("slugging"));
				dto.setOps(rs.getDouble("ops"));
				dto.setRbi(rs.getInt("rbi"));
				dto.setFourBall(rs.getInt("fourBall"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}
	
	public ArrayList<CompareDTO> compareList3(String teamId) { 
		ArrayList<CompareDTO> list = new ArrayList<CompareDTO>();
		
		try {
			String sql = "select p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits,sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops,sum(b.rbi) as rbi, sum(b.fourBall) as fourBall from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = "+teamId+" group by p.playerId, p.playerName order by playerId asc";
			
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				CompareDTO dto = new CompareDTO();
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setAtBat(rs.getInt("atBat"));
				dto.setHits(rs.getInt("hits"));
				dto.setHomeRun(rs.getInt("homeRun"));
				dto.setStill(rs.getInt("still"));
				dto.setSamjin(rs.getInt("samjin"));
				dto.setBattingAverage(rs.getDouble("battingAverage"));
				dto.setOnBase(rs.getDouble("onBase"));
				dto.setSlugging(rs.getDouble("slugging"));
				dto.setOps(rs.getDouble("ops"));
				dto.setRbi(rs.getInt("rbi"));
				dto.setFourBall(rs.getInt("fourBall"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}

	
	//투수비교 목록 가져오기
	public ArrayList<CompareDTO2> compareList2(String teamId) {
		ArrayList<CompareDTO2> list = new ArrayList<CompareDTO2>();
		
		try {
			
			String sql = "select p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pInning) as pInning, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun, sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, avg(pr.pBangEo) as pBangEo from player p inner join pitcherRecord pr on p.playerId = pr.playerId where p.teamId="+teamId+" group by p.playerId, p.playerName order by playerId asc";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				CompareDTO2 dto = new CompareDTO2();
				
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setpWin(rs.getInt("pWin"));
				dto.setpLose(rs.getInt("pLose"));
				dto.setpSave(rs.getInt("pSave"));
				dto.setpHold(rs.getInt("pHold"));
				dto.setpInning(rs.getInt("pInning"));
				dto.setpAnta(rs.getInt("pAnta"));
				dto.setpHomerun(rs.getInt("pHomerun"));
				dto.setpBallnet(rs.getInt("pBallnet"));
				dto.setpSamjin(rs.getInt("pSamjin"));
				dto.setpJacheck(rs.getInt("pJacheck"));
				dto.setpBangEo(rs.getDouble("pBangEo"));
			
				
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public ArrayList<CompareDTO> compareList(String first, String second) {
		
		ArrayList<CompareDTO> list = new ArrayList<CompareDTO>();
		
		
		try {
			String sql = "select p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits,sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops,sum(b.rbi) as rbi, sum(b.fourBall) as fourBall from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = "+first+" group by p.playerId, p.playerName order by still desc, homerun desc, battingAverage desc";
			
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				CompareDTO dto = new CompareDTO();
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setAtBat(rs.getInt("atBat"));
				dto.setHits(rs.getInt("hits"));
				dto.setHomeRun(rs.getInt("homeRun"));
				dto.setStill(rs.getInt("still"));
				dto.setSamjin(rs.getInt("samjin"));
				dto.setBattingAverage(rs.getDouble("battingAverage"));
				dto.setOnBase(rs.getDouble("onBase"));
				dto.setSlugging(rs.getDouble("slugging"));
				dto.setOps(rs.getDouble("ops"));
				dto.setRbi(rs.getInt("rbi"));
				dto.setFourBall(rs.getInt("fourBall"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;

	}
}












