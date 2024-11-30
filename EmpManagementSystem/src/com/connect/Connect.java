package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {

	public static Statement getConnection() {

		Statement smt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "root");
			smt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smt;
	}
}
