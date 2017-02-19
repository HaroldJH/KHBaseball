package com.bs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class CompareDAO {
	private Connection con = null;
	private Statement stat = null;
	
	public CompareDAO() {
		
		try{
			
			//DB연결
			stat = DBUtil.connect().createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<TeamCompareDTO> teamCompare() {
		ArrayList<TeamCompareDTO> list = new ArrayList<>();
		
		try {
			String sql = "select avg(tr.win) as win, avg(tr.draw) as draw, avg(tr.lose) as lose, avg(tr.ranking) as ranking, te.teamName, to_char(avg(b.battingAverage),'0.000') as battingAverage, to_char(avg(tr.win/tr.gameNum), '0.00') as winrate, sum(b.homerun) as homerun, to_char(avg(b.error),'0.999') as error, avg(gameNum) as gameNum from batterRecord b inner join player p on p.playerId = b.playerId inner join team te on te.teamId = p.teamId inner join teamRank tr on tr.teamId = te.teamId where te.teamId=1 or te.teamId=2 group by te.teamName order by ranking";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				TeamCompareDTO dto = new TeamCompareDTO();
				
				dto.setTeamName(rs.getString("teamName"));
				dto.setWin(rs.getString("win"));
				dto.setDraw(rs.getString("draw"));
				dto.setLose(rs.getString("lose"));
				dto.setBattingAverage(rs.getDouble("battingAverage"));
				dto.setWinrate(rs.getDouble("winrate"));
				dto.setHomerun(rs.getString("homerun"));
				dto.setRanking(rs.getString("ranking"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<TeamCompareDTO> teamCompare2() {
		ArrayList<TeamCompareDTO> list = new ArrayList<>();
		
		try {
			String sql = "select avg(tr.win) as win, avg(tr.draw) as draw, avg(tr.lose) as lose, avg(tr.ranking) as ranking, te.teamName, to_char(avg(b.battingAverage),'0.000') as battingAverage, to_char(avg(tr.win/tr.gameNum), '0.00') as winrate, sum(b.homerun) as homerun, to_char(avg(b.error),'0.999') as error, avg(gameNum) as gameNum from batterRecord b inner join player p on p.playerId = b.playerId inner join team te on te.teamId = p.teamId inner join teamRank tr on tr.teamId = te.teamId where te.teamId=3 or te.teamId=4 group by te.teamName order by ranking";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				TeamCompareDTO dto = new TeamCompareDTO();
				
				dto.setTeamName(rs.getString("teamName"));
				dto.setWin(rs.getString("win"));
				dto.setDraw(rs.getString("draw"));
				dto.setLose(rs.getString("lose"));
				dto.setBattingAverage(rs.getDouble("battingAverage"));
				dto.setWinrate(rs.getDouble("winrate"));
				dto.setHomerun(rs.getString("homerun"));
				dto.setRanking(rs.getString("ranking"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public CompareDTO2 pitcher() {
		ArrayList<CompareDTO2> list = new ArrayList<>();
		int temp = 0;
		
		try {
			String sql = "select * from (select p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pInning) as pInning, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun,  sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, to_char(avg(pr.pBangEo),'0.00') as pBangEo from player p inner join pitcherRecord pr on p.playerId = pr.playerId where p.teamId=1 group by p.playerId, p.playerName order by playerId asc)";
			
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
			
			double bangEo = 0;
			for(int i=0; i<list.size(); i++){
				bangEo = list.get(0).getpBangEo();
				if(list.get(i).getpBangEo() < bangEo){
					temp = i;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list.get(temp);
	}
	
	public CompareDTO2 pitcher2() {
		ArrayList<CompareDTO2> list = new ArrayList<>();
		int temp = 0;
		
		try {
			String sql = "select * from (select p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pInning) as pInning, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun,  sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, to_char(avg(pr.pBangEo),'0.00') as pBangEo from player p inner join pitcherRecord pr on p.playerId = pr.playerId where p.teamId=2 group by p.playerId, p.playerName order by playerId asc)";
			
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
			
			double bangEo = 0;
			for(int i=0; i<list.size(); i++){
				bangEo = list.get(0).getpBangEo();
				if(list.get(i).getpBangEo() < bangEo){
					temp = i;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list.get(temp);
	}
	
	public CompareDTO2 pitcher3() {
		ArrayList<CompareDTO2> list = new ArrayList<>();
		int temp = 0;
		
		try {
			String sql = "select * from (select p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun,  sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, to_char(avg(pr.pBangEo),'0.00') as pBangEo from player p inner join pitcherRecord pr on p.playerId = pr.playerId where p.teamId=4 group by p.playerId, p.playerName order by playerId asc)";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				CompareDTO2 dto = new CompareDTO2();
				
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setpWin(rs.getInt("pWin"));
				dto.setpLose(rs.getInt("pLose"));
				dto.setpSave(rs.getInt("pSave"));
				dto.setpHold(rs.getInt("pHold"));
				dto.setpAnta(rs.getInt("pAnta"));
				dto.setpHomerun(rs.getInt("pHomerun"));
				dto.setpBallnet(rs.getInt("pBallnet"));
				dto.setpSamjin(rs.getInt("pSamjin"));
				dto.setpJacheck(rs.getInt("pJacheck"));
				dto.setpBangEo(rs.getDouble("pBangEo"));
				
				list.add(dto);
			}
			
			double bangEo = 0;
			for(int i=0; i<list.size(); i++){
				bangEo = list.get(0).getpBangEo();
				if(list.get(i).getpBangEo() < bangEo){
					temp = i;
				}
			}
			
			System.out.println("pitcher3 : " + sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.get(temp);
	}
	
	public CompareDTO2 pitcher4() {
		ArrayList<CompareDTO2> list = new ArrayList<>();
		int temp = 0;
		
		try {
			String sql = "select * from (select p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun,  sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, to_char(avg(pr.pBangEo),'0.00') as pBangEo from player p inner join pitcherRecord pr on p.playerId = pr.playerId where p.teamId=3 group by p.playerId, p.playerName order by playerId asc)";
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				CompareDTO2 dto = new CompareDTO2();
				
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setpWin(rs.getInt("pWin"));
				dto.setpLose(rs.getInt("pLose"));
				dto.setpSave(rs.getInt("pSave"));
				dto.setpHold(rs.getInt("pHold"));
				dto.setpAnta(rs.getInt("pAnta"));
				dto.setpHomerun(rs.getInt("pHomerun"));
				dto.setpBallnet(rs.getInt("pBallnet"));
				dto.setpSamjin(rs.getInt("pSamjin"));
				dto.setpJacheck(rs.getInt("pJacheck"));
				dto.setpBangEo(rs.getDouble("pBangEo"));
				
				list.add(dto);
			}
			
			double bangEo = 0;
			for(int i=0; i<list.size(); i++){
				bangEo = list.get(0).getpBangEo();
				if(list.get(i).getpBangEo() < bangEo){
					temp = i;
				}
			}
			System.out.println("pitcher4 : " + sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list.get(temp);
	}
	
	
	public ArrayList<CompareDTO> lotteLineUp() {
		
		ArrayList<CompareDTO> list = new ArrayList<CompareDTO>();
		
		
		try {
			String sql = "select a.*, rownum from (select p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits,sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops,sum(b.rbi) as rbi, sum(b.fourBall) as fourBall from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = 2 group by p.playerId, p.playerName order by still desc, homerun desc, battingAverage desc) a where rownum < 10";
			
			
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
	
	
public ArrayList<CompareDTO> lgLineUp() {
		
		ArrayList<CompareDTO> list = new ArrayList<CompareDTO>();
		
		
		try {
			String sql = "select a.*, rownum from (select p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits,sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops,sum(b.rbi) as rbi, sum(b.fourBall) as fourBall from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = 1 group by p.playerId, p.playerName order by still desc, homerun desc, battingAverage desc) a where rownum < 10";
			
			
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


public ArrayList<CompareDTO> doosanLineUp() {
	
	ArrayList<CompareDTO> list = new ArrayList<CompareDTO>();
	
	
	try {
		String sql = "select a.*, rownum from (select p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits,sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops,sum(b.rbi) as rbi, sum(b.fourBall) as fourBall from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = 3 group by p.playerId, p.playerName order by still desc, homerun desc, battingAverage desc) a where rownum < 10";
		
		
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


public ArrayList<CompareDTO> skLineUp() {
	
	ArrayList<CompareDTO> list = new ArrayList<CompareDTO>();
	
	
	try {
		String sql = "select a.*, rownum from (select p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits,sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops,sum(b.rbi) as rbi, sum(b.fourBall) as fourBall from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = 4 group by p.playerId, p.playerName order by still desc, homerun desc, battingAverage desc) a where rownum < 10";
		
		
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

















