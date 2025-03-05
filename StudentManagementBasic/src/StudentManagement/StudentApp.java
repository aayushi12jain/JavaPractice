package StudentManagement;

public class StudentApp {
	
	public static void main(String[] args) {
		
		Student[] std = new Student[2];
		std[0]= new GraduateStudent("Aayushi", 2345, "Java");
		std[1] = new UndergratuateStudent("Arpit", 2321, "MIS");
		
		for(Student s: std) {
			s.study();
			s.displayInfo();
			System.out.println();
		}
		
		System.out.println(std[0].toString());
		
		
	}

}
