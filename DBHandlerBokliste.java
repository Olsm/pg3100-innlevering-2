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
	
	public int updateTittel (String nyTittel, String tittel) throws SQLException {
		return 0;
		}
	
	public int UpdateForfatter (String nyForfatter, String forfatter) throws SQLException {
		return 0;
		}
	
	public int deleteForfatter (String forfatter) throws SQLException {
		return 0;
		}
	
	public int deleteTittel (String tittel) throws SQLException {
		return 0;
		}
	
	public int insertRow (String isbn, String forfatter, String tittel) throws SQLException {
		return 0;
		}
	
	public ArrayList<String> getTable() throws SQLException {
		return null;
		}
	
	public String getRow (String forfatter, String tittel) throws SQLException {
		return tittel;
		}
}
