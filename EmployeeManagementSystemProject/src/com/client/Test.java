package com.client;

import java.util.Scanner;

import com.servicei.*;
import com.serviceimpl.*;

public class Test {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ServiceI s = new ServiceImpl();
//	s.createTable();
//	s.insertData();
//	s.updateData();

		while (true) {
			System.out.println("1.Create Table:");
			System.out.println("2.Insert Data:");
			System.out.println("3.Update Data:");
			System.out.println("4.Delete Data:");
			System.out.println("5.Retrive Data:");
			System.out.println("6.RetriveSingle Data:");
			System.out.println("7.Store Procedure:");
			System.out.println("8.Exit..");
			System.out.println(" ");
			System.out.println("Enter the choice");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Create a Table");
				s.createTable();
				break;

			case 2:
				System.out.println("Insert Data");
				s.insertData();
				break;

			case 3:
				System.out.println("Update Data");
				s.updateData();
				break;

			case 4:
				System.out.println("Delete Data");
				s.deleteData();
				break;

			case 5:
				System.out.println("Retrive All Data");
				s.retriveAllData();
				break;

			case 6:
				System.out.println("Retrive single Data");
				s.retriveSingleData();
				break;

			case 7:
				System.out.println("Stored Procedure");
				s.storeprocedure();
				break;

			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
			}

		}
	}
}
