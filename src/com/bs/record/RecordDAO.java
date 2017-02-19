package com.bs.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class RecordDAO {
	private Statement stat = null;	
	private Connection con = null;

	public RecordDAO() {
		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	//타율20등까지
		public ArrayList<RecordDTO> battingAverages() {
			ArrayList<RecordDTO> list = new ArrayList<>();
			
			try {
				String sql = String.format("select * from (select a.*, rownum as rnum from (select to_char(avg(br.BattingAverage),'0.000') as BattingAverage, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by BattingAverage desc) a) where rnum <= 20");
				System.out.println(sql);//디버깅
				
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					RecordDTO bdto =new RecordDTO();
					bdto.setBattingAverages(rs.getDouble("BattingAverage"));
					bdto.setPlayerName(rs.getString("playerName"));
					bdto.setTeamName(rs.getString("teamName"));
					bdto.setRnum(rs.getString("rnum"));
					
					list.add(bdto);
				}
			}catch(Exception e){
				System.out.println(e.toString());
			}

				return list;
		}
		
		//홈런20등까지
		public ArrayList<RecordDTO> HomeRuns() {
			ArrayList<RecordDTO> list = new ArrayList<>();
			
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.homerun) as homerun, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by homerun desc) a) where rnum <= 20");
				System.out.println(sql);//디버깅
				
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					RecordDTO bdto =new RecordDTO();
					bdto.setHomeruns(rs.getString("homerun"));
					bdto.setPlayerName(rs.getString("playerName"));
					bdto.setTeamName(rs.getString("teamName"));
					bdto.setRnum(rs.getString("rnum"));
					
					list.add(bdto);
				}
			}catch(Exception e){
				System.out.println(e.toString());
			}

				return list;
		}
		
		//타점20등까지
				public ArrayList<RecordDTO> Rbis() {
					ArrayList<RecordDTO> list = new ArrayList<>();
					
					try {
						String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.rbi) as rbi, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by rbi desc) a) where rnum <= 20");
						System.out.println(sql);//디버깅
						
						ResultSet rs = stat.executeQuery(sql);
						while(rs.next()){
							RecordDTO bdto =new RecordDTO();
							bdto.setRbis(rs.getString("rbi"));
							bdto.setPlayerName(rs.getString("playerName"));
							bdto.setTeamName(rs.getString("teamName"));
							bdto.setRnum(rs.getString("rnum"));
							
							list.add(bdto);
						}
					}catch(Exception e){
						System.out.println(e.toString());
					}

						return list;
				}
				//득점20등까지
				public ArrayList<RecordDTO> Scores() {
					ArrayList<RecordDTO> list = new ArrayList<>();
					
					try {
						String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.score) as score, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by score desc) a)where rnum <= 20");
						System.out.println(sql);//디버깅
						
						ResultSet rs = stat.executeQuery(sql);
						while(rs.next()){
							RecordDTO bdto =new RecordDTO();
							bdto.setScores(rs.getString("score"));
							bdto.setPlayerName(rs.getString("playerName"));
							bdto.setTeamName(rs.getString("teamName"));
							bdto.setRnum(rs.getString("rnum"));
							
							list.add(bdto);
						}
					}catch(Exception e){
						System.out.println(e.toString());
					}

						return list;
				}
				//안타20등까지
				public ArrayList<RecordDTO> Hitss() {
					ArrayList<RecordDTO> list = new ArrayList<>();
					
					try {
						String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.hits) as hits, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by hits desc) a) where rnum <= 20");
						System.out.println(sql);//디버깅
						
						ResultSet rs = stat.executeQuery(sql);
						while(rs.next()){
							RecordDTO bdto =new RecordDTO();
							bdto.setHitss(rs.getString("hits"));
							bdto.setPlayerName(rs.getString("playerName"));
							bdto.setTeamName(rs.getString("teamName"));
							bdto.setRnum(rs.getString("rnum"));
							
							list.add(bdto);
						}
					}catch(Exception e){
						System.out.println(e.toString());
					}

						return list;
				}
		//출루율20등까지
				public ArrayList<RecordDTO> Onbases() {
					ArrayList<RecordDTO> list = new ArrayList<>();
					
					try {
						String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.onbase),'0.000') as onbase, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by onbase desc) a)where rnum <= 20");
						System.out.println(sql);//디버깅
						
						ResultSet rs = stat.executeQuery(sql);
						while(rs.next()){
							RecordDTO bdto =new RecordDTO();
							bdto.setOnbases(rs.getString("onbase"));
							bdto.setPlayerName(rs.getString("playerName"));
							bdto.setTeamName(rs.getString("teamName"));
							bdto.setRnum(rs.getString("rnum"));
							
							list.add(bdto);
						}
					}catch(Exception e){
						System.out.println(e.toString());
					}

						return list;
				}
				//장타율20등까지
				public ArrayList<RecordDTO> Sluggings() {
					ArrayList<RecordDTO> list = new ArrayList<>();
					
					try {
						String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.Slugging),'0.000') as Slugging, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by Slugging desc) a)where rnum <= 20");
						System.out.println(sql);//디버깅
						
						ResultSet rs = stat.executeQuery(sql);
						while(rs.next()){
							RecordDTO bdto =new RecordDTO();
							bdto.setSluggings(rs.getString("Slugging"));
							bdto.setPlayerName(rs.getString("playerName"));
							bdto.setTeamName(rs.getString("teamName"));
							bdto.setRnum(rs.getString("rnum"));
							
							list.add(bdto);
						}
					}catch(Exception e){
						System.out.println(e.toString());
					}

						return list;
				}
				//도루20등까지
				public ArrayList<RecordDTO> stills() {
					ArrayList<RecordDTO> list = new ArrayList<>();
					
					try {
						String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.still) as still, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by still desc) a)where rnum <= 20");
						System.out.println(sql);//디버깅
						
						ResultSet rs = stat.executeQuery(sql);
						while(rs.next()){
							RecordDTO bdto =new RecordDTO();
							bdto.setStills(rs.getString("still"));
							bdto.setPlayerName(rs.getString("playerName"));
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
