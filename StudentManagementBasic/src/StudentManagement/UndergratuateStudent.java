package StudentManagement;

public class UndergratuateStudent extends Student{
	
	private String major;

	public UndergratuateStudent(String name, int studentID, String major) {
		super(name, studentID);
		this.major=major;
		// TODO Auto-generated constructor stub
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public void study() {
		System.out.println("Undergraduate student is studying for exams.");
	}
	
	@Override
	public void displayInfo() {
		System.out.println("name = " + getName() + ", studentID = " + getStudentID() + ", major = " + major);
	}
	
	

}
