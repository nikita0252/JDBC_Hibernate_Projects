package m2m;

import java.util.Scanner;

public class Test 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Data d = new Data();
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
			d.insertData();
			break;
			
		case 2:
			d.viewSingleData();
			break;
			
		case 3:
			d.viewAllData();
			break;
			
		}
		}
	}
}
