package com.serviceimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.servicei.*;
import java.util.Scanner;

public class ServiceImpl implements ServiceI 
{
	Scanner sc = new Scanner(System.in);

	public void createTable() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

			System.out.println("Enter no of tables you want to create");
			int nooftables = sc.nextInt();
			for (int i = 1; i <= nooftables; i++) {

				System.out.println("Name for the Creare Table :");
				String tname = sc.next();

				String str = "create table " + tname
						+ "(eid int primary key, ename varchar(10), eaddr varchar(20), emob long, esalary double, edesig varchar(10))";

				Statement smt = con.createStatement();

				smt.execute(str);
				smt.close();
				System.out.println("Table Created..");
				System.out.println(" ");

			}
			con.close();
		} catch (Exception e) {

			System.out.println("Table already exist");
		}

	}

	public void insertData()

	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

			System.out.println("In which table do you want to Insert data");
			String tablen = sc.next();

			for (int i = 1; i <= 2; i++) {
				System.out.println("Enter Id :");
				int id = sc.nextInt();
				System.out.println("Enter Ename :");
				String ename = sc.next();
				System.out.println("Enter Eaddress :");
				String eaddr = sc.next();
				System.out.println("Enter EMobile Number :");
				long emobno = sc.nextLong();
				System.out.println("Enter Salary :");
				double esalary = sc.nextDouble();
				System.out.println("Enter EDesignation :");
				String edesign = sc.next();

				String st = "insert into " + tablen + " values(" + id + ",'" + ename + "','" + eaddr + "'," + emobno
						+ "," + esalary + ",'" + edesign + "')";

				Statement s = con.createStatement();
				s.execute(st);
				s.close();

			}
			con.close();
		} catch (Exception e) {

		}
		System.out.println("Table Inserted..");
		System.out.println(" ");

	}

	public void updateData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

			System.out.println("In which table do you want to Update data");
			String tablen = sc.next();

			System.out.println("1.Name Update:");
			System.out.println("2.Salary Update:");
			System.out.println("3.Designation Update:");
			System.out.println("4.Mobile No Update:");
			System.out.println("5.Address Update:");
			System.out.println(" ");

			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			System.out.println(" ");

			if (ch == 1) {
				System.out.println("Set name which you want to update");
				String name = sc.next();
				System.out.println("Enter Id where you want to update");
				int id = sc.nextInt();

				String sr = "Update " + tablen + " set ename = '" + name + "' where eid = " + id + "";

				Statement st = con.createStatement();

				st.executeUpdate(sr);
				st.close();
				con.close();
				System.out.println("Data updated");
			} else if (ch == 2) {
				System.out.println("Set salary which you want to update");
				double sal = sc.nextDouble();
				System.out.println("Enter Id where you want to update");
				int id = sc.nextInt();

				String sr = "Update " + tablen + " set esalary = " + sal + " where eid = " + id + "";

				Statement st = con.createStatement();

				st.execute(sr);
				st.close();
				con.close();
			} else if (ch == 3) {
				System.out.println("Set designation which you want to update");
				String desig = sc.next();
				System.out.println("Enter Id where you want to update");
				int id = sc.nextInt();

				String sr = "Update " + tablen + " set edesig = '" + desig + "' where eid = " + id + "";

				Statement st = con.createStatement();

				st.execute(sr);
				st.close();
				con.close();
			} else if (ch == 4) {
				System.out.println("Set Mobile no which you want to update");
				long mobno = sc.nextLong();
				System.out.println("Enter Id where you want to update");
				int id = sc.nextInt();

				String sr = "Update " + tablen + " set emob = " + mobno + " where eid = " + id + "";

				Statement st = con.createStatement();

				st.execute(sr);
				st.close();
				con.close();
			} else if (ch == 5) {
				System.out.println("Set Address which you want to update");
				String addr = sc.next();
				System.out.println("Enter Id where you want to update");
				int id = sc.nextInt();

				String sr = "Update " + tablen + " set eaddr = '" + addr + "' where id = " + id + "";

				Statement st = con.createStatement();

				st.execute(sr);
				st.close();
				con.close();
			} else {
				System.out.println("Enter Valid Choice:");
			}

		} catch (Exception e) {
			System.err.println("Enter correct ID");
		}
		System.out.println("Table Updated..");
	}

	@Override
	public void deleteData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

			System.out.println("In which table do you want to Delete data");
			String tablen = sc.next();
			System.out.println("Enter Id where you want to delete");
			int id = sc.nextInt();

			String sr = "delete from " + tablen + " where id = " + id + " ";

			Statement st = con.createStatement();

			st.execute(sr);
			st.close();
			con.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Data is deleted..");
		System.out.println(" ");
	}

	@Override
	public void retriveAllData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

			System.out.println("In which table do you want to Retrive data");
			String tablen = sc.next();

			String st = "select * from " + tablen + " ";
			Statement srt = co.createStatement();

			ResultSet rs = srt.executeQuery(st);

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getInt(5));
				System.out.println(rs.getInt(6));

			}

		} catch (Exception e) {

		}
		System.out.println("All Data is Retrieved..");
		System.out.println(" ");

	}

	@Override
	public void retriveSingleData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

			System.out.println("In which table do you want to Retrive data");
			String tablen = sc.next();
			System.out.println("Enter Id where you want to Retrive");
			int id = sc.nextInt();

			String st = "select * from " + tablen + "  where id =" + id + " ";
			Statement srt = co.createStatement();

			ResultSet rs = srt.executeQuery(st);

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getInt(5));
				System.out.println(rs.getInt(6));

			}

		} catch (Exception e) {

		}
		System.out.println("Single Data is Retrieved..");
		System.out.println(" ");

	}
	@Override
	public void storeprocedure() 
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		
		System.out.println("Enter Id :");
		int id = sc.nextInt();
		System.out.println("Enter Ename :");
		String ename = sc.next();
		System.out.println("Enter Eaddress :");
		String eaddr = sc.next();
		System.out.println("Enter EMobile Number :");
		long emobno = sc.nextLong();
		System.out.println("Enter Salary :");
		double esalary = sc.nextDouble();
		System.out.println("Enter EDesignation :");
		String edesign = sc.next();
		
		CallableStatement cs = con.prepareCall("{call insertempdata(?,?,?,?,?,?)}");
		
		cs.setInt(1, id);
		cs.setString(2, ename);
		cs.setString(3, eaddr);
		cs.setLong(4, emobno);
		cs.setDouble(5, esalary);
		cs.setString(6, edesign);
	
		cs.execute();
		con.close();
		
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
