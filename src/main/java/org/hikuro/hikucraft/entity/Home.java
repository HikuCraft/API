package org.hikuro.hikucraft.entity;

import java.util.UUID;

public class Home {
	private final UUID player;
	private final String name;
	private final String world;
	private final int x;
	private final int y;
	private final int z;

	public Home(UUID player, String name, String world, int x, int y, int z) {
		this.player = player;
		this.name = name;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Getters
	public UUID getPlayer() {
		return player;
	}

	public String getName() {
		return name;
	}

	public String getWorld() {
		return world;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}
