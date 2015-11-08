import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
 
public class Main
{
 
  public static void main(String[] argv) throws SQLException {
 
	Connection connection = null;
	Statement statement = null;
	try {
		//Change connection according to root info
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/flight_reservation","root", "Spongebob12#");
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}	
	/*
	 * 
	 * 
	 * This is where we start to code!
	 * 
	 * 
	 * 
	 */
	
	//1st user request 
	//very rough draft... 
	//There will be a new tuple in booking with flight = 4
	//run a query on mysql to verify
	System.out.println("User Request: Create/Reserve flight for Passenger");
	CallableStatement cs = connection.prepareCall("{CALL bookFlight(?, ?, ? , ?)}");
	cs.setInt(1, 4); //flightID =4
	cs.setInt(2, 1);//first person on seatnum 1
	cs.setString(3, "Economy");//class is economy
	cs.setInt(4, 1);
	ResultSet rs = cs.executeQuery();
	System.out.println("User Created! Check DB to verify");
			
	
  }
  
  
}