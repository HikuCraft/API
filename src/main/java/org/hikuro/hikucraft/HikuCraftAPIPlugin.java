package org.hikuro.hikucraft;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.hikuro.hikucraft.provider.HikuCraftProvider;
import org.hikuro.hikucraft.util.Database;

public class HikuCraftAPIPlugin extends JavaPlugin {

	private static HikuCraftAPIPlugin instance;

	@Override
	public void onEnable() {
		instance = this;
		HikuCraftProvider.get();

		getServer()
				.getPluginManager()
				.registerEvents(
						new Listener() {
							@EventHandler
							public void onPlayerJoin(PlayerJoinEvent event) {
								try {
									Database db = Database.getInstance();
									// Insert the player into the Player table if not exists
									String query = "INSERT IGNORE INTO Player (UUID) VALUES (?)";
									db.executePreparedUpdate(
											query, event.getPlayer().getUniqueId());
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						},
						this);

		getLogger().info("HikuCraft API Plugin enabled");
	}

	@Override
	public void onDisable() {
		HikuCraftProvider.get();
		getLogger().info("HikuCraft API Plugin disabled");
	}

	public static HikuCraftAPIPlugin get() {
		return instance;
	}
}
