package gg.quartzdev.qitemnamecontrol.listener;

import gg.quartzdev.qitemnamecontrol.ItemNameUtil;
import gg.quartzdev.qitemnamecontrol.qItemNameControl;
import jdk.internal.net.http.common.Pair;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemRenameListener implements Listener {
    NamespacedKey key;

    public ItemRenameListener(){
        key = new NamespacedKey(qItemNameControl.getInstance(), "item-name");
    }

    @EventHandler
    public void onAnvilUse(PrepareAnvilEvent event){

//        gets the item in the left slot
        ItemStack item = event.getInventory().getFirstItem();
        if(item == null) return;

//        do nothing if the item  name isn't locked
        if(!ItemNameUtil.isLocked(key, item)) return;

//        gets the resulting item (far right slot)
        ItemStack result = event.getInventory().getResult();
        if(result == null) return;
        if(!result.hasItemMeta()) return;

//        gets the two item names
        String itemName = ItemNameUtil.getItemName(item);
        String resultName = ItemNameUtil.getItemName(result);

//        if the result doesnt have name ignore
        if(resultName == null) return;
//        if the result has the same name ignore
        if(resultName.equals(itemName)) return;

//        gets item meta
        ItemMeta resultMeta = result.getItemMeta();

//        if the item doesn't have a name
        if(itemName == null)
//            don't give a name to the result
            resultMeta.displayName( null);
        else
//            gives the same name to the result
            resultMeta.displayName(item.getItemMeta().displayName());

//        updates the result item meta
        result.setItemMeta(resultMeta);
//        updates the result
        event.setResult(result);

    }

}
