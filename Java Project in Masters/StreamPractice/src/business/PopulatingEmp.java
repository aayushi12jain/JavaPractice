package business;

import java.util.*;
import java.util.Map.*;
import java.util.stream.*;

public class PopulatingEmp {
	
	public static void main(String[] args) {
		List<Employee> empList = new PopulatingEmp().populatingEmp();
		empList.stream().forEach(e -> {System.out.println(e.toString());});
		
		// How many male and female employees are there in the organization?
		System.out.println("---------");
		Map<String, Long> noOfEmpBasedGender = empList.stream().collect(
				Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		noOfEmpBasedGender.forEach((key,value)->{System.out.println(key + " : " + value);})	;
		System.out.println(noOfEmpBasedGender);
		
		//Print the name of all departments in the organization?
		System.out.println("---------");
		List<String> deptNames = empList.stream().map(Employee::getDepartment).distinct().toList();
		System.out.println(deptNames);
		deptNames.forEach(dept->System.out.println(dept));
		
		//What is the average age of male and female employees?
		System.out.println("---------");
		Map<String,Double> avgAgeOfEmp = empList.stream().collect(Collectors.groupingBy(
				Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		
		System.out.println(avgAgeOfEmp);
		
		//Get the details of highest paid employee in the organization?
		System.out.println("---------");
		Optional<Employee> highestPaidEmpWrapper = empList.stream().collect(
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		Employee highestPaidEmp = highestPaidEmpWrapper.get();
		System.out.println(highestPaidEmp.toString());
		
		
		// Get the names of all employees who have joined after 2015?
		System.out.println("---------");
		empList.stream().filter(e-> e.getYearOfJoining()>2015)
				.map(Employee::getName).forEach(System.out::println);
		
		//Count the number of employees in each department?
		System.out.println("---------");
		Map<String,Long> noOfEmployeesDept = empList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		noOfEmployeesDept.forEach((dept,num)->{System.out.println(dept + "  :  " + num);});
		
		//What is the average salary of each department?
		System.out.println("---------");
		Map<String,Double> avgSalOfEmployeesDept = empList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		avgSalOfEmployeesDept.forEach((dept,num)->{System.out.println(dept + "  :  " + num);});
		
		//Get the details of youngest male employee in the product development department?
		System.out.println("---------");
		Optional<Employee> youngestEmpWrapper = empList.stream()
				.filter(e->e.getDepartment().equals("Product Development")).collect(
						Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
		Employee youngestEmp = youngestEmpWrapper.get();
		System.out.println(youngestEmp.toString());

		//Who has the most working experience in the organization?
		System.out.println("---------");
		Optional<Employee> mostWorkExpEmpWrapper = empList.stream().collect(
				Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
		Employee mostWorkExpEmp = mostWorkExpEmpWrapper.get();
		System.out.println(mostWorkExpEmp.toString());
		
		//How many male and female employees are there in the sales and marketing team?
		System.out.println("---------");
		Map<String, Long> noOfEmpDept = empList.stream()
				.filter(e->e.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(noOfEmpDept);
				
		//What is the average salary of male and female employees?
		System.out.println("---------");
		Map<String, Double> avgSalOfEmp = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalOfEmp);
		
		//List down the names of all employees in each department?
		System.out.println("---------");
		Map<String,List<Employee>> empOfDeptMap = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String,List<Employee>>> entrySet = empOfDeptMap.entrySet();
		
		for(Entry<String,List<Employee>> entry : entrySet){
			System.out.println("Department : " + entry.getKey());
			//entry.getValue().stream().map(e->e.getName()).forEach(x->{System.out.println(x);});
			entry.getValue().stream().map(e->e.getName()).forEach(System.out::println);
			System.out.println("..............");
		}
		
		//What is the average salary and total salary of the whole organization?
		System.out.println("---------");
		Double totalSal = empList.stream().collect(Collectors.summingDouble(Employee::getSalary));
		Double avgSal = empList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		
		System.out.println("Total Salary : " + totalSal);
		System.out.println("Average Salary : " + avgSal);
		
		// Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		System.out.println("---------");
		Map<Boolean, List<Employee>> empPartition = empList.stream()
				.collect(Collectors.partitioningBy(e ->e.getAge()>25)); 
		
		Set<Entry<Boolean,List<Employee>>> entrySetPart = empPartition.entrySet();
		
		for(Entry<Boolean,List<Employee>> entry : entrySetPart){
			System.out.println("Age Under 25 : " + entry.getKey());
			//entry.getValue().stream().map(e->e.getName()).forEach(x->{System.out.println(x);});
			entry.getValue().stream().map(e->e.getName()).forEach(System.out::println);
			System.out.println("..............");
		}
		
		//Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Optional<Employee> oldestEmpWrapper = empList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
		Employee oldestEmp = oldestEmpWrapper.get();
		System.out.println(oldestEmp.toString());
	}
	
	public List<Employee> populatingEmp() {
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		return employeeList;
	}

}
