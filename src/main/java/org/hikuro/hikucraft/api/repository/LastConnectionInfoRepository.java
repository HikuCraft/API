package org.hikuro.hikucraft.api.repository;

import java.sql.SQLException;
import java.util.UUID;
import org.hikuro.hikucraft.api.entity.LastConnectionInfo;

public interface LastConnectionInfoRepository {
	LastConnectionInfo get(UUID player) throws SQLException;

	void update(UUID player, LastConnectionInfo lastConnectionInfo) throws SQLException;

	void save(UUID player, LastConnectionInfo lastConnectionInfo) throws SQLException;
}
