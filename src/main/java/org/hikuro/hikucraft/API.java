package org.hikuro.hikucraft;

import org.hikuro.hikucraft.api.repository.DBHomeRepository;
import org.hikuro.hikucraft.api.repository.DBLastConnectionInfoRepository;
import org.hikuro.hikucraft.api.repository.HomeRepository;
import org.hikuro.hikucraft.api.repository.LastConnectionInfoRepository;
import org.hikuro.hikucraft.api.service.HomeService;
import org.hikuro.hikucraft.api.service.LastConnectionInfoService;

public class API {

	private static API instance;

	private final HomeService homeService;
	private final LastConnectionInfoService lastConnectionInfoService;

	private API() {
		HomeRepository homeRepository = new DBHomeRepository();
		LastConnectionInfoRepository lastConnectionInfoRepository =
				new DBLastConnectionInfoRepository();
		this.homeService = new HomeService(homeRepository);
		this.lastConnectionInfoService =
				new LastConnectionInfoService(lastConnectionInfoRepository);
	}

	public static API getInstance() {
		if (instance == null) {
			instance = new API();
		}
		return instance;
	}

	public static HomeService getHomeService() {
		return getInstance().homeService;
	}

	public static LastConnectionInfoService getLastConnectionInfoService() {
		return getInstance().lastConnectionInfoService;
	}
}
