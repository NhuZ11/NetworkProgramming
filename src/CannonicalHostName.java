import java.net.InetAddress;
import java.net.UnknownHostException;

public class CannonicalHostName {
    public static void main(String[] args) {
        // You can replace "www.tufohss.edu.np" with any address you want to look up
        String address = "www.tufohss.edu.np";

        try {
            InetAddress inetAddress = InetAddress.getByName(address);
            String canonicalHostname = inetAddress.getCanonicalHostName();
            System.out.println("The canonical hostname of the address " + address + " is: " + canonicalHostname);
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine the canonical hostname of the address: " + address);
            e.printStackTrace();
        }
    }
}
