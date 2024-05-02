package org.hikuro.hikucraft.entity;

import java.util.UUID;

public class Home {
	private final UUID owner;
	private final String name;
	private final String world;
	private final int x;
	private final int y;
	private final int z;

	public Home(UUID owner, String name, String world, int x, int y, int z) {
		this.owner = owner;
		this.name = name;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Getters
	public UUID getOwner() {
		return owner;
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
