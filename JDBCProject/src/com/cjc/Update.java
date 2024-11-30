package com.cjc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		String query = "update student set name = 'abc' where id = 101";

		Statement smt = con.createStatement();

		boolean b = smt.execute(query);

		System.out.println(b);
		smt.close();
		con.close();

		System.out.println("Data updated");
	}

}
