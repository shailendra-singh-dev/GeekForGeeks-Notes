package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import data_structures.linkedList.LinkedList;

public class CommonManagerTopBottom {

	static class Employee {
		final String name;
		List<Employee> reporters;

		public Employee(final String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee{" + "name='" + name + '\'' + '}';
		}
	}

	public static Employee closestCommonManager(final Employee ceo,
			final Employee firstEmployee, final Employee secondEmployee) {
		if (ceo == null || firstEmployee == null || secondEmployee == null)
			return null;
		if (!covers(ceo, firstEmployee) && covers(ceo, secondEmployee))
			return null;
		final Queue<Employee> workingQueue = (Queue<Employee>) new LinkedList();
		workingQueue.offer(ceo);
		Employee closestKnownManager = null;
		while (!workingQueue.isEmpty()) {
			Employee employee = workingQueue.poll();
			if (covers(employee, firstEmployee)
					&& covers(employee, secondEmployee)) {
				closestKnownManager = employee;
				for (Employee em : employee.reporters) {
					workingQueue.offer(em);
				}
			}
		}
		return closestKnownManager;
	}

	public static boolean covers(final Employee manager, final Employee employee) {
		if (manager == null)
			return false;
		if (manager.name.equals(employee.name))
			return true;
		if (manager.reporters == null)
			return false;

		boolean covers = false;
		for (Employee em : manager.reporters) {
			covers = covers || covers(em, employee);
		}
		return covers;
	}

	private static boolean isEmployeeReportTo(final Employee manager,
			final Employee employee) {
		boolean isEmployeeFound = false;
		if (manager.reporters == null || manager.reporters.isEmpty()) {
			return false;
		}
		for (Employee emp : manager.reporters) {
			if (emp.name.equals(employee.name)) {
				isEmployeeFound = true;
				break;
			} else {
				isEmployeeReportTo(emp, employee);
			}
		}
		return isEmployeeFound;
	}

	private static Employee getClosestCommanManager(Employee ceo,
			Employee firstEmployee, Employee secondEmployee) {
		Employee closestCommanManager = null;
		if (!(isEmployeeReportTo(ceo, firstEmployee) && isEmployeeReportTo(ceo,
				secondEmployee))) {
			return null;
		}
		Queue<Employee> employeeQueue = (Queue<Employee>) new LinkedList();
		employeeQueue.offer(ceo);

		while (!employeeQueue.isEmpty()) {
			closestCommanManager = employeeQueue.poll();
			if (isEmployeeReportTo(closestCommanManager, firstEmployee)
					&& isEmployeeReportTo(closestCommanManager, secondEmployee)) {
				break;
			} else {
				employeeQueue.addAll(closestCommanManager.reporters);
			}
		}
		return closestCommanManager;
	}

	public static void findClosestCommanManager() {
		Employee bill = new Employee("Bill");

		Employee dom = new Employee("Dom");
		Employee samir = new Employee("Samir");
		Employee michael = new Employee("Michael");

		Employee bob = new Employee("Bob");
		Employee peter = new Employee("Peter");
		Employee porter = new Employee("Porter");

		Employee milton = new Employee("Milton");
		Employee nina = new Employee("Nina");
		// Bill -> Dom, Samir, Michael
		// Dom -> Bob, Peter, Porter
		// Peter -> Milton, Nina

		// closestCommonManager(Nina, Porter) = Dom
		// closestCommonManager(Nina, Samir) = Bill
		// closestCommonManager(Peter, Nina) = Peter

		bill.reporters = Arrays.asList(dom, samir, michael);
		dom.reporters = Arrays.asList(bob, peter, porter);
		peter.reporters = Arrays.asList(milton, nina);

		Employee employee = getClosestCommanManager(bill, porter, nina);// = Dom
		System.out.print("employee:" + employee);

	}

	public static void findCommanManager(String[] args) {
		Employee samir = new Employee("samir");
		Employee dom = new Employee("dom");
		Employee michael = new Employee("michael");

		Employee peter = new Employee("peter");
		Employee porter = new Employee("porter");
		Employee bob = new Employee("bob");

		dom.reporters = Arrays.asList(bob, peter, porter);

		Employee milton = new Employee("milton");
		Employee nina = new Employee("nina");

		peter.reporters = Arrays.asList(milton, nina);

		Employee bill = new Employee("bill");
		bill.reporters = Arrays.asList(dom, samir, michael);

		System.out.println(closestCommonManager(bill, milton, nina));
		System.out.println(closestCommonManager(bill, nina, porter));
		System.out.println(closestCommonManager(bill, nina, samir));
		System.out.println(closestCommonManager(bill, peter, nina));
	}
}
