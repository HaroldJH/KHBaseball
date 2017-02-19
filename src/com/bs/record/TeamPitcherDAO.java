package com.bs.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;
import com.bs.record.TeamPitcherDAO;

public class TeamPitcherDAO {
	private Statement stat = null;	
	private Connection con = null;



	public TeamPitcherDAO() {
		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
		//팀평균 방어율
		public ArrayList<TeamPitcherDTO> TeamPBangEo() {
			
			ArrayList<TeamPitcherDTO> list = new ArrayList<TeamPitcherDTO>();
			try {
				String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(pr.pbangeo),'90.00') as pbangeo, t.teamname from pitcherRecord pr inner join  player p on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by pbangeo asc)a");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					TeamPitcherDTO bdto =new TeamPitcherDTO();
					bdto.setTeamPBangEo(rs.getString("pbangeo"));
					bdto.setTeamName(rs.getString("teamName"));
					bdto.setRnum(rs.getString("rnum"));
					
					list.add(bdto);
				}
			}catch(Exception e){
				System.out.println(e.toString());
			}
			
			return list;

		}
		//팀평균세이브
		public ArrayList<TeamPitcherDTO> TeamPsave() {
			
			ArrayList<TeamPitcherDTO> list = new ArrayList<TeamPitcherDTO>();
			try {
				String sql = String.format("select a.*, rownum as rnum from (select sum(PSave) as PSave, t.teamname from pitcherRecord pr inner join  player p on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by PSave desc)a");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					TeamPitcherDTO bdto =new TeamPitcherDTO();
					bdto.setTeamPsave(rs.getString("Psave"));
					bdto.setTeamName(rs.getString("teamName"));
					bdto.setRnum(rs.getString("rnum"));
					
					list.add(bdto);
				}
			}catch(Exception e){
				System.out.println(e.toString());
			}
			
			return list;

		}
		//팀평균탈삼진
		public ArrayList<TeamPitcherDTO> TeamPsamjin() {
			
			ArrayList<TeamPitcherDTO> list = new ArrayList<TeamPitcherDTO>();
			try {
				String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(pr.PSamjin),'90.00') as PSamjin, t.teamname from pitcherRecord pr inner join  player p on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by PSamjin desc)a");
				

				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){ 
					TeamPitcherDTO bdto =new TeamPitcherDTO();
					bdto.setTeamPsamjin(rs.getString("Psamjin"));
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
