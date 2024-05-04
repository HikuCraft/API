package org.hikuro.hikucraft;

import org.bukkit.plugin.java.JavaPlugin;
import org.hikuro.hikucraft.provider.HikuCraftProvider;

public class HikuCraftAPIPlugin extends JavaPlugin {

	private static HikuCraftAPIPlugin instance;

	@Override
	public void onEnable() {
		instance = this;
		HikuCraftProvider.get().onEnable();
		getLogger().info("HikuCraft API Plugin enabled");
	}

	@Override
	public void onDisable() {
		HikuCraftProvider.get().onDisable();
		getLogger().info("HikuCraft API Plugin disabled");
	}

	public static HikuCraftAPIPlugin get() {
		return instance;
	}
}
