package proxyDesignPattern;

public interface EmployeeDao {
	public void create(String userType, String name);
	public void delete(String userType, String name);
	public String get(String userType, String name);
}
