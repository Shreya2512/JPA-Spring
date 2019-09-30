package com.cg.jpacrud.service;

import java.util.List;

import com.cg.jpacrud.entities.Employee;

public interface EmployeeService {

	public abstract void addEmp(Employee student);

	public abstract Employee updateEmp(Employee student);

	public abstract void removeEmp(Employee student);

	public abstract Employee findEmpById(int id);

	public abstract List<Employee> findAllEmp();

}