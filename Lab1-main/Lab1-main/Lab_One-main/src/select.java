import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "akash123");

            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("Select * from accounts");
            
            while(rs.next()) {
            	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+ rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getString(5));
            }
             con.close();
    }
}
