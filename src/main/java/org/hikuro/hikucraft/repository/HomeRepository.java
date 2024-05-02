package org.hikuro.hikucraft.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.hikuro.hikucraft.entity.Home;

public interface HomeRepository {

	Home getByIdAndOwner(UUID id, String owner) throws SQLException;

	List<Home> getByOwner(String owner) throws SQLException;

	void create(Home home) throws SQLException;

	void update(Home home) throws SQLException;

	void delete(UUID id, String owner) throws SQLException;
}
