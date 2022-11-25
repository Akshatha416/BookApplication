import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class consumer_retrive {
	static final String db_url="jdbc:mysql://localhost:3306/assignment2";
	static final String user="root";
	static final String pass="pass@word1";
	static final String query="select * from consumer ";

	public static void main(String[] args) {
		try(Connection conn=DriverManager.getConnection(db_url,user,pass);
				Statement st= conn.createStatement();
				ResultSet rs=st.executeQuery(query);){
			
			while(rs.next()) {
				System.out.println("Details of Consumer:");
				System.out.println("**************************************");
				System.out.println("cosumer Id:"+rs.getInt("consu_id"));
				System.out.println("cosumer First name:"+rs.getString("consufirst_name"));
				System.out.println("cosumer Last name:"+rs.getString("consulast_name"));
				System.out.println("cosumer age:"+rs.getInt("consu_age"));
				System.out.println("cosumer gender :"+rs.getString("consu_gender"));
				System.out.println("cosumer city:"+rs.getString("consu_city"));
				System.out.println("********************************************");
				
			}
			
			
		}
				
catch(SQLException e) {
	e.printStackTrace();
}
	}

}
