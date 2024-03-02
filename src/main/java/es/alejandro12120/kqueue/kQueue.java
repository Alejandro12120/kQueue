package es.alejandro12120.kqueue;

import es.alejandro12120.kqueue.servers.ServerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class kQueue extends JavaPlugin {

    private ServerManager serverManager;

    @Override
    public void onEnable() {
        this.serverManager = new ServerManager();

        this.getLogger().info("kQueue has been enabled!");
    }


}
