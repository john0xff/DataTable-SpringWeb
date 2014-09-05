package com.phoenixjcam.employee.mediators;


public class SalaryStatModel
{
	private String position;
	private double averageSalary;
	private double minSalary;
	private double maxSalary;
	private long count;

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public double getAverageSalary()
	{
		return averageSalary;
	}

	public void setAverageSalary(double averageSalary)
	{
		this.averageSalary = averageSalary;
	}

	public double getMinSalary()
	{
		return minSalary;
	}

	public void setMinSalary(double minSalary)
	{
		this.minSalary = minSalary;
	}

	public double getMaxSalary()
	{
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary)
	{
		this.maxSalary = maxSalary;
	}

	public long getCount()
	{
		return count;
	}

	public void setCount(long count)
	{
		this.count = count;
	}
}
