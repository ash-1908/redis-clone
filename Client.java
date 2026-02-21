import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        String hostName = "127.0.0.1";

        int portNumber = 4444;

        try (
                Scanner stdIn = new Scanner(System.in);
                Socket socket = new Socket(hostName, portNumber);

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {

            String fromServer, fromClient;

            while ((fromClient = stdIn.nextLine()) != null) {
                if (fromClient.equals("Bye."))
                    break;

                out.println(fromClient);

                fromServer = in.readLine();

                System.out.println("Server: " + fromServer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
