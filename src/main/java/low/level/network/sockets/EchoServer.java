package low.level.network.sockets;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by sajit on 11/13/16.
 */

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 *
 * This is one way communication between server and client
 */
public class EchoServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {

                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println("Writing output " + RandomStringUtils.random(4));
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}
