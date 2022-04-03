package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDAO {	
	private static Connection conn = null;
	public static Connection getConnection() throws Exception{
		if (conn == null) {
			String url = "jdbc:mysql://localhost:3306/projeto_engenharia";
			String username = "root";
			String password = "admin";		
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();                      
	        	System.out.println("Connection established with the database!!");
	        	conn = DriverManager.getConnection(url, username, password);                         
	            return conn;
	       } catch (Exception e) {    	              
	    	   System.out.println("SQLException: " + e.getMessage());
	    	   throw e;
	       }     
		}else {			
			return conn;
		}
    } 	
}