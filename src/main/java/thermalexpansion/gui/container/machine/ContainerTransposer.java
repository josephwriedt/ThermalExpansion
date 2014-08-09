package thermalexpansion.gui.container.machine;

import cofh.lib.gui.slot.ISlotValidator;
import cofh.lib.gui.slot.SlotEnergy;
import cofh.lib.gui.slot.SlotRemoveOnly;
import cofh.lib.gui.slot.SlotValidated;
import cofh.lib.util.helpers.FluidHelper;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import thermalexpansion.block.machine.TileTransposer;
import thermalexpansion.gui.container.ContainerTEBase;
import thermalexpansion.util.crafting.TransposerManager;

public class ContainerTransposer extends ContainerTEBase implements ISlotValidator {

	TileTransposer myTile;

	public ContainerTransposer(InventoryPlayer inventory, TileEntity tile) {

		super(inventory, tile);

		myTile = (TileTransposer) tile;
		addSlotToContainer(new SlotValidated(this, myTile, 0, 80, 19));
		addSlotToContainer(new SlotRemoveOnly(myTile, 1, 80, 49));
		addSlotToContainer(new SlotEnergy(myTile, myTile.getChargeSlot(), 8, 53));
	}

	@Override
	public boolean isItemValid(ItemStack stack) {

		return TransposerManager.isItemValid(stack) || FluidHelper.isFluidContainerItem(stack);
	}

}