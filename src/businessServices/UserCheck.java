package businessServices;

import java.sql.*;

import dataTransferObject.User;

public class UserCheck {
	public static User check(String uId,String pass) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","apoorv","june1998");
		Statement st=con.createStatement();
	    ResultSet rs=st.executeQuery("Select * from users where userId='"+uId + "';");
        if(rs.next())
        {
 			if(rs.getString(3).equals(pass))
			{
				User u=new User(uId,rs.getString(2));
				return u;
			}
        }	
		con.close();
		return null;
	    
	}
	
	public static boolean check(String uId) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","apoorv","june1998");
		Statement st=con.createStatement();
	    ResultSet rs=st.executeQuery("Select * from users where userId='"+uId + "';");
        if(rs.next())
        {
 			return true;
        }	
		con.close();
		return false;
	    
	}
}
