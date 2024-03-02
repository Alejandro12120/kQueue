package es.alejandro12120.kqueue.servers;

import es.alejandro12120.kqueue.types.Queue;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.List;

@Getter
public class ServerQueue {

    private String name;
    private int players;
    private int maxPlayers;

    private Queue queue;

    public ServerQueue(String name, int players, int maxPlayers) {
        this.name = name;
        this.players = players;
        this.maxPlayers = maxPlayers;

        this.queue = new Queue();
    }

    public void addPlayerToQueue(Player player) {
        this.queue.enqueue(player);
    }

    public Player removePlayerFromQueue() {
        return this.queue.dequeue();
    }

    public int getPosition(Player player) {
        return this.queue.getPosition(player);
    }

    public List<Player> getPlayers() {
        return this.queue.getPlayers();
    }

    public Player getFirstPlayer() {
        return this.queue.front();
    }

    public boolean isQueueEmpty() {
        return this.queue.isEmpty();
    }

    public int getQueueSize() {
        return this.queue.size();
    }
}
