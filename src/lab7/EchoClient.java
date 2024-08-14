package lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345; // Port for the echo service

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String userMessage;
            System.out.println("Type messages to send to the server (type 'exit' to quit):");

            // Main loop to send messages to the server
            while ((userMessage = userInput.readLine()) != null) {
                out.println(userMessage); // Send message to server

                if ("exit".equalsIgnoreCase(userMessage)) {
                    break; // Exit if the user types 'exit'
                }

                String response = in.readLine(); // Read the echo response from the server
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

