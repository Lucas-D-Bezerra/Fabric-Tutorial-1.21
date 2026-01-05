package com.caju.tutorialmod.item;

import com.caju.tutorialmod.TutorialMod;
import com.caju.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Group for " + TutorialMod.MOD_ID);
    }

    public static final ItemGroup MALACHITE_ITEMS_TAB= Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "malachite_items"),
            FabricItemGroup.builder()
                    //-------------------
                    //add os metodos entre o builder() e o build()

                    .icon(()-> new ItemStack(ModBlocks.MALACHITE_CRYSTAL_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.malachite_tab"))
                    .entries((displayContext, entries) -> {

                        //--------------------------------
                        //Add items to group aqui
                        //dentro de .entries

                            //>Items<
                        entries.add(ModItems.MALACHITE_CRYSTAL);
                        entries.add(ModItems.RAW_MALACHITE_CRYSTAL);

                            //>Blocks<
                        entries.add(ModBlocks.MALACHITE_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.RAW_MALACHITE_CRYSTAL_BLOCK);



                        //--------------------------------

                    })
                    //------------------
                    //add os metodos entre o builder() e o build()
                    .build());
}
