package StudentManagement;

public class Student {
	
	private String name;
	

	private int studentID;
	
	public Student(String name, int studentID) {
		super();
		this.name = name;
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public void study() {
		System.out.println("Student is studying");
	}
	
	public void displayInfo() {
		System.out.println("name = " + name + ", studentID = " + studentID);
	}
	
	
	

}
