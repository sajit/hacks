package low.level.network.sockets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Trivial client for the echo server. 1 way communication
 */
public class EchoClient {


    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        Socket s = new Socket(serverAddress, 9090);

        BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        System.out.println("Answer " + answer);
        System.exit(0);
    }
}