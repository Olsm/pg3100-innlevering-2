package innlevering2;

import static org.junit.Assert.*;
import java.sql.SQLException;
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetRow() {
		fail("Not yet implemented");
	}

}
