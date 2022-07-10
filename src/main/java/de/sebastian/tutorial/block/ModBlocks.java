package de.sebastian.tutorial.block;

import de.sebastian.tutorial.Tutorial;
import de.sebastian.tutorial.block.custom.*;
import de.sebastian.tutorial.item.ModCreativeModeTab;
import de.sebastian.tutorial.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import oshi.jna.platform.windows.NtDll;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tutorial.MOD_ID);

    //New Blocks

        //Zircon Block
    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

        //Zircon Ore
    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);


        //Zircon Deepslate Ore
    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
           () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(6).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

        //Zircon Netherrack Ore
    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(6).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

        //Zircon Endstone Ore
    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(6).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);
        //Jumpy Block
    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(6).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    //Teleport Block
    public static final RegistryObject<Block> TELEPORT_BLOCK = registerBlock("teleporter_block",
            () -> new TeleporterBlock(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(6).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    //Teleport Block
    public static final RegistryObject<Block> TELEPORT_OUT_BLOCK = registerBlock("teleporter_out_block",
            () -> new TeleportOutBlock(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(6).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

        //Zircon Lamp
    public static final RegistryObject<Block> ZIRCON_LAMP = registerBlock("zircon_lamp",
            () -> new ZirconLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(6).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(ZirconLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.TUTORIAL_TAB);

        //Blueberry Crop
    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    private static <T extends  Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return  toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
