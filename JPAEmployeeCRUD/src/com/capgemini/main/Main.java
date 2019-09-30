package com.capgemini.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.pojo.Employee;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		System.out.println("1.Add employee\n2.Find employee\n3.Find all employee\n4.Update\n5.Delete employee");
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
			em.getTransaction().begin();
			em.persist(emp);
			em.getTransaction().commit();
			break;

		case 2:
			System.out.println("Enter emp id");
			id = sc.nextInt();
			Employee emp1 = em.find(Employee.class, id);
			System.out.println(emp1);
			break;

		case 3:
			Query query = em.createQuery("From Employee");
			List<Employee> list = query.getResultList();
			Iterator itr = list.iterator();
			while (itr.hasNext()) {
				emp = (Employee) itr.next();
				System.out.println(emp);
			}
			break;

		case 4:
			System.out.println("Enter emp id");
			id = sc.nextInt();
			System.out.println("Enter salary to be updated");
			sal = sc.nextDouble();
			em.getTransaction().begin();
			String query1 = "Update Employee e Set e.salary=:sal"+" where e.employeeId=:id";
			Query tquery = em.createQuery(query1);
			
			tquery.setParameter("sal", sal);
			tquery.setParameter("id", id);
			tquery.executeUpdate();
			em.getTransaction().commit();
			
			break;

		case 5:
			System.out.println("Enter emp id");
			id = sc.nextInt();
			emp = em.find(Employee.class, id);
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
			System.out.println("Data deleted");
			System.out.println(emp);
			break;

		}

	}

}
