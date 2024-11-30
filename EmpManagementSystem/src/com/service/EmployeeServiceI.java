package com.service;
import com.model.Employee.*;

public interface EmployeeServiceI
{
	public void createTable(String tname);
	public void addData(Employee e);
	public void UpdateData(Employee e) ;
	public void ViewData(Employee e) ;
	public void DeleteData(Employee e);
	public void DropTable(Employee e);

}
