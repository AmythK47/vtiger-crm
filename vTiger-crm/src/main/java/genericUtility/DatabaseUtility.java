package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	// Connect to DataBase
	public Connection connectToDatabase(String url, String userName, String password) throws Exception
	{
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		return DriverManager.getConnection(url, userName, password);
	}
	
	
	public void validateDatabaseEntry(String url, String userName, String password, String tabName, String colName, String data) throws Exception
	{
		Connection conn = connectToDatabase(url,userName,password);
		Statement st = conn.createStatement();
		
		boolean b = st.execute("select * from "+tabName+" where "+colName+"='"+data+"';");
		if(b)
			System.out.println(data +" : validated Successfully both in Backend and FrontEnd");
		else
			System.out.println(data + " : validation failed");
		
		closeConnectionDb(conn);
		
	}
	
	public ResultSet readDataFromDb(String url, String userName, String password, String query) throws Exception
	{
		Connection conn = connectToDatabase(url,userName,password);
		Statement st = conn.createStatement();
		
		closeConnectionDb(conn);
		
		return st.executeQuery(query);
		
	}

	public void closeConnectionDb(Connection conn) throws Exception
	{
		conn.close();
	}
}
