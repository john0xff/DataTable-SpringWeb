package com.phoenixjcam.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenixjcam.employee.mediators.SalaryStatModel;
import com.phoenixjcam.employee.model.EmployeeModel;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addEmployee(EmployeeModel employee)
	{
		getCurrentSession().save(employee);
	}

	@Override
	public void updateEmployee(EmployeeModel employee)
	{
		// EmployeeModel employeeUpdate = getEmployee( employee.getEmplId() );
		// employeeUpdate.setFirstName( employee.getFirstName() );
		// employeeUpdate.setLastName( employee.getLastName() );
		// getCurrentSession().update( employeeUpdate );
	}

	@Override
	public EmployeeModel getEmployee(int id)
	{
		EmployeeModel employee = (EmployeeModel) getCurrentSession().get(EmployeeModel.class, id);

		return employee;
	}

	@Override
	public void deleteEmployee(int id)
	{
		EmployeeModel employee = getEmployee(id);
		if (employee != null)
			getCurrentSession().delete(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getEmployees()
	{
		int pageNumber = 1;
		int pageSize = 10;
		List<EmployeeModel> result = getCurrentSession().createCriteria(EmployeeModel.class).setFirstResult((pageNumber - 1) * pageSize)
				.setMaxResults(pageSize).list();
		return result;
		// return getCurrentSession().createQuery("from EmployeeModel").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getEmployees(int offset, int length)
	{
		List<EmployeeModel> result = getCurrentSession().createCriteria(EmployeeModel.class).setFirstResult(offset).setMaxResults(length).list();

		return result;

		// return getCurrentSession().createQuery("from EmployeeModel").list();
	}

	private boolean isInteger(String text)
	{
		if (text.length() == 0)
			return false;

		for (int i = 0; i < text.length(); ++i)
		{
			if (Character.isDigit(text.charAt(i)) == false)
				return false;
		}

		return true;
	}

	private Criteria prepareOrder(Criteria criteria, int orderColumn, String orderDirection)
	{
		String columnName = null;

		switch (orderColumn)
		{
			case 0:
				columnName = "id";
				break;

			case 1:
				columnName = "lastName";
				break;

			case 2:
				columnName = "firstName";
				break;

			case 3:
				// columnName = "";
				break;

			case 4:
				// columnName = "";
				break;
		}

		if (columnName != null)
		{
			Property property = Property.forName(columnName);

			if ("asc".equals(orderDirection))

				criteria.addOrder(property.asc());

			else
				criteria.addOrder(property.desc());
		}

		return criteria;
	}

	private Criteria prepareQuery(Criteria criteria, String query)
	{
		Criterion lastName = Restrictions.like("lastName", query, MatchMode.ANYWHERE);
		Criterion firstName = Restrictions.like("firstName", query, MatchMode.ANYWHERE);

		Criterion disjuction = Restrictions.or(lastName, firstName);

		if (this.isInteger(query))
		{
			Criterion id = Restrictions.like("id", Integer.parseInt(query));
			disjuction = Restrictions.or(disjuction, id);
		}

		return criteria.add(disjuction);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getEmployees(int offset, int length, String query, Integer orderColumn, String orderDirection)
	{
		Criteria criteria = getCurrentSession().createCriteria(EmployeeModel.class).setFirstResult(offset).setMaxResults(length);

		this.prepareOrder(criteria, orderColumn, orderDirection);
		this.prepareQuery(criteria, query);

		List<EmployeeModel> result = criteria.list();

		return result;
	}

	@Override
	public long getEmployeesCount()
	{
		long count = (long) this.getCurrentSession().createCriteria(EmployeeModel.class).setProjection(Projections.count("id")).uniqueResult();

		return count;
	}

	@Override
	public long getEmployeesCount(String query)
	{
		Criteria criteria = this.getCurrentSession().createCriteria(EmployeeModel.class).setProjection(Projections.count("id"));

		long count = (long) this.prepareQuery(criteria, query).uniqueResult();

		return count;
	}
	
	@Override
	public List<SalaryStatModel> getSalaryStats()
	{
		@SuppressWarnings("unchecked")
		List<SalaryStatModel> result = this.getCurrentSession()
				.createCriteria(EmployeeModel.class)
				.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("position"))
					.add(Projections.avg("salary"), "averageSalary")
					.add(Projections.min("salary"), "minSalary")
	                .add(Projections.max("salary"), "maxSalary")
	                .add(Projections.rowCount(), "count")
				)
				.setResultTransformer(new ResultTransformer() {

					private static final long serialVersionUID = 1L;

					@Override
					public Object transformTuple(Object[] tuple, String[] aliases)
					{
						SalaryStatModel model = new SalaryStatModel();
						
						model.setPosition((String)tuple[0]);
						model.setAverageSalary((double)tuple[1]);
						model.setMinSalary(Double.parseDouble((String) tuple[2]));
						model.setMaxSalary(Double.parseDouble((String) tuple[3]));
						model.setCount((long)tuple[4]);
						
						return model;
					}

					@SuppressWarnings("rawtypes")
					@Override
					public List transformList(List collection)
					{
						return collection;
					}
					
				})
//				.setResultTransformer(Transformers.aliasToBean(SalaryStatModel.class)
//						.transformList(new ArrayList<E>))
				.list();
		
		return result;
	}
}
