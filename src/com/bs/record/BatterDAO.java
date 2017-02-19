package com.bs.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class BatterDAO {
	private Statement stat = null;	
	private Connection con = null;

	public BatterDAO() {
		

		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	//타율1~3등                     
	public ArrayList<PlayerRankDTO> battingAverage() {
		
		ArrayList<PlayerRankDTO> list = new ArrayList<PlayerRankDTO>();
		try {
			String sql = String.format("select * from (select a.*, rownum as rnum from (select to_char(avg(br.BattingAverage),'0.000') as bta, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by bta desc) a)where rnum = 1 or rnum=2 or rnum=3");
			

			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){ 
				PlayerRankDTO bdto =new PlayerRankDTO();
				bdto.setBattingaverage(rs.getDouble("bta"));
				bdto.setPlayerName(rs.getString("playerName"));
				bdto.setTeamName(rs.getString("teamName"));
				bdto.setRnum(rs.getString("rnum"));
				
				System.out.println("btatest111 :" + rs.getString("bta").toString());
				list.add(bdto);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		return list;

	}
	//타율20등까지
	public ArrayList<PlayerRankDTO> battingAverages() {
		ArrayList<PlayerRankDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from (select a.*, rownum as rnum from (select to_char(avg(br.BattingAverage),'0.000') as BattingAverage, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by BattingAverage desc) a) where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				PlayerRankDTO bdto =new PlayerRankDTO();
				bdto.setBattingaverages(rs.getString("battingAverage"));
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
	public ArrayList<PlayerRankDTO> HomeRuns() {
		ArrayList<PlayerRankDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.homerun) as homerun, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by homerun desc) a) where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				PlayerRankDTO bdto =new PlayerRankDTO();
				bdto.setHomeruns(rs.getString("homeruns"));
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
	//홈런1~3등
	public ArrayList<PlayerRankDTO> HomeRun() {
		
		ArrayList<PlayerRankDTO> list = new ArrayList<PlayerRankDTO>();
		try {
			String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.homerun) as homerun, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by homerun desc) a) where rnum = 1 or rnum=2 or rnum=3");
			

			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				PlayerRankDTO hdto =new PlayerRankDTO();
				hdto.setHomerun(rs.getString("homerun"));
				hdto.setPlayerName(rs.getString("playerName"));
				hdto.setTeamName(rs.getString("teamName"));
				hdto.setRnum(rs.getString("rnum"));
				
				list.add(hdto);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		return list;

	}
	//타점20등까지
		public ArrayList<PlayerRankDTO> Rbis() {
			ArrayList<PlayerRankDTO> list = new ArrayList<>();
			
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.rbi) as rbi, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by rbi desc) a) where rnum <= 20");
				System.out.println(sql);//디버깅
				
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					PlayerRankDTO bdto =new PlayerRankDTO();
					bdto.setRbis(rs.getString("rbis"));
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
	
	//타점1~3등
		public ArrayList<PlayerRankDTO> Rbi() {
			ArrayList<PlayerRankDTO> list = new ArrayList<>();
			
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.rbi) as rbi, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by rbi desc) a) where rnum = 1 or rnum=2 or rnum=3");
				System.out.println(sql);//디버깅
				
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					PlayerRankDTO bdto =new PlayerRankDTO();
					bdto.setRbi(rs.getString("rbi"));
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
		public ArrayList<PlayerRankDTO> Scores() {
			ArrayList<PlayerRankDTO> list = new ArrayList<>();
			
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.score) as score, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by score desc) a)where rnum <= 20");
				System.out.println(sql);//디버깅
				
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					PlayerRankDTO bdto =new PlayerRankDTO();
					bdto.setScores(rs.getString("scores"));
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
	//득점1등~3등
			public ArrayList<PlayerRankDTO> Score() {
				ArrayList<PlayerRankDTO> list = new ArrayList<>();
				
				try {
					String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.score) as score, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by score desc) a)where rnum = 1 or rnum=2 or rnum=3");
					System.out.println(sql);//디버깅
					
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						PlayerRankDTO bdto =new PlayerRankDTO();
						bdto.setScore(rs.getString("score"));
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
	//안타1~3등
			public ArrayList<PlayerRankDTO> Hits() {
				ArrayList<PlayerRankDTO> list = new ArrayList<>();
				
				try {
					String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.hits) as hits, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by hits desc) a) where rnum = 1 or rnum=2 or rnum=3");
					System.out.println(sql);//디버깅
					
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						PlayerRankDTO bdto =new PlayerRankDTO();
						bdto.setHits(rs.getString("hits"));
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
			public ArrayList<PlayerRankDTO> Hitss() {
				ArrayList<PlayerRankDTO> list = new ArrayList<>();
				
				try {
					String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.hits) as hits, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by hits desc) a) where rnum <= 20");
					System.out.println(sql);//디버깅
					
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						PlayerRankDTO bdto =new PlayerRankDTO();
						bdto.setHitss(rs.getString("hitss"));
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
			public ArrayList<PlayerRankDTO> Onbases() {
				ArrayList<PlayerRankDTO> list = new ArrayList<>();
				
				try {
					String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.onbase),'0.000') as onbase, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by onbase desc) a)where rnum <= 20");
					System.out.println(sql);//디버깅
					
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						PlayerRankDTO bdto =new PlayerRankDTO();
						bdto.setOnbase(rs.getString("onbase"));
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
	//출루율1등~3등
			public ArrayList<PlayerRankDTO> Onbase() {
				ArrayList<PlayerRankDTO> list = new ArrayList<>();
				
				try {
					String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.onbase),'0.000') as onbase, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by onbase desc) a)where rnum = 1 or rnum=2 or rnum=3");
					System.out.println(sql);//디버깅
					
					ResultSet rs = stat.executeQuery(sql);
					while(rs.next()){
						PlayerRankDTO bdto =new PlayerRankDTO();
						bdto.setOnbase(rs.getString("onbase"));
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
	public ArrayList<PlayerRankDTO> Sluggings() {
		ArrayList<PlayerRankDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.Slugging),'0.000') as Slugging, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by Slugging desc) a)where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				PlayerRankDTO bdto =new PlayerRankDTO();
				bdto.setSluggings(rs.getString("Sluggings"));
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
	//장타율1~3등
	public ArrayList<PlayerRankDTO> Slugging() {
		ArrayList<PlayerRankDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.Slugging),'0.000') as Slugging, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by Slugging desc) a)where rnum = 1 or rnum=2 or rnum=3");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				PlayerRankDTO bdto =new PlayerRankDTO();
				bdto.setSlugging(rs.getString("Slugging"));
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
	public ArrayList<PlayerRankDTO> stills() {
		ArrayList<PlayerRankDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.onbase),'0.000') as onbase, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by onbase desc) a)where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				PlayerRankDTO bdto =new PlayerRankDTO();
				bdto.setStills(rs.getString("stills"));
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
	//도루1등
	public ArrayList<PlayerRankDTO> still() {
		ArrayList<PlayerRankDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.still) as still, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by still desc) a)where rnum = 1 or rnum = 2 or rnum = 3");
		
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				PlayerRankDTO bdto =new PlayerRankDTO();
				bdto.setStill(rs.getInt("still"));
				System.out.println("still : " + rs.getString("still"));
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
