package com.client;
import com.controller.*;
import java.util.*;
import com.model.Employee.*;
import com.dao.*;

public class TestUI 
{
	public static void main(String[] args) 
	{
		EmployeeController e = new EmployeeController();
		Employee e1 = new Employee();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
		System.out.println("************Menu*************");
		System.out.println(" ");
		System.out.println("1.Create Table: ");
		System.out.println("2.Add Employee: ");
		System.out.println("3.View Employee: ");
		System.out.println("4.Update Employee: ");
		System.out.println("5.Delete Employee: ");
		System.out.println("6.Drop Table: ");
		System.out.println("7.Default");
		
		int ch= sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Enter the table name : ");
			String tablename = sc.next();
			e.createTable(tablename);
			break;
		case 2:
			
			System.out.println("Enter Employee ID:");
			int eid = sc.nextInt();
			e1.setEid(eid);
			System.out.println("Enter Name:");
			String ename = sc.next();
			e1.setEname(ename);
			System.out.println("Enter Mobile No:");
			Long emob = sc.nextLong();
			e1.setEmob(emob);
			System.out.println("Enter Address: ");
			String eaddr = sc.next();
			e1.setEaddr(eaddr);
			System.out.println("Enter Salary: ");
			double esalary = sc.nextDouble();
			e1.setEsalary(esalary);
			
			e.addData(e1);
			break;
			
		case 3:
			e.ViewData(e1);
			break;
		
		case 4:
		
			e.UpdateData(e1);
			break;
			
		case 5:
			e.DeleteData(e1);
			break;
		
		case 6:
			e.DropTable(e1);
			break;
			
		default:
			System.out.println("Enter Valid Choice");
			
		}
		
	}
	}
}
