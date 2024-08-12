import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class ListNetworkInterface {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            if (networkInterfaces == null) {
                System.out.println("No network interfaces found.");
                return;
            }

            System.out.println("Network Interfaces:");
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println("Is up: " + networkInterface.isUp());
                System.out.println("Is loopback: " + networkInterface.isLoopback());
                System.out.println("Is virtual: " + networkInterface.isVirtual());
                System.out.println("Supports multicast: " + networkInterface.supportsMulticast());

                Enumeration<java.net.InetAddress> inetAddresses = networkInterface.getInetAddresses();
                System.out.println("Addresses:");
                for (java.net.InetAddress inetAddress : Collections.list(inetAddresses)) {
                    System.out.println(" - " + inetAddress.getHostAddress());
                }

                System.out.println();
            }
        } catch (SocketException e) {
            System.err.println("Error retrieving network interfaces.");
            e.printStackTrace();
        }
    }
}
