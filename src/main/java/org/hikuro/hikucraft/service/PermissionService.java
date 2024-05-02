package org.hikuro.hikucraft.service;

import java.util.Objects;
import java.util.UUID;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.types.PermissionNode;

public class PermissionService {
	private final LuckPerms luckPerms = LuckPermsProvider.get();

	public boolean hasPermission(UUID player, String permission) {
		return Objects.requireNonNull(this.luckPerms.getUserManager().getUser(player))
				.getCachedData()
				.getPermissionData(this.luckPerms.getContextManager().getStaticQueryOptions())
				.checkPermission(permission)
				.asBoolean();
	}

	public void addPermission(UUID player, String permission) {
		PermissionNode builder = PermissionNode.builder(permission).value(true).build();
		this.luckPerms.getUserManager().modifyUser(player, user -> user.data().add(builder));
	}

	public void removePermission(UUID player, String permission) {
		PermissionNode builder = PermissionNode.builder(permission).value(false).build();
		this.luckPerms.getUserManager().modifyUser(player, user -> user.data().add(builder));
	}
}
