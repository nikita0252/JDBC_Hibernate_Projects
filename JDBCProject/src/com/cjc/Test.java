package com.cjc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			 //String sql="create table stud(id int, name varchar(10), addr varchar(10))";
			 String st = "create table student(id int, name varchar(20), addr varchar(10))";
			
			Statement smt =con.createStatement();
			smt.execute(st);
			smt.close();
			con.close();
			
			System.out.println("Table is created");
			 
	}

}
