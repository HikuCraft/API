package org.hikuro.hikucraft.repository;

import java.sql.SQLException;
import java.util.UUID;

public interface EconomyRepository {
	double findBalance(UUID player) throws SQLException;

	void saveBalance(UUID player, double amount) throws SQLException;

	void resetBalance(UUID player) throws SQLException;
}
