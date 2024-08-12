import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceDetails {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            if (networkInterfaces == null) {
                System.out.println("No network interfaces found.");
                return;
            }

            System.out.println("Network Interfaces:");
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                // Print basic details
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());

                // Check and print various properties
                System.out.println("Is up: " + networkInterface.isUp());
                System.out.println("Is loopback: " + networkInterface.isLoopback());
                System.out.println("Is virtual: " + networkInterface.isVirtual());
                System.out.println("Supports multicast: " + networkInterface.supportsMulticast());

                // List IP addresses associated with the network interface
                Enumeration<java.net.InetAddress> inetAddresses = networkInterface.getInetAddresses();
                System.out.println("Addresses:");
                for (java.net.InetAddress inetAddress : Collections.list(inetAddresses)) {
                    System.out.println(" - " + inetAddress.getHostAddress());
                }

                // Print interface's hardware address if available
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress != null) {
                    System.out.print("Hardware Address: ");
                    for (int i = 0; i < hardwareAddress.length; i++) {
                        if (i > 0) System.out.print(":");
                        System.out.printf("%02x", hardwareAddress[i]);
                    }
                    System.out.println();
                } else {
                    System.out.println("Hardware Address: Not available");
                }

                // Print MTU (Maximum Transmission Unit) if available
                int mtu = networkInterface.getMTU();
                System.out.println("MTU: " + (mtu > 0 ? mtu : "Not available"));

                System.out.println();
            }
        } catch (SocketException e) {
            System.err.println("Error retrieving network interfaces.");
            e.printStackTrace();
        }
    }
}
