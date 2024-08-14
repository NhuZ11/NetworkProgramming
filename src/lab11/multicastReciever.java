package lab11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class multicastReciever {
    public static void main(String[] args) {
        String multicastGroupIP = "230.0.0.0"; // Multicast group IP
        int port = 4446; // Port number

        MulticastSocket multicastSocket = null;
        InetAddress group = null;

        try {
            // Create a multicast socket bound to the specified port
            multicastSocket = new MulticastSocket(port);

            // Join the multicast group
            group = InetAddress.getByName(multicastGroupIP);
            multicastSocket.joinGroup(group);

            System.out.println("Listening for multicast messages on " + multicastGroupIP + ":" + port);

            // Buffer to receive incoming data
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Keep listening for incoming data
            while (true) {
                multicastSocket.receive(packet); // Receive packet
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Leave the multicast group and close the socket
            try {
                if (multicastSocket != null && group != null) {
                    multicastSocket.leaveGroup(group);
                    multicastSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


