package org.hikuro.hikucraft.api;

import org.hikuro.hikucraft.repository.DBHomeRepository;
import org.hikuro.hikucraft.repository.DBLastConnectionInfoRepository;
import org.hikuro.hikucraft.repository.HomeRepository;
import org.hikuro.hikucraft.repository.LastConnectionInfoRepository;
import org.hikuro.hikucraft.service.HomeService;
import org.hikuro.hikucraft.service.LastConnectionInfoService;

public class HikuCraftAPI {

	private HomeService homeService;
	private LastConnectionInfoService lastConnectionInfoService;

	public HikuCraftAPI() {
		this.setServices();
	}

	private void setServices() {
		// Repository
		HomeRepository homeRepository = new DBHomeRepository();
		LastConnectionInfoRepository lastConnectionInfoRepository =
				new DBLastConnectionInfoRepository();
		// Service
		this.homeService = new HomeService(homeRepository);
		this.lastConnectionInfoService =
				new LastConnectionInfoService(lastConnectionInfoRepository);
	}

	public HomeService getHomeService() {
		return this.homeService;
	}

	public LastConnectionInfoService getLastConnectionInfoService() {
		return this.lastConnectionInfoService;
	}
}
