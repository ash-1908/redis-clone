package src.main.java.com.ash.remotedictserver.server;

import src.main.java.com.ash.remotedictserver.server.cache.handler.CacheHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final CacheHandler cacheHandler;

    private final Socket client;

    public ClientHandler(Socket client, CacheHandler cacheHandler) {
        this.client = client;
        this.cacheHandler = cacheHandler;
    }

    @Override
    public void run() {
        this.handleClient(client);
    }

    public void handleClient(Socket client) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        ) {
            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("exit"))
                    break;
                String[] command = inputLine.split(" ");
                outputLine = cacheHandler.processCommand(command);

                out.println(outputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
