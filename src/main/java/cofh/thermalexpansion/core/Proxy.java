package cofh.thermalexpansion.core;

import cofh.thermalexpansion.entity.projectile.EntityFlorb;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.world.WorldEvent.Save;

public class Proxy {

	public void registerEntities() {

		EntityFlorb.initialize();
	}

	public void registerRenderInformation() {

	}

	@SubscribeEvent
	public void save(Save evt) {

		if (evt.world.provider.dimensionId == 0) {
			TeleportChannelRegistry.save();
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void registerIcons(TextureStitchEvent.Pre event) {

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void initializeIcons(TextureStitchEvent.Post event) {

	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void initializeSounds(SoundLoadEvent event) {

	}

	public void updateTesseractGui() {

	}

}
