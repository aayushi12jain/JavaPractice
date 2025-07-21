package mainApp;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws ValidationException {
		
		//main menu
		Scanner input = new Scanner(System.in);
		String selection = "";
		DataStorage data = new SQL_Database();
		
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			//display the menu
			System.out.println();
			System.out.println("Please make your selection: ");
			System.out.println("1: Create User");
			System.out.println("2: Login");
			System.out.println("x: Finish");
			
			//get the selection from the user
			selection = input.nextLine();
			System.out.println();
			
			if(selection.equals("1")){
				new UserCreator(data).createUser();
			}else if(selection.equals("2")) {
				new LoginWindow(data).login();
			}
		}

	}
}
