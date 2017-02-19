package com.bs.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;
import com.bs.record.TeamBatterDAO;

public class TeamBatterDAO {
	private Statement stat = null;	
	private Connection con = null;

	public TeamBatterDAO() {
		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	//팀평균타율                    
	public ArrayList<TeamBatterDTO> TeamBattingAverage() {
		
		ArrayList<TeamBatterDTO> list = new ArrayList<TeamBatterDTO>();
		try {
			String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.BattingAverage),'0.000') as BattingAverage, t.teamname from Batterrecord br inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by BattingAverage desc)a");
			

			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){ 
				TeamBatterDTO bdto =new TeamBatterDTO();
				bdto.setTeambattingaverage(rs.getDouble("BattingAverage"));
				bdto.setTeamName(rs.getString("teamName"));
				bdto.setRnum(rs.getString("rnum"));
				
				list.add(bdto);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		return list;

	}
	//팀평균홈런
	public ArrayList<TeamBatterDTO> TeamHomeRun() {
		ArrayList<TeamBatterDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.Homerun),'90.00') as Homerun, t.teamname from Batterrecord br inner join player p on p.playerid = br.playeridinner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Homerun desc)a");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				TeamBatterDTO bdto =new TeamBatterDTO();
				bdto.setTeamHomerun(rs.getString("teamHomerun"));
				bdto.setTeamName(rs.getString("teamName"));
				bdto.setRnum(rs.getString("rnum"));
				
				list.add(bdto);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}

			return list;
	}
	//팀평균타점
		public ArrayList<TeamBatterDTO> TeamRbi() {
			ArrayList<TeamBatterDTO> list = new ArrayList<>();
			
			try {
				String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.RBI),'90.00') as RBI, t.teamname from Batterrecord br inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by RBI desc)a");
				System.out.println(sql);//디버깅
				
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					TeamBatterDTO bdto =new TeamBatterDTO();
					bdto.setTeamRbi(rs.getString("RBI"));
					bdto.setTeamName(rs.getString("teamName"));
					bdto.setRnum(rs.getString("rnum"));
					
					list.add(bdto);
				}
			}catch(Exception e){
				System.out.println(e.toString());
			}

				return list;
		}
	
	//팀평균득점
		public ArrayList<TeamBatterDTO> TeamScore() {
			ArrayList<TeamBatterDTO> list = new ArrayList<>();
			
			try {
				String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.Score),'90.00') as Score, t.teamname from Batterrecord br inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Score desc)a");
				System.out.println(sql);//디버깅
				
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					TeamBatterDTO bdto =new TeamBatterDTO();
					bdto.setTeamScore(rs.getString("Score"));
					bdto.setTeamName(rs.getString("teamName"));
					bdto.setRnum(rs.getString("rnum"));
					
					list.add(bdto);
				}
			}catch(Exception e){
				System.out.println(e.toString());
			}

				return list;
		}
	
	//팀평균안타
			public ArrayList<TeamBatterDTO> TeamHits() {
				ArrayList<TeamBatterDTO> list = new ArrayList<>();
				
				try {
					String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.Hits),'90.00') as Hits, t.teamname from Batterrecord br inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Hits desc)a");
					System.out.println(sql);//디버깅
					
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						TeamBatterDTO bdto =new TeamBatterDTO();
						bdto.setTeamHits(rs.getString("Hits"));
						bdto.setTeamName(rs.getString("teamName"));
						bdto.setRnum(rs.getString("rnum"));
						
						list.add(bdto);
					}
				}catch(Exception e){
					System.out.println(e.toString());
				}

					return list;
			}
	//팀평균출루율
			public ArrayList<TeamBatterDTO> TeamOnbase() {
				ArrayList<TeamBatterDTO> list = new ArrayList<>();
				
				try {
					String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.OnBase),'0.000') as OnBase, t.teamname from Batterrecord br inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by OnBase desc)a");
					System.out.println(sql);//디버깅
					
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						TeamBatterDTO bdto =new TeamBatterDTO();
						bdto.setTeamOnbase(rs.getString("OnBase"));
						bdto.setTeamName(rs.getString("teamName"));
						bdto.setRnum(rs.getString("rnum"));
						
						list.add(bdto);
					}
				}catch(Exception e){
					System.out.println(e.toString());
				}

					return list;
			}
	
	//팀평균장타율
	public ArrayList<TeamBatterDTO> TeamSlugging() {
		ArrayList<TeamBatterDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.Slugging),'0.000') as Slugging, t.teamname from Batterrecord br   inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Slugging desc)a");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				TeamBatterDTO bdto =new TeamBatterDTO();
				bdto.setTeamSlugging(rs.getString("Slugging"));
				bdto.setTeamName(rs.getString("teamName"));
				bdto.setRnum(rs.getString("rnum"));
				
				list.add(bdto);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}

			return list;
	}
	
	//팀평균도루율
	public ArrayList<TeamBatterDTO> TeamStill() {
		ArrayList<TeamBatterDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select a.*, rownum as rnum from (select sum(br.Still) as Still, t.teamname from Batterrecord br inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Still desc)a");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				TeamBatterDTO bdto =new TeamBatterDTO();
				bdto.setTeamStill(rs.getString("still"));
				bdto.setTeamName(rs.getString("teamName"));
				bdto.setRnum(rs.getString("rnum"));
				
				list.add(bdto);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}

			return list;
	}

	
	
}
