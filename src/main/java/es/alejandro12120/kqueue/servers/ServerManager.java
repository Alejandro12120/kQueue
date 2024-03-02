package es.alejandro12120.kqueue.servers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ServerManager {

    private final List<ServerQueue> servers;

    public ServerManager() {
        this.servers = new ArrayList<>();
    }

    public void addServer(ServerQueue server) {
        this.servers.add(server);
    }

    public void removeServer(ServerQueue server) {
        this.servers.remove(server);
    }

    public void removeServer(String name) {
        this.servers.removeIf(server -> server.getName().equalsIgnoreCase(name));
    }

    public ServerQueue getServer(String name) {
        return this.servers.stream().filter(server -> server.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public boolean serverExists(String name) {
        return this.servers.stream().anyMatch(server -> server.getName().equalsIgnoreCase(name));
    }
}
