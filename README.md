# kQueue
Optimized queue system for HUBs in Minecraft Networks.

This queue system uses a simply linked list to store the data, so it is more efficient when there is a lot of players in the queue, or the queue is modified frequently.

![image](https://github.com/Alejandro12120/kQueue/assets/45500329/c8b65465-100d-4a91-bcad-d00046aa0e18)
## Usage
### TestQueue
```java
import es.alejandro12120.kqueue.servers.ServerQueue;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@Getter
public class TestQueue {

    private final ServerQueue serverQueue;
    private boolean paused;
    private final long delay;

    public TestQueue() {
        this.serverQueue = new ServerQueue("test");
        this.paused = false;
        this.delay = 7; // In seconds

        startTask();
    }

    public void pauseQueue() {
        this.paused = true;
    }

    public void resumeQueue() {
        this.paused = false;
    }

    public void startTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (serverQueue.isQueueEmpty()) return;

                serverQueue.getPlayers().forEach(p -> p.sendMessage("Position: " + serverQueue.getPosition(p) + "/" + serverQueue.getQueueSize()));

                if (paused) return;

                Player player = serverQueue.removePlayerFromQueue();
                if (player != null)
                    player.sendMessage("You have been removed from the queue");
            }
        }.runTaskTimer(QueueSystem.getInstance(), 0, delay * 20);

    }
}
```
Add player to Queue:
```
#.getTestQueue().getServerQueue().addPlayerToQueue(player);
```
Remove player from Queue:
```
#.getTestQueue().getServerQueue().removePlayerFromQueue(); - Returns the player removed from the queue
```
## Installation
### Maven
Using a system dependency.
Create a folder called `libs` in the root of your project and add the jar file to it.
```xml
<dependency>
    <groupId>es.alejandro12120</groupId>
    <artifactId>kQueue</artifactId>
    <version>1.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/libs/kqueue.jar</systemPath>
</dependency>
```
