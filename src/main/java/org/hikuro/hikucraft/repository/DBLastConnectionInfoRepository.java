package org.hikuro.hikucraft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.UUID;
import org.hikuro.hikucraft.entity.LastConnectionInfo;
import org.hikuro.hikucraft.util.Database;

public class DBLastConnectionInfoRepository implements LastConnectionInfoRepository {
	@Override
	public LastConnectionInfo find(UUID player) throws SQLException {
		Database db = Database.getInstance();
		String query = "SELECT * FROM LastConnectionInfo WHERE UUID = ?";
		ResultSet rs = db.executePreparedQuery(query, player);
		return new LastConnectionInfo(
				UUID.fromString(rs.getString("UUID")),
				rs.getTimestamp("Date").toLocalDateTime(),
				Duration.ofMinutes(rs.getInt("TimeSpent")),
				rs.getString("World"),
				rs.getInt("X"),
				rs.getInt("Y"),
				rs.getInt("Z"));
	}

	@Override
	public void update(UUID player, LastConnectionInfo lastConnectionInfo) throws SQLException {
		Database db = Database.getInstance();
		String query =
				"UPDATE LastConnectionInfo SET Date = ?, TimeSpent = ?, World = ?, X = ?, Y = ?, Z"
						+ " = ? WHERE UUID = ?";
		db.executePreparedUpdate(
				query,
				lastConnectionInfo.getDate(),
				lastConnectionInfo.getTimeSpent().toMinutes(),
				lastConnectionInfo.getWorld(),
				lastConnectionInfo.getX(),
				lastConnectionInfo.getY(),
				lastConnectionInfo.getZ(),
				player.toString());
	}

	@Override
	public void save(UUID player, LastConnectionInfo lastConnectionInfo) throws SQLException {
		Database db = Database.getInstance();
		String query =
				"INSERT INTO LastConnectionInfo (UUID, Date, TimeSpent, World, X, Y, Z) VALUES (?,"
						+ " ?, ?, ?, ?, ?, ?)";
		db.executePreparedUpdate(
				query,
				player.toString(),
				lastConnectionInfo.getDate(),
				lastConnectionInfo.getTimeSpent().toMinutes(),
				lastConnectionInfo.getWorld(),
				lastConnectionInfo.getX(),
				lastConnectionInfo.getY(),
				lastConnectionInfo.getZ());
	}
}
