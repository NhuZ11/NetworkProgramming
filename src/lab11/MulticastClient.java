package lab11;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1"; // Multicast address
        int port = 4446; // Port number
        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group); // Join the multicast group

            System.out.println("Joined multicast group: " + multicastAddress);
            byte[] buffer = new byte[256];

            while (true) {
                // Receive the multicast message
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

