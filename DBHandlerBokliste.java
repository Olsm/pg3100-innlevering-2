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
	private PreparedStatement pstmtUpdateTittel;
	private PreparedStatement pstmtUpdateForfatter;
	private PreparedStatement pstmtDeleteForfatter;
	private PreparedStatement pstmtDeleteTittel;
	private PreparedStatement pstmtInsertRow;
	private PreparedStatement pstmtGetTable;
	private PreparedStatement pstmtGetRow;
	
	public DBHandlerBokliste (String user, String password) throws SQLException {
		tableName = "pg3100";
		
		// Connect to database local host and get connection.
		db = new ConnectToDB ("localhost", tableName, user, password);
		con = db.getConnection();
	}
	
	// Close the database connection.
	public void close() throws SQLException {
		db.close();
	}
	
	// Update book title
	public int updateTittel (String nyTittel, String tittel) throws SQLException {
		String sql = "UPDATE `bokliste` SET `tittel` = ? WHERE `tittel` = ?";
		return executeSQLUpdate(pstmtUpdateTittel, sql, nyTittel, tittel, null);
	}
	
	// Update author name
	public int updateForfatter (String nyForfatter, String forfatter) throws SQLException {
		String sql = "UPDATE `bokliste` SET `forfatter` = ? WHERE `forfatter` = ?";
		return executeSQLUpdate(pstmtUpdateForfatter, sql, nyForfatter, forfatter, null);
	}
	
	// Delete rows of this author
	public int deleteForfatter (String forfatter) throws SQLException {
		String sql = "DELETE FROM `bokliste` WHERE `forfatter` = ?";
		return executeSQLUpdate(pstmtDeleteForfatter, sql, forfatter, null, null);
	}
	
	// Delete rows with this book title
	public int deleteTittel (String tittel) throws SQLException {
		String sql = "DELETE FROM `bokliste` WHERE `tittel` = ?";
		return executeSQLUpdate(pstmtDeleteTittel, sql, tittel, null, null);
	}
	
	// Insert a row into table with isbn, author and title
	public int insertRow (String isbn, String forfatter, String tittel) throws SQLException {
		String sql = "INSERT INTO `bokliste`(`isbn`, `forfatter`, `tittel`) VALUES (?, ?, ?)";
		return executeSQLUpdate(pstmtInsertRow, sql, isbn, forfatter, tittel);
	}
	
	// Get all rows in table and return arraylist of strings
	public ArrayList<String> getTable() throws SQLException {
		ArrayList<String> table = new ArrayList<>();
		String sql = "SELECT * FROM `bokliste`";
		ResultSet rs = executeSQLSelect (pstmtGetTable, sql, null, null, null); 
		
		ResultSetMetaData rsmd = rs.getMetaData();
		table.add (rsmd.getColumnName(1) + "|" + rsmd.getColumnName(2) + "|" 
				+ rsmd.getColumnName(3));
		
		while (rs.next()) {
			table.add(rs.getString("isbn") + "|" + rs.getString ("forfatter") 
					+ "|" + rs.getString ("tittel"));
		}
		return table;
	}
	
	// Get row and return a string like "isbn|author|title"
	public String getRow (String forfatter, String tittel) throws SQLException {
		String sql = "SELECT * FROM `bokliste` WHERE `forfatter` = ? AND `tittel` = ?";
		ResultSet rs = executeSQLSelect (pstmtGetRow, sql, forfatter, tittel, null); 
		
		rs.next();
		return rs.getString("isbn") + "|" + 
			rs.getString ("forfatter") + "|" + rs.getString ("tittel");
	}
	
	// Private method to execute SQL update statements
	private int executeSQLUpdate (PreparedStatement pstmt, String sql, 
			String arg1, String arg2, String arg3) throws SQLException {
		pstmt = prepareSQL (pstmt, sql, arg1, arg2, arg3);
		return pstmt.executeUpdate();	// Execute SQL update and return result
	}
	
	// Private method to execute SQL select statements
	private ResultSet executeSQLSelect (PreparedStatement pstmt, String sql, 
			String arg1, String arg2, String arg3) throws SQLException {
		pstmt = prepareSQL (pstmt, sql, arg1, arg2, arg3);
		return pstmt.executeQuery();	// Execute SQL select and return result
	}
	
	// Private method to prepare SQL statements
	private PreparedStatement prepareSQL (PreparedStatement pstmt, String sql, 
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
