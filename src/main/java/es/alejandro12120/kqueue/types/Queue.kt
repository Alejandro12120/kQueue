package es.alejandro12120.kqueue.types

import org.bukkit.entity.Player

data class Queue(

    var list: SList

) {

    constructor() : this(SList())

    fun enqueue(element: Player) {
        this.list.addLast(element)
    }

    fun dequeue(): Player? {
        return this.list.removeFirst()
    }

    fun front(): Player? {
        return this.list.head?.element
    }

    fun getPosition(player: Player): Int {
        return this.list.getPosition(player.name)
    }

    fun getPlayers(): List<Player> {
        return this.list.getPlayers()
    }

    fun isEmpty(): Boolean {
        return this.list.isEmpty()
    }

    fun size(): Int {
        return this.list.size
    }
}