package org.hikuro.hikucraft.api;

import org.hikuro.hikucraft.repository.*;
import org.hikuro.hikucraft.service.*;

public class HikuCraftAPI {
	private EconomyService economyService;
	private HomeService homeService;
	private LastConnectionInfoService lastConnectionInfoService;
	private PermissionService permissionService;
	private StatisticsService statisticsService;

	public HikuCraftAPI() {
		this.setServices();
	}

	private void setServices() {
		// Repository
		EconomyRepository economyRepository = new DBEconomyRepository();
		HomeRepository homeRepository = new DBHomeRepository();
		LastConnectionInfoRepository lastConnectionInfoRepository =
				new DBLastConnectionInfoRepository();
		// Service
		this.economyService = new EconomyService(economyRepository);
		this.homeService = new HomeService(homeRepository);
		this.lastConnectionInfoService =
				new LastConnectionInfoService(lastConnectionInfoRepository);
		this.permissionService = new PermissionService();
		this.statisticsService = new StatisticsService();
	}

	public EconomyService getEconomyService() {
		return this.economyService;
	}

	public HomeService getHomeService() {
		return this.homeService;
	}

	public LastConnectionInfoService getLastConnectionInfoService() {
		return this.lastConnectionInfoService;
	}

	public PermissionService getPermissionService() {
		return this.permissionService;
	}

	public StatisticsService getStatisticsService() {
		return this.statisticsService;
	}
}
