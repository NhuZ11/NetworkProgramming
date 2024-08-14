package lab10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int port = 9876; // Server port
        Scanner scanner = new Scanner(System.in);

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            while (true) {
                System.out.print("Enter a number (or 'exit' to quit): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if the user types 'exit'
                }

                // Send number to the server
                byte[] sendBuffer = input.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, java.net.InetAddress.getByName(serverAddress), port);
                clientSocket.send(sendPacket);

                // Prepare buffer for receiving response
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                // Receive response from the server
                clientSocket.receive(receivePacket);
                String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server response: " + responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

