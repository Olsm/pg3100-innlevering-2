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
	
	public DBHandlerBokliste (String user, String password) throws SQLException {}
	
	public void close() throws SQLException {}
	
	public int updateTittel (String nyTittel, String tittel) throws SQLException {}
	
	public int UpdateForfatter (String nyForfatter, String forfatter) throws SQLException {}
	
	public int deleteForfatter (String forfatter) throws SQLException {}
	
	public int deleteTittel (String tittel) throws SQLException {}
	
	public int insertRow (String isbn, String forfatter, String tittel) throws SQLException {}
	
	public ArrayList<String> getTable() throws SQLException {}
	
	public String getRow (String forfatter, String tittel) throws SQLException {}
}
