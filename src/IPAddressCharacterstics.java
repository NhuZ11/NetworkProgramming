import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressCharacterstics {
    public static void main(String[] args) {
        // You can replace this with any IP address you want to check
        String ipAddress = "192.168.1.1"; // Example IPv4 address
        // String ipAddress = "2001:0db8:85a3:0000:0000:8a2e:0370:7334"; // Example IPv6 address

        try {
            InetAddress address = InetAddress.getByName(ipAddress);

            System.out.println("IP Address: " + address.getHostAddress());

            if (address instanceof java.net.Inet4Address) {
                System.out.println("Type: IPv4");
            } else if (address instanceof java.net.Inet6Address) {
                System.out.println("Type: IPv6");
            } else {
                System.out.println("Type: Unknown");
            }

            if (address.isLoopbackAddress()) {
                System.out.println("This is a loopback address.");
            } else {
                System.out.println("This is not a loopback address.");
            }

            if (address.isLinkLocalAddress()) {
                System.out.println("This is a link-local address.");
            } else {
                System.out.println("This is not a link-local address.");
            }

            if (address.isMulticastAddress()) {
                System.out.println("This is a multicast address.");
            } else {
                System.out.println("This is not a multicast address.");
            }

        } catch (UnknownHostException e) {
            System.err.println("Invalid IP address: " + ipAddress);
            e.printStackTrace();
        }
    }
}
