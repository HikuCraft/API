package org.hikuro.hikucraft.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hikuro.hikucraft.entity.Home;
import org.hikuro.hikucraft.repository.HomeID;
import org.hikuro.hikucraft.repository.HomeRepository;

public class HomeService {
	private final HomeRepository homeRepository;

	public HomeService(HomeRepository homeRepository) {
		this.homeRepository = homeRepository;
	}

	public Home getHomeByPlayerAndName(UUID player, String name) {
		try {
			return this.homeRepository.getById(new HomeID(player, name));
		} catch (Exception e) {
			return null;
		}
	}

	public List<Home> getHomesByPlayer(UUID player) {
		try {
			return this.homeRepository.getByPlayer(player);
		} catch (SQLException e) {
			return new ArrayList<>();
		}
	}

	public void createHome(Home home) {
		try {
			this.homeRepository.save(home);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateHome(Home home) {
		try {
			this.homeRepository.update(home);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void deleteHome(UUID player, String name) {
		try {
			this.homeRepository.delete(new HomeID(player, name));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
