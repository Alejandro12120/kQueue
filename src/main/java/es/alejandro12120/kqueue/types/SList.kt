package es.alejandro12120.kqueue.types

import org.bukkit.entity.Player

data class SList(

    var head: SNode?,
    var tail: SNode?,
    var size: Int

) {

    constructor() : this(
        null,
        null,
        0
    )

    fun isEmpty(): Boolean {
        return this.size == 0 || (this.head == null && this.tail == null)
    }

    fun addFirst(element: Player) {
        val newNode = SNode(element)
        if (this.isEmpty())
            this.tail = newNode
        else
            newNode.next = this.head

        this.head = newNode
        this.size++
    }

    fun addLast(element: Player) {
        val newNode = SNode(element)
        if (this.isEmpty())
            this.head = newNode
        else
            this.tail?.next = newNode

        this.tail = newNode
        this.size++
    }

    fun removeFirst(): Player? {
        if (this.isEmpty()) return null

        val element = this.head?.element
        this.head = this.head?.next

        if (this.head == null) this.tail = null // If the list had only one element and we removed it

        this.size--

        return element
    }

    fun removeLast(): Player? {
        // This one of the method which has a time complexity of O(n)
        // It's O(n) because we need to iterate through the list

        if (this.isEmpty()) return null

        val element = this.tail?.element

        // If the list has only one element
        if (this.head == this.tail) {
            this.head = null
            this.tail = null
        } else {
            var current = this.head

            // Iterate until the penultimate node
            while (current?.next != this.tail)
                current = current?.next


            current?.next = null
            this.tail = current
        }

        this.size--

        return element
    }

    fun getPosition(playerName: String) : Int {
        // This method has a time complexity of O(n)
        // It's O(n) because we need to iterate through the list

        var current = this.head
        var position = 1

        while (current != null) {
            if (current.element.name == playerName)
                return position

            current = current.next
            position++
        }

        return -1
    }

    fun getPlayers() : List<Player> {
        // This method has a time complexity of O(n)
        // It's O(n) because we need to iterate through the list

        val players = mutableListOf<Player>()

        var current = this.head

        while (current != null) {
            players.add(current.element)
            current = current.next
        }

        return players
    }

    fun getFirst(): Player? {
        if (this.isEmpty()) return null

        return head?.element
    }

    fun getLast(): Player? {
        if (this.isEmpty()) return null

        return tail?.element
    }

    data class SNode(

        var element: Player,
        var next: SNode?

    ) {

        constructor(value: Player) : this(
            element = value,
            next = null
        )

    }
}