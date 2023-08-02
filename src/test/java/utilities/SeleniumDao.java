package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeleniumDao {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/vinaydb";
		String user = "priya";
		String pass = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement stat = con.createStatement();
			//PreparedStatement ps = new pre
			ResultSet rs = stat.executeQuery("Select * from emplyeee");
			rs.next();
			System.out.println(rs.getInt(1));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
