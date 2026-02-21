import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        // create server
        int port = 4444;

        final CacheHandler cacheHandler = new CacheHandler();

        try (
                ServerSocket server = new ServerSocket(port);
                // accept client connection
                Socket client = server.accept();

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
