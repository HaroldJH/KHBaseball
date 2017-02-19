package com.bs.rank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class RankDAO {

	
	private Connection con = null;
	private Statement stat = null;
	private PreparedStatement stat2 = null;

	
	public RankDAO() {
		String url = "jdbc:oracle:thin:@1.232.3.223:1521:xe";
		String id = "hr";
		String pw = "java1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, id, pw);
			stat = con.createStatement();

		} catch (Exception e) {
			System.out.println(e.toString());
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
				
				dto.setWinRate(rs.getInt("winRate"));
				
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



	
	//년도별 선택한 팀의 경기 이력 뽑기 ->역대전적기록메뉴	
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
	
	
	//년도별 선택한 팀의 경기 이력 뽑기 ->역대전적기록메뉴	
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

			
			
			
			
			if (idx.equals("1")) {//지정한 팀이 LG일때
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
				
				
				
			} else if (idx.equals("2")){//지정한 팀이 롯데일때 
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
			else if (idx.equals("3")){//지정한 팀이 두산일때 
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
						
						
			}else if(idx.equals("4")){//지정한 팀이 SK일때 
				
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
