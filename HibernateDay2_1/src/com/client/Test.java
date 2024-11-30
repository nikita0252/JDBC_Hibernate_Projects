package com.client;
import com.config.*;
import com.service.*;
import com.serviceImpl.*;
import com.model.*;

import java.util.Scanner;

public class Test 
{
	public static void main(String[] args) 
	{
		Data u = new Data();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
		System.out.println("1.Insert Data: ");
		System.out.println("2.View_Single Data: ");
		System.out.println("3.View_All Data: ");
		System.out.println("4.Update Data: ");
		System.out.println("5.DeleteSingle Data: ");
		System.out.println("6.DeleteAll Data: ");
		System.out.println("7.Exit");
		System.out.println(" ");

		System.out.println("Enter your Choice: ");
		int ch = sc.nextInt();

		switch (ch) 
		{
		case 1:
			u.insertData();
			break;
			
		case 2:
			u.viewSingleData();
			break;
			
		case 3:
			u.viewAllData();
			break;
			
		case 4:
			u.updateData();
			break;
			
		case 5:
			u.deleteSingleData();
			break;
			
		case 6:
			u.deleteAllData();
			break;
			
		default :
			System.out.println("Exit");
		}
		
	}
	}

}
