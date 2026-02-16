import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    public static void main(String[] args) {
        
        // create server
        int port = 4444;
        
        try(
            ServerSocket server = new ServerSocket(port);
    
            // accept client connection
            Socket client = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true); 
        ) {

            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                
                String[] command = inputLine.split(" ");

                for(String s: command) {
                    System.out.print(s + " ");
                }

                System.out.println();

                if (inputLine.equals("exit"))
                    break;
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
