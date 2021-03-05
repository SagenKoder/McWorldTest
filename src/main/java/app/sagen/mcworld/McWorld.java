package app.sagen.mcworld;

import app.sagen.mcworld.spigotgenerator.SpigotGenerator;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Alexander Sagen
 * @date 2021-03-04
 */
public class McWorld extends JavaPlugin {

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("§6§l[Mc World] §7->    §fLoading....");
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§6§l[Mc World] §7->    §fStarting up....");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§6§l[Mc World] §7->    §fDisabling....");
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        // todo: Use worldName and id to select what area of norway to generate?
        return new SpigotGenerator();
    }
}
