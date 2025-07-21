package mainApp;

import java.util.Scanner;
import java.util.regex.Pattern;


public class UserCreator {
	private DataStorage data;
    
	public UserCreator(DataStorage d)
	{
		data = d;
	}
	
	public void createUser() throws ValidationException
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter userId: ");
		String name = input.nextLine();
		validateUserName(name);
		System.out.println("Please enter password: ");
		String pswd = input.nextLine();
		validatePassword(name, pswd);
		System.out.println("Please enter your gender: ");
		String gender = input.nextLine();
		System.out.println("Please enter your school: ");
		String school = input.nextLine();
		
		data.createUser(name, pswd, gender, school);
		
	}
	
	private void validatePassword(String name, String pswd) throws ValidationException{
		if(name.equals(pswd)) {
			throw new ValidationException("The password must not be the same as the username");
		}
	}

	private static void validateUserName(String name) throws ValidationException {
		int len = name.length();
		if(len<3 || len>10) {
			throw new ValidationException("Inappropriate Length");
		}else if(!Pattern.matches(".*[a-zA-Z]+.*", name)) {
			throw new ValidationException("Username must contain at least one letter");
		}else if(!Pattern.matches(".*[0-9]+.*", name)) {
			throw new ValidationException("Username must contain at least one digit");
		}else if(!Pattern.matches(".*[#?!*]+.*", name)) {
			throw new ValidationException("Username must contain at least one character(#,?,!,*)");
		}
	}
	
}
