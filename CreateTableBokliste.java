package innlevering2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableBokliste {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pg3100", "root", "root");
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("CREATE TABLE `bokliste` (`isbn` CHAR(20) PRIMARY KEY, `forfatter` CHAR(20), `tittel` CHAR(80))");
			stmt.executeUpdate("INSERT INTO `bokliste` VALUES ('111-62-74-96761-2', 'JAMES JOYCE', 'ULYSSES'),"
					+ "('142-17-64-87689-9', 'BERTHA M. CLARK', 'GENERAL SCIENCE'),"
					+ "('367-52-28-62634-6', 'EDGAR ALLAN POE', 'BEST OF'),"
					+ "('468-49-82-16489-8', 'HENRY ERNEST DUDENEY', 'AMUSEMENTS IN MATHEMATICS'),"
					+ "('564-52-28-12334-6', 'ERLEND LOE', 'DOPPLER'),"
					+ "('613-98-83-55929-1', 'JANE AUSTEN', 'PRIDE AND PREJUDICE'),"
					+ "('723-91-79-15133-7', 'EDWARD R. SHAW', 'DISCOVERERS AND EXPLORERS')");
			stmt.close();
			System.out.println("Table creation completed!");
			
		} catch (SQLException sqlex) {
			System.out.println(sqlex.getMessage());		
		}
	}
	
	
}
