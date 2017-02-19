package com.bs.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class PicherDAO {
	private Statement stat = null;	
	private Connection con = null;

	public PicherDAO() {
		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	
	//방어율1~3등
		public ArrayList<PicherDTO> PBangEo() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.PBangEo),'90.00') as PBangEo, p.playername, t.teamname from PitcherRecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by PBangEo asc) a)where rnum = 1 or rnum = 2 or rnum = 3");


				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setpBangEo(rs.getString("pBangEo"));
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
		//방어율20등까지
		public ArrayList<PicherDTO> PBangEos() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from (select a.*, rownum as rnum from(select to_char(avg(br.PBangEo),'90.00') as PBangEo, p.playername from PitcherRecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername order by PBangEo asc) a)where rnum <= 20");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setpBangEos(rs.getString("pBangEoss"));
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
		//승리20등까지
		public ArrayList<PicherDTO> Pwins() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.pwin) as pwin, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by pwin desc) a)where rnum <= 20");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setPwins(rs.getString("pwins"));
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
		//승리1~3등까지
		public ArrayList<PicherDTO> Pwin() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.pwin) as pwin, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by pwin desc) a)where rnum = 1 or rnum=2 or rnum=3");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setPwin(rs.getString("pwin"));
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
		//세이브20등까지
		public ArrayList<PicherDTO> Psaves() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.psave) as psave, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by psave desc) a)where rnum <= 20");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setPsaves(rs.getString("psaves"));
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
		//세이브1~3등까지
		public ArrayList<PicherDTO> Psave() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.psave) as psave, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by psave desc) a)where rnum = 1 or rnum=2 or rnum=3");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setPsave(rs.getString("psave"));
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
		//홀드20등까지
		public ArrayList<PicherDTO> Pholds() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.phold) as phold, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by phold desc) a)where rnum <= 20");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setpholds(rs.getString("pholds"));
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
		//홀드1~3등까지
		public ArrayList<PicherDTO> Phold() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.phold) as phold, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by phold desc) a)where rnum = 1 or rnum=2 or rnum=3");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setphold(rs.getString("phold"));
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
		//탈삼진20등까지
		public ArrayList<PicherDTO> Psamjins() {
			
			ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
			try {
				String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.psamjin) as psamjin, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by psamjin desc) a)where rnum <= 20");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					PicherDTO bdto =new PicherDTO();
					bdto.setPsamjins(rs.getString("psamjins"));
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
		
		//탈삼진1~3등까지
				public ArrayList<PicherDTO> Psamjin() {
					
					ArrayList<PicherDTO> list = new ArrayList<PicherDTO>();
					try {
						String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.psamjin) as psamjin, p.playername, t.teamname from Pitcherrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by psamjin desc) a)where rnum =1 or rnum=2 or rnum=3");
						

						ResultSet rs = stat.executeQuery(sql);
						while(rs.next()){ 
							PicherDTO bdto =new PicherDTO();
							bdto.setPsamjin(rs.getString("psamjin"));
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
