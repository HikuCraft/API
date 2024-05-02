package api.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.UUID;
import org.hikuro.hikucraft.repository.DBEconomyRepository;
import org.hikuro.hikucraft.util.Database;
import org.junit.jupiter.api.*;

class DBEconomyRepositoryTest {

//	private DBEconomyRepository repository;
//	private Database db;
//
//	@BeforeEach
//	void setUp() throws ClassNotFoundException, SQLException {
//		Class.forName("org.h2.Driver");
//		Database.setParameters("jdbc:h2:mem:testdb", "sa", "");
//		db = Database.getInstance();
//		db.executePreparedUpdate(
//				"CREATE TABLE IF NOT EXISTS Economy (UUID VARCHAR(36), Balance DOUBLE)");
//		repository = new DBEconomyRepository();
//	}
//
//	@AfterEach
//	void tearDown() {
//		db.disconnect();
//	}
//
//	@Test
//	void testFindBalance() throws SQLException {
//		UUID player = UUID.randomUUID();
//		double expectedBalance = 100.0;
//		db.executePreparedUpdate(
//				"INSERT INTO Economy (UUID, Balance) VALUES (?, ?)", player, expectedBalance);
//		//		ResultSet rs = db.executePreparedQuery("SELECT Balance FROM Economy WHERE UUID = ?",
//		// player);
//		//		ResultSetPrinter.printResultSet(rs);
//		double actualBalance = repository.findBalance(player);
//		assertEquals(expectedBalance, actualBalance);
//	}
	//
	//	@Test
	//	void testSaveBalance() throws SQLException {
	//		UUID player = UUID.randomUUID();
	//		double newBalance = 200.0;
	//		repository.saveBalance(player, newBalance);
	//		double retrievedBalance =
	//				db.executePreparedQuery("SELECT Balance FROM Economy WHERE UUID = ?", player)
	//						.getDouble("Balance");
	//		assertEquals(newBalance, retrievedBalance);
	//	}
	//
	//	@Test
	//	void testResetBalance() throws SQLException {
	//		UUID player = UUID.randomUUID();
	//		double initialBalance = 300.0;
	//		db.executePreparedUpdate(
	//				"INSERT INTO Economy (UUID, Balance) VALUES (?, ?)", player, initialBalance);
	//		repository.resetBalance(player);
	//		double retrievedBalance =
	//				db.executePreparedQuery("SELECT Balance FROM Economy WHERE UUID = ?", player)
	//						.getDouble("Balance");
	//		assertEquals(0.0, retrievedBalance);
	//	}
}
