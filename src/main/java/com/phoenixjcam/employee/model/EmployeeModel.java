package com.phoenixjcam.employee.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "employees", catalog = "jv_crm")
public class EmployeeModel
{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id;

	@Column(name = "last_name", nullable = false, length = 30)
	String lastName;

	@Column(name = "first_name", nullable = false, length = 30)
	String firstName;

	@Column(name = "position", nullable = false, length = 30)
	String position;

	@Column(name = "office", nullable = false, length = 30)
	String office;

	@Column(name = "start_date", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime startDate;

	@Column(name = "salary", nullable = false, length = 30)
	String salary;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String getOffice()
	{
		return office;
	}

	public void setOffice(String office)
	{
		this.office = office;
	}

	public LocalDateTime getStartDate()
	{
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate)
	{
		this.startDate = startDate;
	}

	public String getSalary()
	{
		return salary;
	}

	public void setSalary(String salary)
	{
		this.salary = salary;
	}
}
