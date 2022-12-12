package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Requirements_Impl implements Requirements {
                
	private Connection con;
	private Statement stmt;
	
	@Override
	public void connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_login","root","Mech@nical01");
			 stmt = con.createStatement();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean verification(String email,String password) {
		try {
			ResultSet result = stmt.executeQuery("select * from login where email='"+email+"' and password='"+password+"' ");
			return result.next();
			
		} catch (Exception e) {
			// TODO: handle exception
		}return false;
		
	}

	@Override
	public void saveRegistration(String name, String email, String city, String phone) {
		try {
			stmt.executeUpdate("insert into registration values ('"+name+"','"+email+"','"+city+"','"+phone+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet ListAllRegistration() {
		try {
			ResultSet result = stmt.executeQuery("select * from registration");
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			stmt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateRegistration(String email, String city) {
		try {
			stmt.executeUpdate("update registration set city='"+city+"' where email='"+email+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
