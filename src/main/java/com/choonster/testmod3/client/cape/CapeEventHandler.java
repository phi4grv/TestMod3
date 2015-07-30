package com.choonster.testmod3.client.cape;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapeEventHandler {
	@SubscribeEvent
	public void entityJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof AbstractClientPlayer && CapeUtils.doesPlayerHaveCape((AbstractClientPlayer) event.entity)) {
			// EntityJoinWorldEvent fires before the player's NetworkPlayerInfo is populated,
			// so we delay replacing the cape by at least 100 milliseconds.
			CapeUtils.queuePlayerCapeReplacement((AbstractClientPlayer) event.entity);
		}
	}
}