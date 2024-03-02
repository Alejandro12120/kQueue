package es.alejandro12120.kqueue.types;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class SList {

    private SNode head;
    private SNode tail;
    private int size;

    public SList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0 || (this.head == null && this.tail == null);
    }

    public void addFirst(Player element) {
        SNode newNode = new SNode(element);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        newNode.next = this.head;
        this.head = newNode;

        this.size++;
    }

    public void addLast(Player element) {
        SNode newNode = new SNode(element);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        this.tail.next = newNode;
        this.tail = newNode;

        this.size++;
    }

    public Player removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        Player element = this.head.element;
        this.head = this.head.next;

        this.size--;

        return element;
    }

    public Player removeLast() {
        // This is the method which has most complexity
        // It's O(n) because we need to iterate through the list
        if (this.isEmpty()) {
            return null;
        }

        SNode current = this.head;

        // Iterate until the penultimate node
        while (current.next != this.tail) {
            current = current.next;
        }

        Player element = this.tail.getElement();
        this.tail = current;
        this.tail.next = null;

        this.size--;

        return element;
    }

    public Player getFirst() {
        if (this.isEmpty()) {
            return null;
        }

        return this.head.getElement();
    }

    public Player getLast() {
        if (this.isEmpty()) {
            return null;
        }

        return this.tail.getElement();
    }

    @Getter
    public class SNode {

        private final Player element;
        private SNode next;

        public SNode(Player element) {
            this.element = element;
            this.next = null;
        }

    }
}
