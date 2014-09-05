package com.phoenixjcam.controller;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phoenixjcam.employee.model.EmployeeModel;
import com.phoenixjcam.employee.service.EmployeeService;
import com.phoenixjcam.table.models.DataCover;
import com.phoenixjcam.table.models.Employee;

@Controller
public class TableController
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView("template");
		
		modelAndView.addObject("workspace", "dashboard");
		modelAndView.addObject("mainColumn", "table");

		return modelAndView;
	}
	
	// json response - jquery ajax request as asynch
	@RequestMapping(value = "/getEmployers", method = RequestMethod.GET)
	public @ResponseBody DataCover<Employee> getEmployers(
		@RequestParam (value = "order[0][column]") Integer orderColumn,
		@RequestParam (value = "order[0][dir]") String orderDirection,
		@RequestParam (value = "start") Integer start, 
		@RequestParam (value = "length") Integer length, 
		@RequestParam (value = "draw") Integer draw,
		@RequestParam (value = "search[value]") String query)
	{
		long totalEmployeesCount = employeeService.getEmployeesCount();
		long filteredEmployeesCount = employeeService.getEmployeesCount(query);
		List<EmployeeModel> employees = employeeService.getEmployees( start, length, query, orderColumn, orderDirection );
		
		List<Employee> data = new ArrayList<Employee>();
		
		for ( EmployeeModel el : employees )
		{
			Employee row = new Employee();
			
			LocalDateTime startDate = el.getStartDate();
			
			row.setId( el.getId() );
			row.setLastName( el.getLastName() );
			row.setFirstName( el.getFirstName() );
			row.setPosition( el.getPosition() );
			row.setOffice( el.getOffice() );
			row.setStartDate( startDate.getDayOfMonth() + "." + startDate.getMonthOfYear() + "." + startDate.getYear());
			row.setSalary( el.getSalary() );
			
			//	row.setEdit("<a href='edit/" + el.getId() + "'>Edit</a>");
			//	row.setUpdate("<a href='update/" + el.getId() + "'>Update</a>");
			//	row.setDelete("<a href='delete/" + el.getId() + "'>Delete</a>");

			data.add( row );
		}

		// json response packed as DataCover
		DataCover<Employee> cover = new DataCover<Employee>();

		cover.setDraw(draw);
		cover.setRecordsTotal(totalEmployeesCount);
		cover.setRecordsFiltered(filteredEmployeesCount);
		cover.setData(data);

		return cover;
	}
}
