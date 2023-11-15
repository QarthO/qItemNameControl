package gg.quartzdev.qitemnamecontrol.listener;

import gg.quartzdev.qitemnamecontrol.ItemNameUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class ItemRenameListener implements Listener {

    @EventHandler
    public void onAnvilUse(PrepareAnvilEvent event){

        ItemStack item = event.getInventory().getFirstItem();
        if(item == null) return;

        ItemStack result = event.getInventory().getResult();

        if(result == null) return;
        if(result.hasItemMeta()) return;

        boolean sameName = ItemNameUtil.compareItemNames(item, result);
        Bukkit.getLogger().info("Same name: " + sameName);

    }

    @EventHandler
    public void on(PrepareAnvilEvent event){
//        event.
//                event.getInventory().setRepairCostAmount(100000);
//        ItemStack beforeItem = event.getInventory().getFirstItem();
//        ItemStack afterItem = event.getInventory().getResult();
//
//        if(beforeItem == null || afterItem == null) return;
//
//        compareItemNames(beforeItem, afterItem);

//        String beforeItemName = beforeItem.getI18NDisplayName();
//        String afterItemName = afterItem.getI18NDisplayName();
//
//        if(beforeItem.hasItemMeta()){
//            beforeItemName = beforeItem.getItemMeta().getDisplayName();
//        }
//
//        if(afterItem.hasItemMeta()){
//            afterItemName = afterItem.getItemMeta().getDisplayName();
//        }
//
//        Bukkit.getLogger().info("beforeItemName: " + beforeItemName);
//        Bukkit.getLogger().info("afterItemName: " + afterItemName);
//
//        if(beforeItemName.equals(afterItemName)) return;
//
//        ItemMeta afterItemMeta = afterItem.getItemMeta();
//        afterItemMeta.setDisplayName(beforeItemName);
//        afterItem.setItemMeta(afterItemMeta);
//
//        event.setResult(afterItem);

    }



}
