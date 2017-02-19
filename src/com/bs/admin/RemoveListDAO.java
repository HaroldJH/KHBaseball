package com.bs.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;


public class RemoveListDAO {
	//게시판과 관련된 데이터베이스 작업 전담 클래스
	private Statement stat = null;

	//초기화 작업 - 생성
	public RemoveListDAO() {
		try {
			stat = DBUtil.connect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//투수 방출 추천 선수 목록 가져오기	
	public ArrayList<RemoveListDTO> plist(){
		ArrayList<RemoveListDTO> plist = new ArrayList<RemoveListDTO>();
		
		try{
			String sql = "select p.salary, p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pInning) as pInning, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun, sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, to_char(avg(pr.pBangEo),'90.00') as pBangEo, to_char(avg(pr.WHIP),'90.00')as WHIP from player p inner join pitcherRecord pr on p.playerId = pr.playerId where p.teamId = 2 group by p.playerId, p.playerName, p.salary order by p.salary-(1000-avg(pr.pbangEo)*100)*30 desc";     
			
			ResultSet rs = stat.executeQuery(sql);


			while(rs.next()){
				RemoveListDTO dto = new RemoveListDTO();
				dto.setPlayerId(rs.getString("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setpWin(rs.getInt("pWin"));
				dto.setpLose(rs.getInt("pLose"));
				dto.setpSave(rs.getInt("pSave"));
				dto.setpHold(rs.getInt("pHold"));
				dto.setpInning(rs.getDouble("pInning"));
				dto.setpAnta(rs.getInt("pAnta"));
				dto.setpHomerun(rs.getInt("pHomerun"));
				dto.setpBallnet(rs.getInt("pBallnet"));
				dto.setpSamjin(rs.getInt("pSamjin"));
				dto.setpBangEo(rs.getDouble("pBangEo"));
				dto.setWhip(rs.getDouble("whip"));
				
				plist.add(dto);
			}
		} catch (Exception e) {
			System.out.println("p : " + e.toString());
		}
		
		return plist;
	}//plist()<=투수리스트
	
	//타자 방출 추천 선수 목록 가져오기	
		public ArrayList<RemoveListDTO> hlist(){
			ArrayList<RemoveListDTO> hlist = new ArrayList<RemoveListDTO>();
			
			try{
				String sql = "select p.salary, p.playerId as playerId, p.playerName as playerName, sum(b.atBat) as atBat, sum(b.hits) as hits, sum(b.homeRun) as homeRun, sum(b.still) as still, sum(samjin) as samjin, sum(fourball) as fourball, to_char(avg(b.battingAverage), '0.000') as battingAverage, to_char(avg(b.onBase), '0.000') as onBase, to_char(avg(b.slugging), '0.000') as slugging, to_char(avg(b.ops), '0.000') as ops, sum(error) as error from player p inner join batterRecord b on p.playerId = b.playerId where p.teamId = 2 group by p.playerId, p.playerName, p.salary order by p.salary-avg(b.battingAverage)*50 desc";
				
				ResultSet rs = stat.executeQuery(sql);
				
				
				while(rs.next()){
					RemoveListDTO dto = new RemoveListDTO();
					dto.setPlayerId(rs.getString("playerId"));
					dto.setPlayerName(rs.getString("playerName"));
					dto.setAtBat(rs.getInt("atBat"));
					dto.setHits(rs.getInt("hits"));
					dto.setHomeRun(rs.getInt("homeRun"));
					dto.setStill(rs.getInt("still"));
					dto.setSamJin(rs.getInt("samJin"));
					dto.setFourBall(rs.getInt("fourBall"));
					dto.setBattingAverage(rs.getDouble("battingAverage"));
					dto.setOnBase(rs.getDouble("onBase"));
					dto.setSlugging(rs.getDouble("slugging"));
					dto.setOps(rs.getDouble("ops"));
					dto.setError(rs.getInt("error"));					
									
					
					hlist.add(dto);
				}
				
			} catch (Exception e) {
				System.out.println("h : " + e.toString());
			}
			
			return hlist;
		}//hlist()<=타자리스트
		
		
		//선수방출하기
		public int remove(String playerId){
			int result = 0;
			
			try {
				
			
				String sql ="update player set isActive = 0,teamId = null, salary = null, backNum = null, isposu = null where playerId = " + playerId;
				System.out.println(sql);
				result = stat.executeUpdate(sql);
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return result;
		}
		
	

	
}
