package com.bs.record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class RbiDAO {
	private Statement stat = null;	
	private Connection con = null;

	public RbiDAO() {
		



		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	public ArrayList<RbiDTO> rbis() {
		ArrayList<RbiDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.rbi) as rbi, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by rbi desc) a) where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				RbiDTO bdto =new RbiDTO();
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
	
	
}
