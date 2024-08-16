package lab11;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class   MulticastServer {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1"; // Multicast address
        int port = 4446; // Port number
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            String message = "Hello from Multicast Server!";

            while (true) {
                // Convert message to bytes and create a packet
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);

                // Send the packet
                socket.send(packet);
                System.out.println("Sent: " + message);
                Thread.sleep(1000); // Wait for a second before sending the next message
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
dsfasdfasdfasdf
