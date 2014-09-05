package com.phoenixjcam.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenixjcam.employee.dao.EmployeeDAO;
import com.phoenixjcam.employee.mediators.SalaryStatModel;
import com.phoenixjcam.employee.model.EmployeeModel;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public void addEmployee(EmployeeModel employee)
	{
		employeeDAO.addEmployee(employee);
	}

	@Override
	public void updateEmployee(EmployeeModel employee)
	{
		employeeDAO.updateEmployee(employee);
	}

	@Override
	public EmployeeModel getEmployee(int id)
	{
		return employeeDAO.getEmployee(id);
	}

	@Override
	public void deleteEmployee(int id)
	{
		employeeDAO.deleteEmployee(id);
	}
	
	@Override
	public List<EmployeeModel> getEmployees(int pageNumber, int pageSize)
	{
		return employeeDAO.getEmployees(pageNumber, pageSize);
	}

	@Override
	public List<EmployeeModel> getEmployees(int pageNumber, int pageSize, String query, Integer orderColumn, String orderDirection)
	{
		return employeeDAO.getEmployees(pageNumber, pageSize, query, orderColumn, orderDirection);
	}

	@Override
	public long getEmployeesCount()
	{
		return employeeDAO.getEmployeesCount();
	}
	
	@Override
	public long getEmployeesCount(String query)
	{
		return employeeDAO.getEmployeesCount(query);
	}

	@Override
	public List<SalaryStatModel> getSalaryStats()
	{
		return employeeDAO.getSalaryStats();
	}
}
