package gg.quartzdev.qitemnamecontrol;

import gg.quartzdev.qitemnamecontrol.listener.ItemRenameListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class qItemNameControl extends JavaPlugin {

    private static qItemNameControl instance;

    public static qItemNameControl getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ItemRenameListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
