package Model;

import java.sql.ResultSet;

public interface Requirements {
	
	public void connection();
	
	public boolean verification(String email,String password);
	
	public void saveRegistration(String name,String email,String city,String phone);
	
	public ResultSet ListAllRegistration();
	
	public void deleteRegistration(String email);
	
	public void UpdateRegistration(String email,String city);

}
