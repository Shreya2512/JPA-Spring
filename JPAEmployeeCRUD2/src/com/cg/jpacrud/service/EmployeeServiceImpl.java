package com.cg.jpacrud.service;

import java.util.List;

import com.cg.jpacrud.dao.EmployeeDao;
import com.cg.jpacrud.dao.EmployeeDaoImpl;
import com.cg.jpacrud.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDaoImpl();
	}
	
		
	@Override
	public void addEmp(Employee emp) {
		dao.beginTransaction();
		dao.addEmployee(emp);
		dao.commitTransaction();
		
	}

	@Override
	public Employee updateEmp(Employee emp) {
		dao.beginTransaction();
		Employee emp1=dao.updateEmployee(emp);
		dao.commitTransaction();
		return emp1;
		
	}

	@Override
	public void removeEmp(Employee emp) {
		dao.beginTransaction();
		dao.removeEmployee(emp);
		dao.commitTransaction();
		
	}

	@Override
	public Employee findEmpById(int id) {
		Employee emp = dao.getEmpById(id);
		return emp;
	}


	@Override
	public List<Employee> findAllEmp() {
		List<Employee> list= dao.getAllEmp();
		return list;
	}
}
