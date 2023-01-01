package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_CON 
{

public class DB_Connection
{

	public Connection getconnect() 
	{	
		try {
			String url="jdbc:mysql://localhost:3306/coding_hub";
			String uname="root";
			String pass="7032248200@Aa";
			
			Class.forName("com.mysql.cj.jdbc.Driver");                                                                             //2nd step loading drivers nd register
			Connection con=DriverManager.getConnection(url,uname,pass);			                                             		//3rd create connection							//forname responsible for load
		
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

}



}
