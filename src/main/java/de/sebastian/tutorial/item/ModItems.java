package de.sebastian.tutorial.item;

import de.sebastian.tutorial.Tutorial;
import de.sebastian.tutorial.block.ModBlocks;
import de.sebastian.tutorial.item.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister <Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tutorial.MOD_ID);
    //Register Zircon Item
    public static final RegistryObject <Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    //Register Raw_zircon Item
    public static final RegistryObject <Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    //Register Eight_Ball item
    public static final RegistryObject <Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    //Register Warden_soul item
    public static final RegistryObject <Item> WARDEN_SOUL = ITEMS.register("warden_soul",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WARDEN_TAB).stacksTo(1)));

    //Register Blueberry_Seeds Item
    public static final RegistryObject <Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    //Register Blueberry Item
    public static final RegistryObject <Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
