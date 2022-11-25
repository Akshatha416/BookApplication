import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class consumer_update {
	static final String db_url="jdbc:mysql://localhost:3306/assignment2";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="Update consumer set consu_age=40 where consu_id=?";

	public static void main(String[] args) {

		try(Connection conn=DriverManager.getConnection(db_url,user,pass);
				PreparedStatement ps=conn.prepareStatement(query);
				){
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int i=sc.nextInt();
			ps.setInt(1, i);
			ps.executeUpdate();
			System.out.println("Successfully updated");
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
