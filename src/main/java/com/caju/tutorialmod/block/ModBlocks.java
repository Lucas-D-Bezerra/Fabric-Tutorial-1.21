package com.caju.tutorialmod.block;

import com.caju.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;



public class ModBlocks {
    public static final Block MALACHITE_CRYSTAL_BLOCK= registerBlock("malachite_crystal_block",
           //2x shift on "Block "to see vanilla blocks
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .mapColor(MapColor.GREEN)
                    .allowsSpawning(Blocks::never)
                    .instrument(NoteBlockInstrument.BELL)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .luminance(state -> 10)
            ));
    public static final Block RAW_MALACHITE_CRYSTAL_BLOCK= registerBlock("raw_malachite_crystal_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.BASALT)
                    .mapColor(MapColor.GRAY)
                    .instrument(NoteBlockInstrument.BASS)
                    .luminance(state -> 4)
            ));



    //-------------------------------
    //metodos auxiliares para registrar o bloco e seu item respectivo
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering Mod Block for "+ TutorialMod.MOD_ID);

        //
        //-----------------------------------------------------
        //adicionar o item ao inventario no criativo em um grupo de items
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(enties-> {
            //sao adicionados individualmente
            enties.add(MALACHITE_CRYSTAL_BLOCK);
            enties.add(RAW_MALACHITE_CRYSTAL_BLOCK);
        });
    }


}
