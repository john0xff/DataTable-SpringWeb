package com.phoenixjcam.employee.dao;

import java.util.List;

import com.phoenixjcam.employee.mediators.SalaryStatModel;
import com.phoenixjcam.employee.model.EmployeeModel;

public interface EmployeeDAO
{
	public void addEmployee(EmployeeModel employee);

	public void updateEmployee(EmployeeModel employee);

	public EmployeeModel getEmployee(int id);

	public void deleteEmployee(int id);

	public List<EmployeeModel> getEmployees();

	public List<EmployeeModel> getEmployees(int offset, int pageSize);

	public List<EmployeeModel> getEmployees(int offset, int pageSize, String query, Integer orderColumn, String orderDirection);

	public long getEmployeesCount();

	public long getEmployeesCount(String query);

	public List<SalaryStatModel> getSalaryStats();
}
