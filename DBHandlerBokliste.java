package innlevering2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import db.ConnectToDB;

public class DBHandlerBokliste {
	private ConnectToDB db;
	private Connection con;
	private String tableName;
	private PreparedStatement pstmt;
	
	public DBHandlerBokliste (String user, String password) throws SQLException {
		tableName = "pg3100";
		
		// Connect to database local host and get connection.
		db = new ConnectToDB ("localhost", tableName, user, password);
		con = db.getConnection();
	}
	
	// Close PreparedStatement and the database connection.
	public void close() throws SQLException {
		if (pstmt != null)
			pstmt.close();
		db.close();
	}
	
	// Update book title
	public int updateTittel (String nyTittel, String tittel) throws SQLException {
		String sql = "UPDATE `bokliste` SET `tittel` = ? WHERE `tittel` = ?";
		return executeSQLUpdate(sql, nyTittel, tittel, null);
	}
	
	// Update author name
	public int updateForfatter (String nyForfatter, String forfatter) throws SQLException {
		String sql = "UPDATE `bokliste` SET `forfatter` = ? WHERE `forfatter` = ?";
		return executeSQLUpdate(sql, nyForfatter, forfatter, null);
	}
	
	// Delete rows of this author
	public int deleteForfatter (String forfatter) throws SQLException {
		String sql = "DELETE FROM `bokliste` WHERE `forfatter` = ?";
		return executeSQLUpdate(sql, forfatter, null, null);
	}
	
	// Delete rows with this book title
	public int deleteTittel (String tittel) throws SQLException {
		String sql = "DELETE FROM `bokliste` WHERE `tittel` = ?";
		return executeSQLUpdate(sql, tittel, null, null);
	}
	
	// Insert a row into table with isbn, author and title
	public int insertRow (String isbn, String forfatter, String tittel) throws SQLException {
		String sql = "INSERT INTO `bokliste`(`isbn`, `forfatter`, `tittel`) VALUES (?, ?, ?)";
		return executeSQLUpdate(sql, isbn, forfatter, tittel);
	}
	
	// Get all rows in table and return arraylist of strings
	public ArrayList<String> getTable() throws SQLException {
		ArrayList<String> table = new ArrayList<>();
		String sql = "SELECT * FROM `bokliste`";
		ResultSet rs = executeSQLSelect (sql, null, null, null); 
		
		ResultSetMetaData rsmd = rs.getMetaData();
		table.add (rsmd.getColumnName(1) + "|" + rsmd.getColumnName(2) + "|" 
				+ rsmd.getColumnName(3));
		
		while (rs.next()) {
			table.add(rs.getString("isbn") + "|" + rs.getString ("forfatter") 
					+ "|" + rs.getString ("tittel"));
		}
		rs.close();
		return table;
	}
	
	// Get row and return a string like "isbn|author|title"
	public String getRow (String forfatter, String tittel) throws SQLException {
		String sql = "SELECT * FROM `bokliste` WHERE `forfatter` = ? AND `tittel` = ?";
		ResultSet rs = executeSQLSelect (sql, forfatter, tittel, null); 
		
		rs.next();
		String row = rs.getString("isbn") + "|" + 
				rs.getString ("forfatter") + "|" + rs.getString ("tittel");
		rs.close();
		return row;
	}
	
	// Private method to execute SQL update statements
	private int executeSQLUpdate (String sql, 
			String arg1, String arg2, String arg3) throws SQLException {
		pstmt = prepareSQL (sql, arg1, arg2, arg3);
		return pstmt.executeUpdate();	// Execute SQL update and return result
	}
	
	// Private method to execute SQL select statements
	private ResultSet executeSQLSelect (String sql, 
			String arg1, String arg2, String arg3) throws SQLException {
		pstmt = prepareSQL (sql, arg1, arg2, arg3);
		return pstmt.executeQuery();	// Execute SQL select and return result
	}
	
	// Private method to prepare SQL statements
	private PreparedStatement prepareSQL (String sql, 
			String arg1, String arg2, String arg3) throws SQLException {
		pstmt = con.prepareStatement(sql);	// prepare the sql statement
		
		// Set string for arguments only if they are not null
		if (arg1 != null) 
			pstmt.setString(1, arg1);
		if (arg2 != null)
			pstmt.setString(2, arg2);
		if (arg3 != null)
			pstmt.setString(3, arg3);
		
		return pstmt;	// Return the prepared SQL PreparedStatement
	}
}
