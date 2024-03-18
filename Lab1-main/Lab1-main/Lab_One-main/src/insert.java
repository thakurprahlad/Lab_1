import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Establish a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "akash123");
		Statement st = con.createStatement();
		System.out.print("Enter customer ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter customer name: ");
		String name = sc.nextLine();
		System.out.print("Enter account type (savings/current): ");
		String type = sc.nextLine();
		System.out.print("Enter  Balance: ");
		double bal = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter status: ");
		String status = sc.nextLine();

		String query = String.format("INSERT INTO accounts VALUES (%d, '%s', '%s', '%f', '%s')", id, name, type, bal,
				status);

		st.executeUpdate(query);
		System.out.println("Student added successfully.");

		con.close();
	}
}
