package com.controller;
import com.model.Employee.*;
import com.service.*;

public class EmployeeController 
{
	EmployeeServiceI es = new EmployeeServiceImpl();
	
	public void createTable(String tname)
	{
		//System.out.println("tablename :");
		es.createTable(tname);

	}
	
	public void addData(Employee e)
	{
		es.addData(e);
		
	}
	public void UpdateData(Employee e)
	{
		es.UpdateData(e);
		
	}
	public void ViewData(Employee e)
	{
		es.ViewData(e);
		
	}
	public void DeleteData(Employee e)
	{
		es.DeleteData(e);
		
	}
	public void DropTable(Employee e)
	{
		es.DropTable(e);
		
	}
	

}
