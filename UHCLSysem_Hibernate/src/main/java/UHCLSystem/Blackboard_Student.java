package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard_Student extends Blackboard{

	/**
	 * @param id
	 * @param d
	 */
	public Blackboard_Student(String id, Data d) {
		super(id, d);
		// TODO Auto-generated constructor stub
	}

	 
	@Override
	public void viewMyCourses()
	{
		Scanner input = new Scanner(System.in);
		ArrayList<String>myCourses = super.getD().getMyCourses(getId());
		for(int i=0; i<myCourses.size(); i++)
		{
			System.out.printf("%d: %s\n", i+1, myCourses.get(i));
		}
		System.out.println("Please enter your choice for the course registration: ");
		String intSel = input.nextLine();
		String selection = "";
		if(isInteger.test(intSel))
		{
			int sel = Integer.parseInt(intSel);
			if(sel>0 && sel<=myCourses.size())
			{
				selection = myCourses.get(sel-1);
				ArrayList<CourseNote> notes = super.getD().getCourseNotes(selection);
				System.out.println("Course Notes: ");
				for(CourseNote n: notes)
				{
					System.out.println(n.getUserID() + ": " + n.getContent() + ", " + n.getDatetime());
				}
			}
			
		}
	}
	
	

}
