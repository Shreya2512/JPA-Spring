package com.cg.jpacrud.dao;

import java.util.List;

import com.cg.jpacrud.entities.Employee;

public interface EmployeeDao {

	public abstract Employee getEmpById(int id);

	public abstract void addEmployee(Employee emp);

	public abstract void removeEmployee(Employee emp);

	public abstract Employee updateEmployee(Employee emp);

	public abstract void commitTransaction();

	public abstract void beginTransaction();

	public abstract List<Employee> getAllEmp();

}