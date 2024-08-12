import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddressType {
    public static void main(String[] args) {
        String webAddress = "www.tufohss.edu.np";

        try {
            InetAddress[] addresses = InetAddress.getAllByName(webAddress);

            for (InetAddress address : addresses) {
                if (address instanceof java.net.Inet4Address) {
                    System.out.println(address.getHostAddress() + " is an IPv4 address.");
                } else if (address instanceof java.net.Inet6Address) {
                    System.out.println(address.getHostAddress() + " is an IPv6 address.");
                } else {
                    System.out.println(address.getHostAddress() + " is of unknown type.");
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine the IP addresses of the web address: " + webAddress);
            e.printStackTrace();
        }
    }
}
