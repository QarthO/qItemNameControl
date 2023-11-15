package gg.quartzdev.qitemnamecontrol;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public class ItemNameUtil {

    private static String getItemName(ItemStack item){

        String name = item.getType().name();
        if(!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) return name;

        Component c = item.getItemMeta().displayName();
        if(c == null) return name;

        MiniMessage mm = MiniMessage.miniMessage();
        name = mm.serialize(c);

        return name;
    }

    public static boolean compareItemNames(ItemStack firstItem, ItemStack secondItem){

        String firstItemName = getItemName(firstItem);
        String secondItemName = getItemName(secondItem);

        Bukkit.getLogger().info(firstItemName);
        Bukkit.getLogger().info(secondItemName);

        return firstItemName.equals(secondItemName);
    }

}
