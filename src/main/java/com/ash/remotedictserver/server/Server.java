package src.main.java.com.ash.remotedictserver.server;

import src.main.java.com.ash.remotedictserver.server.cache.handler.CacheHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main(String[] args) {

        // create server
        int port = 4444;

        CacheHandler cacheHandler = new CacheHandler();

        try (
                ServerSocket server = new ServerSocket(port);
        ) {
            while (true) {
                Socket client = server.accept();
                Thread.ofVirtual().start(new ClientHandler(client, cacheHandler));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}