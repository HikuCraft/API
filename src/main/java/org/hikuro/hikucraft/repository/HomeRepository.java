package org.hikuro.hikucraft.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.hikuro.hikucraft.entity.Home;

public interface HomeRepository {

	Home findByPlayerAndName(UUID player, String name) throws SQLException;

	List<Home> findByPlayer(UUID player) throws SQLException;

	void create(Home home) throws SQLException;

	void update(Home home) throws SQLException;

	void delete(UUID player, String owner) throws SQLException;
}
