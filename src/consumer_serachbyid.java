import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class consumer_serachbyid {
	
	static final String db_url="jdbc:mysql://localhost:3306/assignment2";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="select * from consumer where consu_id=?";
	

	public static void main(String[] args) {
		try(Connection conn=DriverManager.getConnection(db_url,user,pass);
				PreparedStatement ps= conn.prepareStatement(query);)
		{Scanner sc= new Scanner(System.in);
		System.out.println("Eneter the id to search consumer:");
			int i=sc.nextInt();
			ps.setInt(1,i);
			ResultSet rs=ps.executeQuery();
			System.out.println("Consumer details :");
			while(rs.next()) {
				
				System.out.println("Consumer id:"+rs.getInt("consu_id"));
				System.out.println("Consumer id:"+rs.getString("consufirst_name"));
				System.out.println("Consumer id:"+rs.getString("consulast_name"));
				System.out.println("Consumer id:"+rs.getInt("consu_age"));
				System.out.println("Consumer id:"+rs.getString("consu_gender"));
				System.out.println("Consumer id:"+rs.getString("consu_city"));
			}
			
		}
		
		
		
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
