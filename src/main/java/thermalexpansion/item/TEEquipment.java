package thermalexpansion.item;

import cofh.core.item.ItemArmorAdv;
import cofh.core.item.tool.ItemAxeAdv;
import cofh.core.item.tool.ItemBowAdv;
import cofh.core.item.tool.ItemFishingRodAdv;
import cofh.core.item.tool.ItemHoeAdv;
import cofh.core.item.tool.ItemPickaxeAdv;
import cofh.core.item.tool.ItemShearsAdv;
import cofh.core.item.tool.ItemShovelAdv;
import cofh.core.item.tool.ItemSickleAdv;
import cofh.core.item.tool.ItemSwordAdv;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;

import thermalexpansion.ThermalExpansion;
import thermalexpansion.core.TEProps;
import thermalexpansion.item.tool.ItemWrenchBattle;

public class TEEquipment {

	private TEEquipment() {

	}

	public static void preInit() {

		itemHelmetInvar = (ItemArmorAdv) new ItemArmorAdv(ARMOR_INVAR, 0).setRepairIngot("ingotInvar").setArmorTextures(TEXTURE_INVAR)
				.setUnlocalizedName(ARMOR + "invarHelmet").setTextureName("thermalexpansion:armor/ArmorInvarHelmet").setCreativeTab(ThermalExpansion.tabItems);
		itemPlateInvar = (ItemArmorAdv) new ItemArmorAdv(ARMOR_INVAR, 1).setRepairIngot("ingotInvar").setArmorTextures(TEXTURE_INVAR)
				.setUnlocalizedName(ARMOR + "invarPlate").setTextureName("thermalexpansion:armor/ArmorInvarChestplate")
				.setCreativeTab(ThermalExpansion.tabItems);
		itemLegsInvar = (ItemArmorAdv) new ItemArmorAdv(ARMOR_INVAR, 2).setRepairIngot("ingotInvar").setArmorTextures(TEXTURE_INVAR)
				.setUnlocalizedName(ARMOR + "invarLegs").setTextureName("thermalexpansion:armor/ArmorInvarLegs").setCreativeTab(ThermalExpansion.tabItems);
		itemBootsInvar = (ItemArmorAdv) new ItemArmorAdv(ARMOR_INVAR, 3).setRepairIngot("ingotInvar").setArmorTextures(TEXTURE_INVAR)
				.setUnlocalizedName(ARMOR + "invarBoots").setTextureName("thermalexpansion:armor/ArmorInvarBoots").setCreativeTab(ThermalExpansion.tabItems);

		itemBattleWrenchInvar = new ItemWrenchBattle(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarBattleWrench")
				.setTextureName("thermalexpansion:tool/InvarBattleWrench").setCreativeTab(ThermalExpansion.tabTools);
		itemSwordInvar = new ItemSwordAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarSword")
				.setTextureName("thermalexpansion:tool/InvarSword").setCreativeTab(ThermalExpansion.tabTools);
		itemShovelInvar = new ItemShovelAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarShovel")
				.setTextureName("thermalexpansion:tool/InvarShovel").setCreativeTab(ThermalExpansion.tabTools);
		itemPickaxeInvar = new ItemPickaxeAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarPickaxe")
				.setTextureName("thermalexpansion:tool/InvarPickaxe").setCreativeTab(ThermalExpansion.tabTools);
		itemAxeInvar = new ItemAxeAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarAxe")
				.setTextureName("thermalexpansion:tool/InvarAxe").setCreativeTab(ThermalExpansion.tabTools);
		itemHoeInvar = new ItemHoeAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarHoe")
				.setTextureName("thermalexpansion:tool/InvarHoe").setCreativeTab(ThermalExpansion.tabTools);
		itemShearsInvar = new ItemShearsAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarShears")
				.setTextureName("thermalexpansion:tool/InvarShears").setCreativeTab(ThermalExpansion.tabTools);
		itemFishingRodInvar = new ItemFishingRodAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarFishingRod")
				.setTextureName("thermalexpansion:tool/InvarFishingRod").setCreativeTab(ThermalExpansion.tabTools);
		itemSickleInvar = new ItemSickleAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setUnlocalizedName(TOOL + "invarSickle")
				.setTextureName("thermalexpansion:tool/InvarSickle").setCreativeTab(ThermalExpansion.tabTools);
		itemBowInvar = new ItemBowAdv(TOOL_INVAR).setRepairIngot("ingotInvar").setArrowSpeed(2.5F).setArrowDamage(1.25F).setUnlocalizedName(TOOL + "invarBow")
				.setTextureName("thermalexpansion:tool/InvarBow").setCreativeTab(ThermalExpansion.tabTools);

		GameRegistry.registerItem(itemHelmetInvar, "armor.helmetInvar");
		GameRegistry.registerItem(itemPlateInvar, "armor.plateInvar");
		GameRegistry.registerItem(itemLegsInvar, "armor.legsInvar");
		GameRegistry.registerItem(itemBootsInvar, "armor.bootsInvar");

		GameRegistry.registerItem(itemBattleWrenchInvar, "tool.battleWrenchInvar");
		GameRegistry.registerItem(itemSwordInvar, "tool.swordInvar");
		GameRegistry.registerItem(itemShovelInvar, "tool.shovelInvar");
		GameRegistry.registerItem(itemPickaxeInvar, "tool.pickaxeInvar");
		GameRegistry.registerItem(itemAxeInvar, "tool.axeInvar");
		GameRegistry.registerItem(itemHoeInvar, "tool.hoeInvar");
		GameRegistry.registerItem(itemShearsInvar, "tool.shearsInvar");
		GameRegistry.registerItem(itemFishingRodInvar, "tool.fishingRodInvar");
		GameRegistry.registerItem(itemSickleInvar, "tool.sickleInvar");
		GameRegistry.registerItem(itemBowInvar, "tool.bowInvar");

	}

	public static void initialize() {

		/* Armor */
		armorInvarHelmet = new ItemStack(itemHelmetInvar);
		armorInvarPlate = new ItemStack(itemPlateInvar);
		armorInvarLegs = new ItemStack(itemLegsInvar);
		armorInvarBoots = new ItemStack(itemBootsInvar);

		GameRegistry.registerCustomItemStack("armorInvarHelmet", armorInvarHelmet);
		GameRegistry.registerCustomItemStack("armorInvarPlate", armorInvarPlate);
		GameRegistry.registerCustomItemStack("armorInvarLegs", armorInvarLegs);
		GameRegistry.registerCustomItemStack("armorInvarBoots", armorInvarBoots);

		/* Tools */
		toolInvarBattleWrench = new ItemStack(itemBattleWrenchInvar);
		toolInvarSword = new ItemStack(itemSwordInvar);
		toolInvarShovel = new ItemStack(itemShovelInvar);
		toolInvarPickaxe = new ItemStack(itemPickaxeInvar);
		toolInvarAxe = new ItemStack(itemAxeInvar);
		toolInvarHoe = new ItemStack(itemHoeInvar);
		toolInvarShears = new ItemStack(itemShearsInvar);
		toolInvarFishingRod = new ItemStack(itemFishingRodInvar);
		toolInvarSickle = new ItemStack(itemSickleInvar);
		toolInvarBow = new ItemStack(itemBowInvar);

		GameRegistry.registerCustomItemStack("toolInvarBattleWrench", toolInvarBattleWrench);
		GameRegistry.registerCustomItemStack("toolInvarSword", toolInvarSword);
		GameRegistry.registerCustomItemStack("toolInvarShovel", toolInvarShovel);
		GameRegistry.registerCustomItemStack("toolInvarPickaxe", toolInvarPickaxe);
		GameRegistry.registerCustomItemStack("toolInvarAxe", toolInvarAxe);
		GameRegistry.registerCustomItemStack("toolInvarHoe", toolInvarHoe);
		GameRegistry.registerCustomItemStack("toolInvarShears", toolInvarShears);
		GameRegistry.registerCustomItemStack("toolInvarFishingRod", toolInvarFishingRod);
		GameRegistry.registerCustomItemStack("toolInvarSickle", toolInvarSickle);
		GameRegistry.registerCustomItemStack("toolInvarBow", toolInvarBow);
	}

	public static void postInit() {

		/* Armor */
		if (enableArmor) {
			GameRegistry.addRecipe(new ShapedOreRecipe(armorInvarHelmet, new Object[] { "III", "I I", 'I', "ingotInvar" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(armorInvarPlate, new Object[] { "I I", "III", "III", 'I', "ingotInvar" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(armorInvarLegs, new Object[] { "III", "I I", "I I", 'I', "ingotInvar" }));
			GameRegistry.addRecipe(new ShapedOreRecipe(armorInvarBoots, new Object[] { "I I", "I I", 'I', "ingotInvar" }));
		}

		/* Tools */
		if (enableTools[0]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarBattleWrench, new Object[] { "I I", " G ", " W ", 'I', "ingotInvar", 'G', "gearInvar", 'W',
					TEItems.toolWrench }));
		}
		if (enableTools[1]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarSword, new Object[] { " I ", " I ", " W ", 'I', "ingotInvar", 'W', "stickWood" }));
		}
		if (enableTools[2]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarShovel, new Object[] { " I ", " W ", " W ", 'I', "ingotInvar", 'W', "stickWood" }));
		}
		if (enableTools[3]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarPickaxe, new Object[] { "III", " W ", " W ", 'I', "ingotInvar", 'W', "stickWood" }));
		}
		if (enableTools[4]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarAxe, new Object[] { "II ", "IW ", " W ", 'I', "ingotInvar", 'W', "stickWood" }));
		}
		if (enableTools[5]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarHoe, new Object[] { "II ", " W ", " W ", 'I', "ingotInvar", 'W', "stickWood" }));
		}
		if (enableTools[6]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarShears, new Object[] { " I", "I ", 'I', "ingotInvar" }));
		}
		if (enableTools[7]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarFishingRod, new Object[] { "  I", " IS", "W S", 'I', "ingotInvar", 'W', "stickWood", 'S',
					Items.string }));
		}
		if (enableTools[8]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarSickle, new Object[] { " I ", "  I", "WI ", 'I', "ingotInvar", 'W', "stickWood" }));
		}
		if (enableTools[9]) {
			GameRegistry.addRecipe(new ShapedOreRecipe(toolInvarBow,
					new Object[] { " IW", "S W", " IW", 'I', "ingotInvar", 'S', "stickWood", 'W', Items.string }));
		}
	}

	public static boolean enableArmor = true;
	public static boolean[] enableTools = new boolean[10];

	static {
		String category = "item.feature";
		enableArmor = ThermalExpansion.config.get(category, "Armor.Invar", true);
		enableTools[0] = ThermalExpansion.config.get(category, "Tool.Invar.BattleWrench", true);
		enableTools[1] = ThermalExpansion.config.get(category, "Tool.Invar.Sword", true);
		enableTools[2] = ThermalExpansion.config.get(category, "Tool.Invar.Shovel", true);
		enableTools[3] = ThermalExpansion.config.get(category, "Tool.Invar.Pickaxe", true);
		enableTools[4] = ThermalExpansion.config.get(category, "Tool.Invar.Axe", true);
		enableTools[5] = ThermalExpansion.config.get(category, "Tool.Invar.Hoe", true);
		enableTools[6] = ThermalExpansion.config.get(category, "Tool.Invar.Shears", true);
		enableTools[7] = ThermalExpansion.config.get(category, "Tool.Invar.FishingRod", true);
		enableTools[8] = ThermalExpansion.config.get(category, "Tool.Invar.Sickle", true);
		enableTools[9] = ThermalExpansion.config.get(category, "Tool.Invar.Bow", true);
	}

	public static ItemArmorAdv itemHelmetInvar;
	public static ItemArmorAdv itemPlateInvar;
	public static ItemArmorAdv itemLegsInvar;
	public static ItemArmorAdv itemBootsInvar;

	public static Item itemBattleWrenchInvar;
	public static Item itemSwordInvar;
	public static Item itemShovelInvar;
	public static Item itemPickaxeInvar;
	public static Item itemAxeInvar;
	public static Item itemHoeInvar;
	public static Item itemShearsInvar;
	public static Item itemFishingRodInvar;
	public static Item itemSickleInvar;
	public static Item itemBowInvar;

	public static ItemStack armorInvarHelmet;
	public static ItemStack armorInvarPlate;
	public static ItemStack armorInvarLegs;
	public static ItemStack armorInvarBoots;

	public static ItemStack toolInvarBattleWrench;
	public static ItemStack toolInvarSword;
	public static ItemStack toolInvarShovel;
	public static ItemStack toolInvarPickaxe;
	public static ItemStack toolInvarAxe;
	public static ItemStack toolInvarHoe;
	public static ItemStack toolInvarShears;
	public static ItemStack toolInvarFishingRod;
	public static ItemStack toolInvarSickle;
	public static ItemStack toolInvarBow;

	public static final ToolMaterial TOOL_INVAR = EnumHelper.addToolMaterial("TE_INVAR", 2, 450, 7F, 2, 16);
	public static final ArmorMaterial ARMOR_INVAR = EnumHelper.addArmorMaterial("TE_INVAR", 25, new int[] { 2, 7, 5, 2 }, 11);
	public static final String[] TEXTURE_INVAR = { TEProps.PATH_ARMOR + "Invar_1.png", TEProps.PATH_ARMOR + "Invar_2.png" };

	public static final String ARMOR = "thermalexpansion.armor.";
	public static final String TOOL = "thermalexpansion.tool.";

}