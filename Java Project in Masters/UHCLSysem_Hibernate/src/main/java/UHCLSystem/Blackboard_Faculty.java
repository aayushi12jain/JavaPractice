package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard_Faculty extends Blackboard{

	/**
	 * @param id
	 * @param d
	 */
	public Blackboard_Faculty(String id, Data d) {
		super(id, d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void viewMyCourses()
	{
		Scanner input = new Scanner(System.in);
		ArrayList<String> teachings = getD().getMyTeachingCourses(getId());
		for(int i=0; i<teachings.size(); i++)
		{
			System.out.printf("%d: %s\n", i+1, teachings.get(i));
		}
		System.out.println("Please select a course of your teaching to view: ");
		String intSel = input.nextLine();
		String course = "";
		if(isInteger.test(intSel))
		{
			int sel = Integer.parseInt(intSel);
			
			if(sel>0 && sel<=teachings.size())
			{
				course = teachings.get(sel-1);
				System.out.println("Please select: ");
				System.out.println("w: write a course note");
				System.out.println("v: view all notes of this course");
				System.out.println();
				
				String selection = input.nextLine();
				if(selection.equals("v"))
				{
					ArrayList<CourseNote> notes = super.getD().getCourseNotes(course);
					System.out.println("Course Notes: ");
					for(CourseNote n: notes)
					{
						System.out.println(n.getContent() + ", " + n.getDatetime());
					}
					System.out.println();
				}
				
				if(selection.equals("w"))
				{
					System.out.println("Please type in your note for this course: ");
					String note = input.nextLine();
					super.getD().writeNote(getId(), note, course, DateAndTime.DateTime());
				}
			}
			
		}
	}

}
