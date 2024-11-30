package com.cjc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveData 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		
		String sql = "select * from student";
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Data retrived");
	}

}
