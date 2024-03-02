package es.alejandro12120.kqueue;

import es.alejandro12120.kqueue.servers.ServerManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class kQueue extends JavaPlugin {

    private ServerManager serverManager;

    @Getter
    private static kQueue instance;

    @Override
    public void onEnable() {
        instance = this;

        this.serverManager = new ServerManager();

        this.getLogger().info("kQueue has been enabled!");
    }


}
