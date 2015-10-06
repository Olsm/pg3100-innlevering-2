package innlevering2;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		// Connect to database localhost and get connection.
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
		pstmtUpdateTittel = con.prepareStatement(sql);
		pstmtUpdateTittel.setString(1, nyTittel);
		pstmtUpdateTittel.setString(2, tittel);
		return pstmtUpdateTittel.executeUpdate();
	}
	
	// Update author name
	public int updateForfatter (String nyForfatter, String forfatter) throws SQLException {
		String sql = "UPDATE `bokliste` SET `forfatter` = ? WHERE `forfatter` = ?";
		pstmtUpdateForfatter = con.prepareStatement(sql);
		pstmtUpdateForfatter.setString(1, nyForfatter);
		pstmtUpdateForfatter.setString(2, forfatter);
		return pstmtUpdateForfatter.executeUpdate();
	}
	
	// Delete rows of this author
	public int deleteForfatter (String forfatter) throws SQLException {
		String sql = "DELETE FROM `bokliste` WHERE `forfatter` = ?";
		pstmtDeleteForfatter = con.prepareStatement(sql);
		pstmtDeleteForfatter.setString(1, forfatter);
		return pstmtDeleteForfatter.executeUpdate();
	}
	
	// Delete rows with this book title
	public int deleteTittel (String tittel) throws SQLException {
		String sql = "DELETE FROM `bokliste` WHERE `tittel` = ?";
		pstmtDeleteTittel = con.prepareStatement(sql);
		pstmtDeleteTittel.setString(1, tittel);
		return pstmtDeleteTittel.executeUpdate();
	}
	
	public int insertRow (String isbn, String forfatter, String tittel) throws SQLException {
		String sql = "INSERT INTO `bokliste`(`isbn`, `forfatter`, `tittel`) VALUES (?, ?, ?)";
		pstmtInsertRow = con.prepareStatement(sql);
		pstmtInsertRow.setString(1, isbn);
		pstmtInsertRow.setString(2, forfatter);
		pstmtInsertRow.setString(3, tittel);
		return pstmtInsertRow.executeUpdate();
	}
	
	public ArrayList<String> getTable() throws SQLException {
		return null;
	}
	
	public String getRow (String forfatter, String tittel) throws SQLException {
		return null;
	}
}
