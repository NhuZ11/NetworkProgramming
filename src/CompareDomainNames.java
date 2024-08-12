import java.net.InetAddress;
import java.net.UnknownHostException;

public class CompareDomainNames {
    public static void main(String[] args) {
        String domain1 = "www.ibiblio.org";
        String domain2 = "ibiblio.org";

        try {
            InetAddress address1 = InetAddress.getByName(domain1);
            InetAddress address2 = InetAddress.getByName(domain2);

            if (address1.equals(address2)) {
                System.out.println(domain1 + " and " + domain2 + " resolve to the same IP address: " + address1.getHostAddress());
            } else {
                System.out.println(domain1 + " and " + domain2 + " resolve to different IP addresses.");
                System.out.println(domain1 + " resolves to: " + address1.getHostAddress());
                System.out.println(domain2 + " resolves to: " + address2.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve one or both of the domain names.");
            e.printStackTrace();
        }
    }
}
