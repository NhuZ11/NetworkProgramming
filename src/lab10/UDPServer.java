package lab10;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        int port = 9876; // Port number for the server
        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Server is running on port " + port);

            while (true) {
                // Prepare buffer for incoming data
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                // Receive packet from client
                serverSocket.receive(receivePacket);
                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Determine if the number is even or odd
                int number = Integer.parseInt(receivedData);
                String responseMessage = (number % 2 == 0) ? "Even" : "Odd";

                // Send response back to client
                byte[] sendBuffer = responseMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
                System.out.println("Received: " + number + ", Responded: " + responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

