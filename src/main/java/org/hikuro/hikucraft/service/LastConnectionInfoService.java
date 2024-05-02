package org.hikuro.hikucraft.service;

import java.sql.SQLException;
import java.util.UUID;
import org.hikuro.hikucraft.entity.LastConnectionInfo;
import org.hikuro.hikucraft.repository.LastConnectionInfoRepository;

public class LastConnectionInfoService {

	private final LastConnectionInfoRepository lastConnectionInfoRepository;

	public LastConnectionInfoService(LastConnectionInfoRepository lastConnectionInfoRepository) {
		this.lastConnectionInfoRepository = lastConnectionInfoRepository;
	}

	public LastConnectionInfo getPlayerLastConnectionInfo(UUID player) {
		try {
			return this.lastConnectionInfoRepository.get(player);
		} catch (SQLException e) {
			return null;
		}
	}

	public void updatePlayerLastConnectionInfo(UUID player, LastConnectionInfo lastConnectionInfo) {
		if (this.getPlayerLastConnectionInfo(player) != null) {
			try {
				this.lastConnectionInfoRepository.update(player, lastConnectionInfo);
			} catch (SQLException e) {
				// TODO: Handle exception
				e.printStackTrace();
			}
		} else {
			this.savePlayerLastConnectionInfo(player, lastConnectionInfo);
		}
	}

	public void savePlayerLastConnectionInfo(UUID player, LastConnectionInfo lastConnectionInfo) {
		try {
			this.lastConnectionInfoRepository.save(player, lastConnectionInfo);
		} catch (SQLException e) {
			// TODO: Handle exception
			e.printStackTrace();
		}
	}
}
