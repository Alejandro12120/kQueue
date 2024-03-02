package es.alejandro12120.kqueue.types;

import org.bukkit.entity.Player;

import java.util.List;

public class Queue {

    private SList list;

    public Queue() {
        this.list = new SList();
    }

    public void enqueue(Player element) {
        this.list.addLast(element);
    }

    public Player dequeue() {
        return this.list.removeFirst();
    }

    public Player front() {
        return this.list.getHead().getElement();
    }

    public int getPosition(Player player) {
        return this.list.getPosition(player.getName());
    }

    public List<Player> getPlayers() {
        return this.list.getPlayers();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.getSize();
    }

}
