package org.hikuro.hikucraft.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.hikuro.hikucraft.entity.Home;

public interface HomeRepository extends Repository<Home, HomeID> {

	List<Home> getByPlayer(UUID player) throws SQLException;
}
