package es.alejandro12120.kqueue

import org.bukkit.plugin.java.JavaPlugin

class kQueue : JavaPlugin() {

    companion object {
        lateinit var instance: kQueue
            private set
    }

    override fun onEnable() {
        instance = this

        logger.info("kQueue has been enabled")
    }

}