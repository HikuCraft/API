package org.hikuro.hikucraft.repository;

import java.sql.SQLException;
import java.util.UUID;
import org.hikuro.hikucraft.entity.LastConnectionInfo;

public interface LastConnectionInfoRepository {
	LastConnectionInfo find(UUID player) throws SQLException;

	void save(UUID player, LastConnectionInfo lastConnectionInfo) throws SQLException;

	void update(UUID player, LastConnectionInfo lastConnectionInfo) throws SQLException;
}
