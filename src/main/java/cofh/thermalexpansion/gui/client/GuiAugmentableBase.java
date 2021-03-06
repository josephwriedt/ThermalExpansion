package cofh.thermalexpansion.gui.client;

import cofh.core.gui.GuiBaseAdv;
import cofh.core.gui.element.TabAugment;
import cofh.core.gui.element.TabConfiguration;
import cofh.core.gui.element.TabEnergy;
import cofh.core.gui.element.TabInfo;
import cofh.core.gui.element.TabRedstone;
import cofh.core.gui.element.TabSecurity;
import cofh.core.gui.element.TabTutorial;
import cofh.lib.gui.container.IAugmentableContainer;
import cofh.lib.gui.element.TabBase;
import cofh.lib.util.helpers.SecurityHelper;
import cofh.lib.util.helpers.StringHelper;
import cofh.thermalexpansion.block.TileAugmentable;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class GuiAugmentableBase extends GuiBaseAdv {

	protected TileAugmentable myTile;
	protected UUID playerName;

	public String myTutorial = StringHelper.tutorialTabAugment();

	protected TabBase redstoneTab;
	protected TabBase configTab;

	public GuiAugmentableBase(Container container, TileEntity tile, EntityPlayer player, ResourceLocation texture) {

		super(container, texture);

		myTile = (TileAugmentable) tile;
		name = myTile.getInventoryName();
		playerName = SecurityHelper.getID(player);

		if (myTile.enableSecurity() && myTile.isSecured()) {
			myTutorial += "\n\n" + StringHelper.tutorialTabSecurity();
		}
		if (myTile.augmentRedstoneControl) {
			myTutorial += "\n\n" + StringHelper.tutorialTabRedstone();
		}
		if (myTile.augmentReconfigSides) {
			myTutorial += "\n\n" + StringHelper.tutorialTabConfiguration();
		}
		if (myTile.getMaxEnergyStored(ForgeDirection.UNKNOWN) > 0) {
			myTutorial += "\n\n" + StringHelper.tutorialTabFluxRequired();
		}
	}

	@Override
	public void initGui() {

		super.initGui();

		addTab(new TabAugment(this, (IAugmentableContainer) inventorySlots));
		if (myTile.enableSecurity() && myTile.isSecured()) {
			addTab(new TabSecurity(this, myTile, playerName));
		}
		redstoneTab = addTab(new TabRedstone(this, myTile));
		configTab = addTab(new TabConfiguration(this, myTile));

		if (myTile.getMaxEnergyStored(ForgeDirection.UNKNOWN) > 0) {
			addTab(new TabEnergy(this, myTile, false));
		}
		if (!myInfo.isEmpty()) {
			addTab(new TabInfo(this, myInfo));
		}
		addTab(new TabTutorial(this, myTutorial));
	}

	@Override
	public void updateScreen() {

		super.updateScreen();

		if (!myTile.canAccess()) {
			this.mc.thePlayer.closeScreen();
		}
	}

	@Override
	protected void updateElementInformation() {

		super.updateElementInformation();

		redstoneTab.setVisible(myTile.augmentRedstoneControl);
		configTab.setVisible(myTile.augmentReconfigSides);
	}

}
