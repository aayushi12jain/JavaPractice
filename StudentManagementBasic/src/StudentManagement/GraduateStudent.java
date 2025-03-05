package StudentManagement;

public class GraduateStudent extends Student{

	private String researchTopic;

	public GraduateStudent(String name, int studentID, String researchTopic) {
		super(name, studentID);
		this.researchTopic = researchTopic;
	}

	public String getResearchTopic() {
		return researchTopic;
	}

	public void setResearchTopic(String researchTopic) {
		this.researchTopic = researchTopic;
	}
	
	@Override
	public void study() {
		System.out.println("Graduate student is researching on " + researchTopic + ".");
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("researchTopic = " + researchTopic);
	}


}
