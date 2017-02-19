package com.bs.rank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bs.db.DBUtil;


public class RankDAO {

	
	private Connection con = null;
	private Statement stat = null;
	private PreparedStatement stat2 = null;

	
	public RankDAO() {
		try {
			stat = DBUtil.connect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public ArrayList<RankDTO> rankList() {
		ArrayList<RankDTO> rankList = new ArrayList<RankDTO>();
		
		//DB -> select -> ResultSet -> ArrayList
		try {
			String sql = String.format("select ranking,teamName,gameNum,win,draw,lose,rankDifference,(win/(win+Lose))as winRate from teamRank tr inner join team t on tr.TEAMID = t.TEAMID  order by tr.RANKING asc ") ; 

			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				
				RankDTO dto = new RankDTO();
				
				dto.setRanking(rs.getInt("ranking"));
				dto.setTeamName(rs.getString("teamName"));
				dto.setGameNum(rs.getInt("gameNum"));
				dto.setWin(rs.getInt("win"));
				dto.setDraw(rs.getInt("draw"));
				dto.setLose(rs.getInt("lose"));
				dto.setRankDifference(rs.getInt("rankDifference"));
				
				dto.setWinRate(rs.getFloat("winRate"));
				
				rankList.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return rankList;
	}



	public ArrayList<RankDTO> rankIndex() {
		// TODO Auto-generated method stub
		ArrayList<RankDTO> rankIndex = new ArrayList<RankDTO>();
		
		//DB -> select -> ResultSet -> ArrayList
		try {
			String sql = String.format("select ranking,teamName,gameNum,win,draw,lose,rankDifference,(win/(win+Lose))as winRate from teamRank tr inner join team t on tr.TEAMID = t.TEAMID  order by tr.RANKING asc ") ; 

			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				
				RankDTO dto = new RankDTO();
				
				dto.setRanking(rs.getInt("ranking"));
				dto.setTeamName(rs.getString("teamName"));
				dto.setGameNum(rs.getInt("gameNum"));
				dto.setWin(rs.getInt("win"));
				dto.setDraw(rs.getInt("draw"));
				dto.setLose(rs.getInt("lose"));
				dto.setRankDifference(rs.getInt("rankDifference"));
				
				dto.setWinRate(rs.getInt("winRate"));
				
				rankIndex.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return null;
	}



	
	//�뀈�룄蹂� �꽑�깮�븳 ���쓽 寃쎄린 �씠�젰 戮묎린 ->�뿭���쟾�쟻湲곕줉硫붾돱	
	public ArrayList<RankDTO> yearList(String idx) {
		ArrayList<RankDTO> yearList = new ArrayList<RankDTO>();
		
		
		//DB -> select -> ResultSet -> ArrayList
		try {
			String sql = String.format("select teamName from teamRank tr inner join team t on tr.TEAMID = t.TEAMID  order by tr.RANKING asc ") ; 
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				
				RankDTO dto = new RankDTO();
				System.out.println("dto");
				dto.setTeamName(rs.getString("teamName"));
				yearList.add(dto);
				
			}
			
		} catch (Exception e) {
			System.out.println("e : " + e.toString());
		}
		
		return yearList;
	}
	
	
	//�뀈�룄蹂� �꽑�깮�븳 ���쓽 寃쎄린 �씠�젰 戮묎린 ->�뿭���쟾�쟻湲곕줉硫붾돱	
	public ArrayList<RankDTO> list(String idx) {
		ArrayList<RankDTO> yearList = new ArrayList<RankDTO>();
		
		try {
			//?? 1, 2, 3, 5 
			String n1 = "";
			String n2 = "";
			String n3 = "";
			
			String sql = "select (select teamname from team where teamid = 2) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=1)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=1) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=1) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=1) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=1) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 
			
			
			System.out.println(sql);
			stat = con.createStatement();

			
			
			
			
			if (idx.equals("1")) {//吏��젙�븳 ���씠 LG�씪�븣
				n1 = "2";
				n2 ="3";
				n3 = "4";
				
				sql = "	select (select teamname from team where teamid = 3) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=1)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=1) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=1) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=1) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=1) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

				ResultSet rs = stat.executeQuery(sql);
			
				if (rs.next()) {
				
				RankDTO dto = new RankDTO();
				
				dto.setTeamName(rs.getString("teamName"));
				dto.setGameNum(rs.getInt("gameNum"));
				dto.setWin(rs.getInt("win"));
				dto.setLose(rs.getInt("lose"));
				dto.setWinRate(rs.getInt("winRate"));
				
				
				yearList.add(dto);
			
				
			
			
			}
			
			
			sql = "select (select teamname from team where teamid = 1) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=3)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=3) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=3) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=3) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=3) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

			 rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				RankDTO dto = new RankDTO();
				
				dto.setTeamName(rs.getString("teamName"));
				dto.setGameNum(rs.getInt("gameNum"));
				dto.setWin(rs.getInt("win"));
				dto.setLose(rs.getInt("lose"));
				dto.setWinRate(rs.getInt("winRate"));
				
				System.out.println("g : " + dto.getWin() + " : " + dto.getLose());
				
				yearList.add(dto);
				
			}
			
			

			sql = "select (select teamname from team where teamid = 4) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=1)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=1) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=1) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=1) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=1 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=1) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

			rs = stat.executeQuery(sql);
			
			
					
					if (rs.next()) {
						
						RankDTO dto = new RankDTO();
						
						dto.setTeamName(rs.getString("teamName"));
						dto.setGameNum(rs.getInt("gameNum"));
						dto.setWin(rs.getInt("win"));
						dto.setLose(rs.getInt("lose"));
						dto.setWinRate(rs.getInt("winRate"));
						yearList.add(dto);
					
				}
				
				
				
			} else if (idx.equals("2")){//吏��젙�븳 ���씠 濡��뜲�씪�븣 
				n1 = "1";
				n2 ="3";
				n3 = "4";
				
				
				sql = "select (select teamname from team where teamid = 1) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

				ResultSet rs = stat.executeQuery(sql);
			
				if (rs.next()) {
				
				RankDTO dto = new RankDTO();
				
				dto.setTeamName(rs.getString("teamName"));
				dto.setGameNum(rs.getInt("gameNum"));
				dto.setWin(rs.getInt("win"));
				dto.setLose(rs.getInt("lose"));
				dto.setWinRate(rs.getInt("winRate"));
				
				
				yearList.add(dto);
			
				
			
			
			}
			
			
			sql = "select (select teamname from team where teamid = 3) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

			 rs = stat.executeQuery(sql);
			
			
			if (rs.next()) {
				
				RankDTO dto = new RankDTO();
				
				dto.setTeamName(rs.getString("teamName"));
				dto.setGameNum(rs.getInt("gameNum"));
				dto.setWin(rs.getInt("win"));
				dto.setLose(rs.getInt("lose"));
				dto.setWinRate(rs.getInt("winRate"));
				
				System.out.println("g : " + dto.getWin() + " : " + dto.getLose());
				
				yearList.add(dto);
				
			}
			
			

			sql = "select (select teamname from team where teamid = 4) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=2 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

			rs = stat.executeQuery(sql);
			
			
					
					if (rs.next()) {
						
						RankDTO dto = new RankDTO();
						
						dto.setTeamName(rs.getString("teamName"));
						dto.setGameNum(rs.getInt("gameNum"));
						dto.setWin(rs.getInt("win"));
						dto.setLose(rs.getInt("lose"));
						dto.setWinRate(rs.getInt("winRate"));
						yearList.add(dto);
				}
				
				
			}
			else if (idx.equals("3")){//吏��젙�븳 ���씠 �몢�궛�씪�븣 
				n1 = "1";
				n2 ="2";
				n3 = "4";
				
				
					sql = "select (select teamname from team where teamid = 1) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

					ResultSet rs = stat.executeQuery(sql);
				
					if (rs.next()) {
					
					RankDTO dto = new RankDTO();
					
					dto.setTeamName(rs.getString("teamName"));
					dto.setGameNum(rs.getInt("gameNum"));
					dto.setWin(rs.getInt("win"));
					dto.setLose(rs.getInt("lose"));
					dto.setWinRate(rs.getInt("winRate"));
					
					
					yearList.add(dto);
				
					
				
				
				}
				
				
				sql = "select (select teamname from team where teamid = 2) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

				 rs = stat.executeQuery(sql);
				
				
				if (rs.next()) {
					
					RankDTO dto = new RankDTO();
					
					dto.setTeamName(rs.getString("teamName"));
					dto.setGameNum(rs.getInt("gameNum"));
					dto.setWin(rs.getInt("win"));
					dto.setLose(rs.getInt("lose"));
					dto.setWinRate(rs.getInt("winRate"));
					
					System.out.println("g : " + dto.getWin() + " : " + dto.getLose());
					
					yearList.add(dto);
					
				}
				
				

				sql = "select (select teamname from team where teamid = 4) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=3 and( ps.HOMETEAMID =4 or ps.awayteamid=4)and ps.WINTEAM=4) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

				rs = stat.executeQuery(sql);
				
				
						
						if (rs.next()) {
							
							RankDTO dto = new RankDTO();
							
							dto.setTeamName(rs.getString("teamName"));
							dto.setGameNum(rs.getInt("gameNum"));
							dto.setWin(rs.getInt("win"));
							dto.setLose(rs.getInt("lose"));
							dto.setWinRate(rs.getInt("winRate"));
							yearList.add(dto);
							
							System.out.println("aa : " + dto.getWin() + " : " + dto.getLose());
					
				}
						
						
			}else if(idx.equals("4")){//吏��젙�븳 ���씠 SK�씪�븣 
				
				n1 = "1";
				n2 ="2";
				n3 = "3";
				
				sql = "select (select teamname from team where teamid = 1) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =1 or ps.awayteamid=1)and ps.WINTEAM=1) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

				ResultSet rs = stat.executeQuery(sql);
			
				if (rs.next()) {
				
				RankDTO dto = new RankDTO();
				
				dto.setTeamName(rs.getString("teamName"));
				dto.setGameNum(rs.getInt("gameNum"));
				dto.setWin(rs.getInt("win"));
				dto.setLose(rs.getInt("lose"));
				dto.setWinRate(rs.getInt("winRate"));
				
				
				yearList.add(dto);
							
						}
				
						

				sql = "select (select teamname from team where teamid = 2) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =2 or ps.awayteamid=2)and ps.WINTEAM=2) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

				rs = stat.executeQuery(sql);
				
				
						
						if (rs.next()) {
							
							RankDTO dto = new RankDTO();
							
							dto.setTeamName(rs.getString("teamName"));
							dto.setGameNum(rs.getInt("gameNum"));
							dto.setWin(rs.getInt("win"));
							dto.setLose(rs.getInt("lose"));
							dto.setWinRate(rs.getInt("winRate"));
							yearList.add(dto);
				}
						
						
						
						
						sql = "select (select teamname from team where teamid = 3) as teamname,(select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) as gameNum, (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3)as win,(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) as loseCnt from dual) as lose, (select (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) /((select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) +(select (select count(tr.GAMENUM) as bcount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)) - (select count(ps.WINTEAM) as acount from PLAYSCHEDULE ps inner join team t on t.teamId=ps.HOMETEAMID or t.TEAMID=ps.AWAYTEAMID inner join  teamRank tr on t.teamId=tr.teamId where t.teamId=4 and( ps.HOMETEAMID =3 or ps.awayteamid=3)and ps.WINTEAM=3) as loseCnt from dual)) as winRate from dual) as winRate from dual"; 

						rs = stat.executeQuery(sql);
						
						
								
								if (rs.next()) {
									
									RankDTO dto = new RankDTO();
									
									dto.setTeamName(rs.getString("teamName"));
									dto.setGameNum(rs.getInt("gameNum"));
									dto.setWin(rs.getInt("win"));
									dto.setLose(rs.getInt("lose"));
									dto.setWinRate(rs.getInt("winRate"));
									yearList.add(dto);
				}
						
						
			}
			
			

			
		} catch (Exception e) {
			System.out.println("error : " + e.toString());
		}
		
		System.out.println(yearList.size());
		for (RankDTO dto : yearList)  {
			System.out.println(dto.getWin() + " : " + dto.getLose());
		}
		
		return yearList;
	}
}
