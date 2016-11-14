package low.level.network.sockets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sajit on 11/13/16.
 */
public class CapitalizeClient{

        private BufferedReader in;
        private PrintWriter out;



        /**
         * Implements the connection logic by prompting the end user for
         * the server's IP address, connecting, setting up streams, and
         * consuming the welcome messages from the server.  The Capitalizer
         * protocol says that the server sends three lines of text to the
         * client immediately after establishing a connection.
         */
        public void connectToServer() throws IOException {

            // Get the server address from a dialog box.
            String serverAddress = "127.0.0.1";

            // Make connection and initialize streams
            Socket socket = new Socket(serverAddress, 9898);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Consume the initial welcoming messages from the server
            for (int i = 0; i < 3; i++) {
                System.out.println(in.readLine());
            }

            Scanner sc = new Scanner(System.in);

            while(true){
                String s = sc.nextLine();
                out.println(s);
                String serverResponse = in.readLine();
                if(serverResponse == null){
                    System.out.println("Closing connection .");
                    socket.close();
                    System.exit(0);
                }

                System.out.println("In client, received" + serverResponse);
            }



        }

        /**
         * Runs the client application.
         */
        public static void main(String[] args) throws Exception {
            CapitalizeClient client = new CapitalizeClient();

            client.connectToServer();
        }
}
