package dev.sebastianb.ttablets.creativetab;

import dev.sebastianb.ttablets.TTablets;
import dev.sebastianb.ttablets.items.TTabletsItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

public class TTabletsCreativeTab {

    /**
     * Instantiate creative tabs
     */
    public static final CustomCreativeTab CREATIVE_TAB = new CustomCreativeTab(TTablets.MOD_ID, false, () -> new ItemStack(TTabletsItems.TABLET));

    /**
     * This class is used for an extra tab in the creative inventory.
     * Many mods like to group their special items and blocks in a dedicated tab although it is also perfectly acceptable to put them in the vanilla tabs where it makes sense.
     */
    public static class CustomCreativeTab extends CreativeTabs {

        private final boolean hasSearchBar;
        private final Supplier<ItemStack> iconSupplier;

        public CustomCreativeTab(final String name, final boolean hasSearchBar, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.hasSearchBar = hasSearchBar;
            this.iconSupplier = iconSupplier;
        }

        /**
         * Gets the {@link ItemStack} to display for the tab's icon
         */
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

        @Override
        public String getBackgroundImageName() {
            if (this.hasSearchBar) {
                return "item_search.png";
            } else {
                return super.getBackgroundImageName();
            }
        }

        /**
         * Useful for adding extra items such as full variants of energy related items
         */
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(final NonNullList<ItemStack> items) {
            super.displayAllRelevantItems(items);
        }

        @Override
        public boolean hasSearchBar() {
            return this.hasSearchBar;
        }

    }




}
