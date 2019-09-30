package com.cg.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.jpacrud.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = emf.createEntityManager();

	

	public EmployeeDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	@Override
	public Employee getEmpById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
		
	}

	@Override
	public void addEmployee(Employee emp) {
		entityManager.persist(emp);
		
	}

	@Override
	public void removeEmployee(Employee emp) {
		entityManager.remove(emp);
		
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee emp1=entityManager.merge(emp);
		return emp1;
		
	}

	@Override
	public List<Employee> getAllEmp() {
		Query query = entityManager.createQuery("From Employee");
		List<Employee> list = query.getResultList();
		return list;
	}
}
