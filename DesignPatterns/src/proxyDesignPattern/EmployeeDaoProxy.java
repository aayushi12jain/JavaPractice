package proxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao{
	
	EmployeeDaoImpl emp ;
	
	public EmployeeDaoProxy() {
		this.emp = new EmployeeDaoImpl();
	}

	@Override
	public void create(String userType, String name) {
		if(userType.equals("ADMIN")) {
			emp.create(userType, name);
		}else {
			System.out.println("Access Denied");
		}
		
	}

	@Override
	public void delete(String userType, String name) {
		if(userType.equals("ADMIN")) {
			emp.delete(userType, name);
		}else {
			System.out.println("Access Denied");
		}
		
	}

	@Override
	public String get(String userType, String name) {
		String empData = null;
		if(userType.equals("ADMIN") || userType.equals("USER")) {
			empData = emp.get(userType, name);
		}
		return empData;
	}

}
