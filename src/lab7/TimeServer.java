package lab7;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) {
        int port = 12345; // Port for the time service

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Time server is running on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    // Get the current time
                    String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                    // Send the current time to the client
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("Current Time: " + currentTime);
                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
        }
    }
}

