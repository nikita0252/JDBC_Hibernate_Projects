package com.cjc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		for (int i = 0; i < 2; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Id : ");
			int id = sc.nextInt();
			System.out.println("Enter Name: ");
			String name = sc.next();
			System.out.println("Enter Address: ");
			String addr = sc.next();

			String sql = "insert into student values(" + id + ",'" + name + "', '" + addr + "')";

			Statement smt = con.createStatement();

			smt.execute(sql);

			smt.close();
		}
		con.close();

		System.out.println("Data inserted");

	}

}
