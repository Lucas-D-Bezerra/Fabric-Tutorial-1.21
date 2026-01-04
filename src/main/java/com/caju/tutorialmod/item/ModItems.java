package com.caju.tutorialmod.item;

import com.caju.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //criar item
    public static final Item MALACHITE_CRYSTAL= registerItem("malachite_crystal", new Item(new Item.Settings()));


    //Funcoes auxiliares para registrar os items
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for" + TutorialMod.MOD_ID);

        //
        //-----------------------------------------------------
        //adicionar o item ao inventario no criativo em um grupo de items
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(enties-> {
            enties.add(MALACHITE_CRYSTAL);
        });
    }



}
