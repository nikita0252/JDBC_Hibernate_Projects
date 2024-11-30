package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id: ");
		int id = sc.nextInt();
		System.out.println("Enter Name: ");
		String name = sc.next();
		System.out.println("Enter Address: ");
		String addr = sc.next();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

		System.out.println("Enter table name");
		String tname = sc.next();
		String str = "insert into " + tname + " values(?,?,?)";

		PreparedStatement ps = con.prepareStatement(str);

		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, addr);
		ps.executeUpdate();

		ps.close();
		con.close();

	}

}
