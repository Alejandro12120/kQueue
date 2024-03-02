package es.alejandro12120.kqueue.types;

import org.bukkit.entity.Player;

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

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.getSize();
    }

}
