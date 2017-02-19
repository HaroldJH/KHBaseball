package com.bs.record;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class HitssDAO {
	private Statement stat = null;	
	private Connection con = null;

	public HitssDAO() {
		



		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	
	//안타20등까지
	public ArrayList<HitssDTO> hitss() {
		ArrayList<HitssDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from(select a.*, rownum as rnum from(select sum(br.hits) as hits, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by hits desc) a) where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				HitssDTO bdto =new HitssDTO();
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
	
	
	
	
	
}
