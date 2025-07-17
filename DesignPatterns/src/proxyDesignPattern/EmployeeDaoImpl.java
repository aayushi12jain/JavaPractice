package proxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void create(String userType, String name) {
		System.out.println("New Employee is created with name " + name);
		
	}

	@Override
	public void delete(String userType, String name) {
		System.out.println("Employee is deleted with name " + name );
		
	}

	@Override
	public String get(String userType, String name) {
		System.out.println("Data Retrived for " + name);
		return name;
	}

}
