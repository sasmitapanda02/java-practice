package assignement2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class EmployeeList {

	public static List<Employee> getListOfEmployees() {


		List<Employee> listOfEmployees = new ArrayList<>();
		Employee e1 = new Employee("Sasmita", 22,Arrays.asList("Pune","Banglore"));
		Employee e2 = new Employee("Subham", 21,Arrays.asList("Chennai","Hyderabad"));
		Employee e3 = new Employee("Pihu", 25,Arrays.asList("Hyderabad","Bangalore"));
		Employee e4 = new Employee("Sanchi", 30,Arrays.asList("Mumbai","Kolkata"));
		Employee e5 = new Employee("Isha", 26,Arrays.asList("Dubai","USA"));
		Employee e6 = new Employee("Biswa", 31,Arrays.asList("Ahmedabad","Kerala"));
		Employee e7 = new Employee("Sarmistha", 28,Arrays.asList("Raipur","Koraput"));
		Employee e8 = new Employee("Prasanta", 32,Arrays.asList("Delhi","Indore"));
		
		listOfEmployees.add(e1);
		listOfEmployees.add(e2);
		listOfEmployees.add(e3);
		listOfEmployees.add(e4);
		listOfEmployees.add(e5);
		listOfEmployees.add(e6);
		listOfEmployees.add(e7);
		listOfEmployees.add(e8);

		return listOfEmployees;
	}

	public static void main(String[] args) {
		// Exe-1
		List<Employee> employeesList = getListOfEmployees();
		employeesList.stream().flatMap(s -> s.getListOfCities().stream()).forEach(System.out::println);

		// Exe-2
		System.out
				.println("Are all the employees adult ? " + employeesList.stream().allMatch(emp -> emp.getAge() > 18));
		// Exe-3
		System.out
				.println("Are all the employees adult ? " + employeesList.stream().allMatch(emp -> emp.getAge() < 60));
		

		// Exe-4
		List<Employee> empage = getListOfEmployees();
		empage.stream().filter(emp -> emp.getAge() > 30).map(s -> s.getName())
				.forEach(s -> System.out.println("greaterthat 30 age=" + s));

		// Exe-5
		List<Employee> employeesGetName = getListOfEmployees();
		employeesGetName.stream().filter(emp -> emp.getAge() > 30).map(e -> e.getName()).forEach(System.out::println);

		// Exe-6
		List<Employee> employeesList1 = getListOfEmployees();
		Map<Integer, List<Employee>> map = employeesList1.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println(map);

		// Exe-6
		List<Employee> groupname = getListOfEmployees();
		groupname.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println(groupname);

		// Exe-7
		List<Employee> empName = getListOfEmployees();
		empName.stream().map(Employee::getName).collect(Collectors.joining(","));
		System.out.println("employees are :" + empName);

		// Exe-8
		List<Employee> agesort = getListOfEmployees();
		agesort.stream().map(age -> age.getAge()).sorted((a1, a2) -> a1.compareTo(a2)).collect(Collectors.toList());
		System.out.println("age sorted " + agesort);
		agesort.forEach(System.out::println);

		// Exe-9
		List<Employee> maxage = getListOfEmployees();
		maxage.stream().max((v1, v2) -> {
			return v1.compareTo(v2);

		});

		System.out.println(maxage);

		// Exe-10
		List<Employee> agecount = getListOfEmployees();
		agecount.stream().filter(age -> age.getAge() > 25).distinct().count();
		agecount.forEach(System.out::println);
		

	}
}
