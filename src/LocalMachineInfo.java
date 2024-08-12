import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalMachineInfo {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            String hostName = localHost.getHostName();

            System.out.println("Local machine IP address: " + ipAddress);
            System.out.println("Local machine hostname: " + hostName);
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine the IP address and hostname of the local machine.");
            e.printStackTrace();
        }
    }
}
