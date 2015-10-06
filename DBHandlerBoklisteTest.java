package innlevering2;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class DBHandlerBoklisteTest {

	DBHandlerBokliste dbHB;

	@Before
	public void setUp() throws Exception {
		try {
			dbHB = new DBHandlerBokliste ("root", "root");
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

	@Test
	public void testClose() {
		try {
			dbHB.close();
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateTittel() {
		try {
			if (dbHB.updateTittel("NEWULYSSES", "ULYSSES") == 0)
				fail ("Ingen rad ble oppdatert 1");
			else
				if (dbHB.updateTittel("ULYSSES", "NEWULYSSES") == 0)
					fail ("Ingen rad ble oppdatert 2");
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateForfatter() {
		try {
			if (dbHB.updateForfatter("JAMES JOYCE NEW", "JAMES JOYCE") == 0)
				fail ("Ingen rad ble oppdatert 1");
			else
				if (dbHB.updateForfatter("JAMES JOYCE", "JAMES JOYCE NEW") == 0)
					fail ("Ingen rad ble oppdatert 2");
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

	@Test
	public void testDeleteInsertForfatter() {
		try {
			if (dbHB.deleteForfatter("JAMES JOYCE") == 0)
				fail ("Ingen rad ble slettet");
			else
				if (dbHB.insertRow ("111-62-74-96761-2", "JAMES JOYCE", "ULYSSES") == 0)
					fail ("Ingen rad ble lagt til");
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

	@Test
	public void testDeleteInsertTittel() {
		try {
			if (dbHB.deleteTittel("ULYSSES") == 0)
				fail ("Ingen rad ble slettet");
			else
				if (dbHB.insertRow ("111-62-74-96761-2", "JAMES JOYCE", "ULYSSES") == 0)
					fail ("Ingen rad ble lagt til");
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

	@Test
	public void testGetTable() {
		try {
			ArrayList<String> table = dbHB.getTable();
			assertEquals("isbn|forfatter|tittel", table.get(0));
			assertEquals("", table.contains(""));
			System.out.println(table.toString());
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

	@Test
	public void testGetRow() {
		try {
			String row = dbHB.getRow("JAMES JOYCE", "ULYSSES");
			assertEquals("111-62-74-96761-2|JAMES JOYCE|ULYSSES", row);
		} catch (SQLException e) {
			fail ("SQLException: " + e.getMessage());
		}
	}

}
