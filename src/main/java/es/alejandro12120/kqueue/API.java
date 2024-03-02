package es.alejandro12120.kqueue;

import es.alejandro12120.kqueue.servers.ServerQueue;
import org.bukkit.entity.Player;

public class API {

    public void createServer(String name, int players, int maxPlayers) {
        ServerQueue server = new ServerQueue(name, players, maxPlayers);

        kQueue.getInstance().getServerManager().addServer(server);
    }

    public void removeServer(String name) {
        kQueue.getInstance().getServerManager().removeServer(name);
    }

    public void addPlayerToQueue(String server, Player player) {
        ServerQueue serverQueue = kQueue.getInstance().getServerManager().getServer(server);

        if (serverQueue != null)
            serverQueue.addPlayerToQueue(player);

    }

    public Player removePlayerFromQueue(String server) {
        ServerQueue serverQueue = kQueue.getInstance().getServerManager().getServer(server);

        if (serverQueue != null)
            return serverQueue.removePlayerFromQueue();

        return null;
    }

    public Player getFirstPlayer(String server) {
        ServerQueue serverQueue = kQueue.getInstance().getServerManager().getServer(server);

        if (serverQueue != null)
            return serverQueue.getFirstPlayer();

        return null;
    }

    public boolean isQueueEmpty(String server) {
        ServerQueue serverQueue = kQueue.getInstance().getServerManager().getServer(server);

        if (serverQueue != null)
            return serverQueue.isQueueEmpty();

        return false;
    }

    public int getQueueSize(String server) {
        ServerQueue serverQueue = kQueue.getInstance().getServerManager().getServer(server);

        if (serverQueue != null)
            return serverQueue.getQueueSize();

        return -1;
    }

    public boolean serverExists(String name) {
        return kQueue.getInstance().getServerManager().serverExists(name);
    }

}
