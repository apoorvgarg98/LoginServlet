package businessServices;
import java.sql.*;

public class Account {
	
	public static void CreateAccount(String uid,String uname,String pass)throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","apoorv","june1998");
		Statement st=con.createStatement();
		st.executeUpdate("Insert into users values('" + uid +"','" + uname + "','" + pass + "');");
		st.close();
		con.close();
	}
}
