import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPaddresses {
    public static void main(String[] args) {
        // You can replace "www.tufohss.edu.np" with any web address you want to look up
        String webAddress = "www.tufohss.edu.np";

        try {
            InetAddress[] addresses = InetAddress.getAllByName(webAddress);

            System.out.println("IP addresses for " + webAddress + ":");
            for (InetAddress address : addresses) {
                if (address instanceof java.net.Inet4Address) {
                    System.out.println("IPv4: " + address.getHostAddress());
                } else if (address instanceof java.net.Inet6Address) {
                    System.out.println("IPv6: " + address.getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine the IP addresses of the web address: " + webAddress);
            e.printStackTrace();
        }
    }
}
