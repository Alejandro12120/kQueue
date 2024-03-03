package es.alejandro12120.kqueue.servers

import es.alejandro12120.kqueue.types.Queue
import org.bukkit.entity.Player

data class ServerQueue(

    var name: String,
    var queue: Queue

) {

    constructor(name: String) : this(name, Queue())

    fun addPlayerToQueue(player: Player) {
        this.queue.enqueue(player)
    }

    fun removePlayerFromQueue(): Player? {
        return this.queue.dequeue()
    }

    fun getPosition(player: Player): Int {
        return this.queue.getPosition(player)
    }

    fun getPlayers(): List<Player> {
        return this.queue.getPlayers()
    }

    fun getFirstPlayer(): Player? {
        return this.queue.front()
    }

    fun isQueueEmpty(): Boolean {
        return this.queue.isEmpty()
    }

    fun getQueueSize(): Int {
        return this.queue.size()
    }
}