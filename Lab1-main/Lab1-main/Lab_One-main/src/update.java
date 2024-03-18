import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class update {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "akash123");

		Statement st = con.createStatement();

		System.out.print("Enter customer ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter new name for customer: ");
		String newName = sc.nextLine();
		System.out.print("Enter new account type: ");
		String newType = sc.nextLine();
		System.out.print("Enter new balance: ");
		double newBal = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter new status: ");
		String newStatus = sc.nextLine();

		String query = String.format(
				"UPDATE accounts SET CustomerName='%s', AccountType='%s', Balance=%f, Status='%s' WHERE AccountNumber=%d",
				newName, newType, newBal, newStatus, id);

		int rowsAffected = st.executeUpdate(query);

		if (rowsAffected > 0) {
			System.out.println("Account updated successfully.");
		} else {
			System.out.println("Customer with ID " + id + " not found for updating.");
		}
		con.close();
	}
}
