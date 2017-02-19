package com.bs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bs.cast.BatterRecordDTO;
import com.bs.db.DBUtil;

public class BatterRecordDAO {

	private String sql = "";
	private Connection con = null;
	private PreparedStatement stat = null;
	
	public BatterRecordDAO() {
		
		
	}
	
	public void add(BatterRecordDTO dto) {
		sql = "INSERT INTO batterRecord (batterRecordId, playDate, playId, ) VALUES ()";
		try {
			stat = DBUtil.connect().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	//타자 성적 DAO

}
