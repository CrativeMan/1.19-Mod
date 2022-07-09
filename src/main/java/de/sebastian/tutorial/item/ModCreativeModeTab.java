package de.sebastian.tutorial.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab("tutorialtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ZIRCON.get());
        }
    };

    public static final CreativeModeTab WARDEN_TAB = new CreativeModeTab("wardentab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WARDEN_SOUL.get());
        }
    };

}
