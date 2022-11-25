import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
//import java.sql.Statement;
//import java.util.Scanner;

public class consumer_delete {
	
	static final String db_url="jdbc:mysql://localhost:3306/assignment2";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="Delete from consumer where consufirst_name=?";

	public static void main(String[] args) {
		try(Connection conn=DriverManager.getConnection(db_url,user,pass);
				PreparedStatement ps=conn.prepareStatement(query);)
				{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the id to delete customer:");
			String i=sc.next();
			ps.setString(1, i);
			
			ps.executeUpdate();
			System.out.println("deleted:");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
