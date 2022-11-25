import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class consumer_Insert {
	static final String db_url="jdbc:mysql://localhost:3306/assignment2";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="insert into consumer(consu_id,consufirst_name,consulast_name,consu_age,consu_gender,consu_city) values (?,?,?,?,?,?)";

	public static void main(String[] args) {
		try(Connection conn=DriverManager.getConnection(db_url,user,pass);
				PreparedStatement ps= conn.prepareStatement(query);)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("enter consumer id");
			int id=sc.nextInt();
			System.out.println("enter consumer first name:");
			String fname=sc.next();
			System.out.println("enter consumer last name:");
			String lname=sc.next();
			System.out.println("enter consumer age:");
			int age=sc.nextInt();
			System.out.println("enter consumer gender");
			String gender=sc.next();
			System.out.println("enter consumer city");
			String city=sc.next();
			
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setInt(4, age);
			ps.setString(5, gender);
			ps.setString(6, city);
			ps.executeUpdate();
			System.out.println("Inserted Consumer successfully:");
		}
				
		catch(SQLException e) {
			e.printStackTrace();
			
		}

	}

}
