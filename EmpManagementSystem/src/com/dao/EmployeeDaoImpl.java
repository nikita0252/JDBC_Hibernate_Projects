package com.dao;

import java.sql.Connection;
import com.model.Employee.*;
import com.connect.Connect;
import com.controller.*;
import com.service.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.model.Employee.*;

public class EmployeeDaoImpl implements EmployeeDaoI {
	Scanner sc = new Scanner(System.in);

	public void createTable(String tname) {
		try {

			Statement smt = Connect.getConnection();
			String s = "create table " + tname
					+ " (eid int primary key,ename varchar(20),emob long,eaddr varchar(10),esalary double)";

			smt.execute(s);

			System.out.println("Table created successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addData(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "root");

			String s = "insert into emp values(" + e.getEid() + ", '" + e.getEname() + "'," + e.getEmob() + ","
					+ e.getEsalary() + ",'" + e.getEaddr() + "')";

			Statement st = con.createStatement();
			st.execute(s);
			System.out.println("Add Employee data successfully..!");
		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}

	public void UpdateData(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "root");

			System.out.println("Enter table name:");
			String tname = sc.next();
			System.out.println("Enter ID:");
			int eid = sc.nextInt();
			System.out.println("Enter Name:");
			String ename = sc.next();
			String s = "Update " + tname + " set ename = '" + ename + "' where eid = " + eid + "";
			Statement st = con.createStatement();
			st.execute(s);
			System.out.println("Add Employee data successfully..!");
		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}

	@Override
	public void ViewData(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "root");

			System.out.println("In which table do you want to Retrive data");
			String tablen = sc.next();

			String st = "select * from " + tablen + " ";
			Statement srt = co.createStatement();

			ResultSet rs = srt.executeQuery(st);

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getLong(3));
				System.out.println(rs.getDouble(4));
				System.out.println(rs.getString(5));

			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		System.out.println("All Data is Retrieved..");
		System.out.println(" ");

	}

	@Override
	public void DeleteData(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "root");

			System.out.println("In which table do you want to Delete data");
			String tablen = sc.next();
			System.out.println("Enter Id where you want to delete");
			int id = sc.nextInt();

			String sr = "delete from " + tablen + " where eid = " + id + " ";

			Statement st = con.createStatement();

			st.execute(sr);
			st.close();
			con.close();
		}

		catch (Exception e4) {
			System.out.println(e4.getMessage());
		}
		System.out.println("Data is deleted..");
		System.out.println(" ");

	}

	@Override
	public void DropTable(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empsystem", "root", "root");

			System.out.println("Which table you want to delete:");
			String tablen = sc.next();

			String sr = "drop table " + tablen + "";

			Statement st = con.createStatement();

			st.execute(sr);
			st.close();
			con.close();
		}

		catch (Exception e5) {
			System.out.println(e5.getMessage());
		}
		System.out.println("Data is deleted..");
		System.out.println(" ");

	}

}
