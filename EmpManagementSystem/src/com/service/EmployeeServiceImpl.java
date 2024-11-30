package com.service;
import com.dao.*;
import com.model.Employee.*;

public class EmployeeServiceImpl implements EmployeeServiceI
{
	EmployeeDaoI edi = new EmployeeDaoImpl();
	
	public void createTable(String tname)
	{
		edi.createTable(tname);
	}
	
	
	@Override
	public void addData(Employee e) 
	{
		edi.addData(e);
		
	}
	public void UpdateData(Employee e) 
	{
		edi.UpdateData(e);
		
	}
	public void ViewData(Employee e) 
	{
		edi.ViewData(e);
		
	}
	public void DeleteData(Employee e)
	{
		edi.DeleteData(e);
		
	}
	public void DropTable(Employee e)
	{
		edi.DropTable(e);
		
	}
}

