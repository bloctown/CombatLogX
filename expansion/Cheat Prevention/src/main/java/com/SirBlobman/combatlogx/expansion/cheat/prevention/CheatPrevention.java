package com.SirBlobman.combatlogx.expansion.cheat.prevention;

import com.SirBlobman.combatlogx.api.ICombatLogX;
import com.SirBlobman.combatlogx.api.expansion.Expansion;
import com.SirBlobman.combatlogx.api.shaded.nms.NMS_Handler;
import com.SirBlobman.combatlogx.expansion.cheat.prevention.listener.*;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CheatPrevention extends Expansion {
    public CheatPrevention(ICombatLogX plugin) {
        super(plugin);
    }

    @Override
    public String getUnlocalizedName() {
        return "CheatPrevention";
    }

    @Override
    public String getName() {
        return "Cheat Prevention";
    }

    @Override
    public String getVersion() {
        return "15.0";
    }

    @Override
    public void onLoad() {
        saveDefaultConfig("cheat-prevention.yml");
    }

    @Override
    public void onEnable() {
        PluginManager manager = Bukkit.getPluginManager();
        JavaPlugin plugin = getPlugin().getPlugin();

        int minorVersion = NMS_Handler.getMinorVersion();
        if(minorVersion >= 9) manager.registerEvents(new ListenerElytra(this), plugin);

        if(minorVersion >= 11) manager.registerEvents(new ListenerTotemOfUndying(this), plugin);

        Listener itemPickupListener = minorVersion >= 12 ? new ListenerNewItemPickup(this) : new ListenerLegacyItemPickup(this);
        manager.registerEvents(itemPickupListener, plugin);

        if(minorVersion >= 13) manager.registerEvents(new ListenerRiptide(this), plugin);

        manager.registerEvents(new ListenerBlocks(this), plugin);
        manager.registerEvents(new ListenerChat(this), plugin);
        manager.registerEvents(new ListenerCommandBlocker(this), plugin);
        /*
        manager.registerEvents(new ListenerEntities(this), plugin);
        manager.registerEvents(new ListenerFlight(this), plugin);
        manager.registerEvents(new ListenerGameMode(this), plugin);
        manager.registerEvents(new ListenerInventories(this), plugin);
        manager.registerEvents(new ListenerTeleport(this), plugin);
         */
    }

    @Override
    public void onDisable() {
        // Do Nothing
    }

    @Override
    public void reloadConfig() {
        reloadConfig("cheat-prevention.yml");
    }
}