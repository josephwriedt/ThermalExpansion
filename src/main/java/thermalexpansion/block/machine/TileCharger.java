package thermalexpansion.block.machine;

import cofh.api.energy.IEnergyContainerItem;
import cofh.lib.util.helpers.EnergyHelper;
import cofh.lib.util.helpers.ItemHelper;
import cofh.lib.util.helpers.MathHelper;
import cofh.lib.util.helpers.ServerHelper;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import thermalexpansion.ThermalExpansion;
import thermalexpansion.gui.client.machine.GuiCharger;
import thermalexpansion.gui.container.machine.ContainerCharger;

public class TileCharger extends TileMachineBase {

	static final int TYPE = BlockMachine.Types.CHARGER.ordinal();

	public static void initialize() {

		defaultSideConfig[TYPE] = new SideConfig();
		defaultSideConfig[TYPE].numGroup = 3;
		defaultSideConfig[TYPE].slotGroups = new int[][] { {}, { 0 }, { 1 } };
		defaultSideConfig[TYPE].allowInsertion = new boolean[] { false, true, false };
		defaultSideConfig[TYPE].allowExtraction = new boolean[] { false, true, true };
		defaultSideConfig[TYPE].sideTex = new int[] { 0, 1, 4 };
		defaultSideConfig[TYPE].defaultSides = new byte[] { 1, 1, 2, 2, 2, 2 };

		int maxPower = MathHelper.clampI(ThermalExpansion.config.get("block.tweak", "Machine.Charger.BasePower", 10000), 100, 20000);
		ThermalExpansion.config.set("block.tweak", "Machine.Charger.BasePower", maxPower);
		defaultEnergyConfig[TYPE] = new EnergyConfig();
		defaultEnergyConfig[TYPE].setParams(1, maxPower, Math.max(480000, maxPower * 1200));

		GameRegistry.registerTileEntity(TileCharger.class, "thermalexpansion.Charger");
	}

	int outputTracker;

	public TileCharger() {

		super();

		inventory = new ItemStack[1 + 1];
	}

	@Override
	public int getType() {

		return TYPE;
	}

	@Override
	public void updateEntity() {

		if (ServerHelper.isClientWorld(worldObj)) {
			return;
		}
		boolean curActive = isActive;

		if (isActive) {
			int energy = Math.min(energyStorage.getEnergyStored(), calcEnergy());

			if (EnergyHelper.isEnergyContainerItem(inventory[0])) {
				IEnergyContainerItem theItem = (IEnergyContainerItem) inventory[0].getItem();
				energyStorage.extractEnergy(theItem.receiveEnergy(inventory[0], energy, false), false);

				if (theItem.getEnergyStored(inventory[0]) >= theItem.getMaxEnergyStored(inventory[0]) || (energyStorage.getEnergyStored() > 0 && energy <= 0)) {
					processFinish();
					transferProducts();
					if (!redstoneControlOrDisable() || !canStart()) {
						isActive = false;
						wasActive = true;
						tracker.markTime(worldObj);
					}
				}
			} else if (energyStorage.getEnergyStored() <= 0 || inventory[1] == null) {
				isActive = false;
				wasActive = true;
				tracker.markTime(worldObj);
			}
		} else if (redstoneControlOrDisable()) {
			if (timeCheck()) {
				transferProducts();
			}
			if (canStart()) {
				isActive = true;
			}
		}
		updateIfChanged(curActive);
	}

	@Override
	protected int calcEnergy() {

		if (!isActive || inventory[0] == null) {
			return 0;
		}
		int power = 0;

		if (energyStorage.getEnergyStored() > energyConfig.maxPowerLevel) {
			power = energyConfig.maxPower;
		} else if (energyStorage.getEnergyStored() < energyConfig.energyRamp) {
			power = energyConfig.minPower;
		} else {
			power = energyStorage.getEnergyStored() / energyConfig.energyRamp;
		}
		return Math.min(power, ((IEnergyContainerItem) inventory[0].getItem()).receiveEnergy(inventory[0], power, true));
	}

	@Override
	protected boolean canStart() {

		return inventory[1] == null && EnergyHelper.isEnergyContainerItem(inventory[0]) && energyStorage.getEnergyStored() > 0;
	}

	@Override
	public boolean hasChargeSlot() {

		return false;
	}

	@Override
	protected void processFinish() {

		inventory[1] = ItemHelper.cloneStack(inventory[0], 1);
		if (--inventory[0].stackSize < 1) {
			inventory[0] = null;
		}
	}

	@Override
	protected void transferProducts() {

		if (!augmentAutoTransfer) {
			return;
		}
		if (inventory[1] == null) {
			return;
		}
		int side;
		for (int i = outputTracker + 1; i <= outputTracker + 6; i++) {
			side = i % 6;

			if (sideCache[side] == 2) {
				if (transferItem(1, 1, side)) {
					outputTracker = side;
					break;
				}
			}
		}
	}

	@Override
	public boolean isItemValid(ItemStack stack, int slot, int side) {

		return stack == null ? false : stack.getItem() instanceof IEnergyContainerItem;
	}

	/* GUI METHODS */
	@Override
	public Object getGuiClient(InventoryPlayer inventory) {

		return new GuiCharger(inventory, this);
	}

	@Override
	public Object getGuiServer(InventoryPlayer inventory) {

		return new ContainerCharger(inventory, this);
	}

	/* NBT METHODS */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {

		super.readFromNBT(nbt);

		outputTracker = nbt.getInteger("Tracker");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

		super.writeToNBT(nbt);

		nbt.setInteger("Tracker", outputTracker);
	}

	/* IEnergyInfo */
	@Override
	public int getInfoEnergyPerTick() {

		return calcEnergy();
	}

	@Override
	public int getInfoMaxEnergyPerTick() {

		return energyConfig.maxPower;
	}

}