package innlevering2;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectToDB {
	private Connection con;
	
	public ConnectToDB (String serverName, String databaseName, String user, String password) throws SQLException {}
	
	public void close() throws SQLException {}
	
	public Connection getConnection() {}
}