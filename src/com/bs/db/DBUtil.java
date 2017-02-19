package com.bs.db;

import java.sql.*;

public class DBUtil {
  
   public static Connection connect(){
      
      String url = "jdbc:oracle:thin:@10.211.55.4:1521:orcl";
      String id = "scott";
      String pw = "java1234";
      
      Connection con = null;
      Statement stat = null;
      
      try {
         Class.forName("core.log.jdbc.driver.OracleDriver");
        
         con = DriverManager.getConnection(url, id, pw);
         
         return con;
               
      } catch(Exception e) {
         System.out.println(e);
      }
         return null;
   }
}