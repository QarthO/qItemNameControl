package gg.quartzdev.qitemnamecontrol;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemNameUtil {

    public static String getItemName(ItemStack item){
        if(!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) return null;

        MiniMessage mm = MiniMessage.miniMessage();
        Component component = item.getItemMeta().displayName();
        if(component == null) return null;

        return mm.serialize(component);
    }

    public static ItemStack toggleLockItemName(NamespacedKey key, ItemStack item){


        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();

        boolean isLocked = true;

        if(pdc.has(key, PersistentDataType.BOOLEAN))
            isLocked = !pdc.get(key, PersistentDataType.BOOLEAN);

        pdc.set(key, PersistentDataType.BOOLEAN, isLocked);

        return item;
    }

    public static boolean isLocked(NamespacedKey key, ItemStack item){

        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();

        boolean isLocked = false;

        if(pdc.has(key, PersistentDataType.BOOLEAN))
            isLocked = !pdc.get(key, PersistentDataType.BOOLEAN);

        return isLocked;
    }

}
