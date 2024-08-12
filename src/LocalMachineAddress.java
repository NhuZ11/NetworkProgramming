import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalMachineAddress {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            System.out.println("The IP address of the local machine is: " + ipAddress);
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine the IP address of the local machine.");
            e.printStackTrace();
        }
    }
}
