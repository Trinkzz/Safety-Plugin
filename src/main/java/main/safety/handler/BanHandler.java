package main.safety.handler;

import main.safety.Safety;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Date;

public class BanHandler implements Listener {

    private final Safety plugin;

    public BanHandler(Safety plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Bukkit.getLogger().info("Block placed event triggered");

        Material placedBlockType = event.getBlock().getType();

        if (placedBlockType == Material.BEDROCK ||
                placedBlockType == Material.BARRIER ||
                placedBlockType == Material.COMMAND_BLOCK ||
                placedBlockType == Material.SPAWNER) {

            Bukkit.getLogger().info(placedBlockType + " placed");

            Player player = event.getPlayer();
            BanList banlist = Bukkit.getBanList(BanList.Type.NAME);
            Date now = new Date();
            banlist.addBan(player.getName(), "Has placed an illegal Block" + placedBlockType, now, null);
            player.kickPlayer("You have been banned for placing an illegal Block: " + placedBlockType);
        }
    }
}
