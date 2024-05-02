package org.hikuro.hikucraft.repository;

import java.sql.SQLException;
import java.util.UUID;
import org.hikuro.hikucraft.util.Database;

public class DBEconomyRepository implements EconomyRepository {
	@Override
	public double findBalance(UUID player) throws SQLException {
		Database db = Database.getInstance();
		String query = "SELECT Balance FROM Economy WHERE UUID = ?";
		return db.executePreparedQuery(query, player).getDouble("Balance");
	}

	@Override
	public void saveBalance(UUID player, double amount) throws SQLException {
		Database db = Database.getInstance();
		String query =
				"INSERT INTO Economy (UUID, Balance) VALUES (?, ?) ON DUPLICATE KEY UPDATE Balance"
						+ " = ?";
		db.executePreparedUpdate(query, player, amount, amount);
	}

	@Override
	public void resetBalance(UUID player) throws SQLException {
		Database db = Database.getInstance();
		String query = "UPDATE Economy SET Balance = 0 WHERE UUID = ?";
		db.executePreparedUpdate(query, player);
	}
}
