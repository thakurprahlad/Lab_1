import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class delete {
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Scanner sc = new Scanner(System.in);
		 Class.forName("com.mysql.cj.jdbc.Driver");

         // Establish a connection
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "akash123");

		 System.out.print("Enter Account Number to remove: ");
		    int id = sc.nextInt();

		    String query = String.format("DELETE FROM accounts WHERE AccountNumber=%d", id);

		    Statement statement = con.createStatement();
		    int rowsAffected = statement.executeUpdate(query);

		    if (rowsAffected > 0) {
		        System.out.println("Customer removed successfully.");
		    } else {
		        System.out.println("Customer with ID " + id + " not found.");
		    }
		    con.close()	;
		}
 }

