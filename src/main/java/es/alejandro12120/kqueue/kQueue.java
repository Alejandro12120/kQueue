package es.alejandro12120.kqueue;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class kQueue extends JavaPlugin {

    @Getter
    private static kQueue instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().info("kQueue has been enabled!");
    }


}
