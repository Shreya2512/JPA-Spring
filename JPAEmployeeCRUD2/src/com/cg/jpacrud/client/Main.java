package com.cg.jpacrud.client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpacrud.entities.Employee;
import com.cg.jpacrud.service.EmployeeService;
import com.cg.jpacrud.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {

		EmployeeService service = new EmployeeServiceImpl();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		Scanner sc = new Scanner(System.in);

		System.out.println("1.Add employee\n2.Find employee\n3.Update\n4.Delete employee\n5.Find all employees");
		int ch = sc.nextInt();
		switch (ch) {

		case 1:
			System.out.println("Enter emp id");
			int id = sc.nextInt();
			System.out.println("enter employee name");
			String name = sc.next();
			System.out.println("Enter salary");
			double sal = sc.nextDouble();
			Employee emp = new Employee(id, name, sal);
			service.addEmp(emp);
			break;

		case 2:
			System.out.println("Enter emp id");
			id = sc.nextInt();
			Employee emp1 = service.findEmpById(id);
			System.out.println(emp1);
			break;

		case 3:
			System.out.println("Enter emp id");
			id = sc.nextInt();
			System.out.println("enter employee name");
			name = sc.next();
			System.out.println("Enter salary");
			sal = sc.nextDouble();
			emp = new Employee(id, name, sal);
			Employee emp2 = service.updateEmp(emp);
			System.out.println(emp2);
			break;

		case 4:
			System.out.println("Enter emp id");
			id = sc.nextInt();
			System.out.println("enter employee name");
			name = sc.next();
			System.out.println("Enter salary");
			sal = sc.nextDouble();
			emp = new Employee(id, name, sal);
			service.removeEmp(emp);
			break;

		case 5:
			List<Employee> list = service.findAllEmp();
			Iterator<Employee> itr = list.iterator();
			while (itr.hasNext()) {
				emp = itr.next();
				System.out.println(emp);
			}
			break;
		}

	}

}
