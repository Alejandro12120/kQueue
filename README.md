# kQueue
Simple queue implementation in Java, with API integration or internal use.

This queue system uses a simply linked list to store the data, so it is more efficient when there is a lot of players in the queue, or the queue is modified frequently.

## Usage
### API Methods
```java
public void createServer(String name, int players, int maxPlayers) - Creates a server with a queue with the given name, number of players, and maximum number of players
public void removeServer(String name) - Removes the server with the given name
public void addPlayerToQueue(String server, Player player) - Adds a player to the queue of the specified server
public Player removePlayerFromQueue(String server) - Removes a player from the queue of the specified server and returns the player
public Player getFirstPlayer(String server) - Gets the first player in the queue of the specified server
public boolean isQueueEmpty(String server) - Checks if the queue of the specified server is empty
public int getQueueSize(String server) - Gets the size of the queue of the specified server
public boolean serverExists(String name) - Checks if a server with the given name exists
```
