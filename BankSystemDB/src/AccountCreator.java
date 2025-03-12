import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import java.text.DecimalFormat;

public class AccountCreator {
	
	 
	public static void createAccount(String type)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your ssn: ");
		String ssn = input.nextLine();
		System.out.println("Please enter your initial deposit: ");
		double balance = input.nextDouble();
		
		 
		final String url = "jdbc:mysql://cobmysql.uhcl.edu/jaina8817?useSSL=false";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//connect to the db
			conn = DriverManager.getConnection(url,"jaina8817", "2298817");
			//create an obj for sql statement
			st = conn.createStatement();
			// create a bank statement string
			DecimalFormat df = new DecimalFormat("##.00");
			String s = DateAndTime.DateTime() 
					+ ": Account open with an initial balance $" 
					+ df.format(balance) + "\n";
			// to get the account number
			rs = st.executeQuery("select * from nextAccountNum");
			int nextNum = 0; // this is a variable used to updated nextID
			String accountNum = "";
			while(rs.next()) {
				accountNum = "" + rs.getInt(1); // get the value of the first column of the result
				nextNum = rs.getInt(1) + 1;
			}
			//rolled back to here anything wrong
			conn.setAutoCommit(false);
			//update the new AccountNum
			int numWithdraw = 0;
			int t = st.executeUpdate("update nextAccountNum set nextID = '" + nextNum + "'");
			//insert a record into account table
			int r = st.executeUpdate("insert into BankAccount values ('" 
					+ accountNum + "', '" 
					+ ssn + "', '" 
					+ balance +"', '" 
					+ s + "', '" 
					+ type + "', '" 
					+ numWithdraw + "')");
			
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("Your Account is created.");
			
		}catch(SQLException e) {
			System.out.println("Account Creation failed.");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				st.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	 
}
