package org.hikuro.hikucraft.repository;

import java.util.UUID;
import org.hikuro.hikucraft.entity.Economy;
import org.hikuro.hikucraft.util.Database;

public class DBEconomyRepository implements EconomyRepository {

	@Override
	public Economy getById(UUID player) throws Exception {
		Database db = Database.getInstance();
		String query = "SELECT Balance FROM Economy WHERE UUID = ?";
		return new Economy(player, db.executePreparedQuery(query, player).getDouble("Balance"));
	}

	@Override
	public void save(Economy entity) throws Exception {
		Database db = Database.getInstance();
		String query =
				"INSERT INTO Economy (UUID, Balance) VALUES (?, ?) ON DUPLICATE KEY UPDATE Balance"
						+ " = ?";
		db.executePreparedUpdate(
				query, entity.getPlayer(), entity.getBalance(), entity.getBalance());
	}

	@Override
	public void update(Economy entity) throws Exception {
		Database db = Database.getInstance();
		String query = "UPDATE Economy SET Balance = ? WHERE UUID = ?";
		db.executePreparedUpdate(query, entity.getBalance(), entity.getPlayer());
	}

	@Override
	public void delete(UUID player) throws Exception {
		Database db = Database.getInstance();
		String query = "DELETE FROM Economy WHERE UUID = ?";
		db.executePreparedUpdate(query, player);
	}
}
