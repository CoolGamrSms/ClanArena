package com.shaneschulte.mc.clanarena;

import com.shaneschulte.mc.clanarena.events.OnJoin;
import com.shaneschulte.mc.clanarena.inventory.KitManager;
import com.shaneschulte.mc.clanarena.utils.ConstructTabCompleter;
import com.shaneschulte.mc.clanarena.utils.MsgUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class ClanArena extends JavaPlugin {

    private static ClanArena instance;

    @Override
    public void onEnable() {
        instance = this;

        // Register Events
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new ClanArenaListener(), this);

        // Kits
        KitManager.loadLoadouts();

        // Register Commands
        this.getCommand("ClanArena").setExecutor(new CommandHandler());
        this.getCommand("ClanArena").setTabCompleter(new ConstructTabCompleter());

        // Console Output
        MsgUtils.log("~Commands registered!~");
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    /**
     * get instance of ClanArena plugin
     * @return ClanArena instance
     */
    public static ClanArena getPlugin() {
        return instance;
    }

}
