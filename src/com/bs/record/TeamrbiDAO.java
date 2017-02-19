package com.bs.record;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class TeamrbiDAO {

	private Statement stat = null;
	
	public TeamrbiDAO() {
		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	
	
	
	public ArrayList<TeamrbiDTO> teamRbi() {
		ArrayList<TeamrbiDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select a.*, rownum as rnum from (select to_char(avg(br.RBI),'90.00') as RBI, t.teamname from Batterrecord br inner join player p on p.playerid = br.playerid inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by RBI desc)a");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				TeamrbiDTO bdto =new TeamrbiDTO();
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
}
