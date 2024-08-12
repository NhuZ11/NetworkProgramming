import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckReachability {
    public static void main(String[] args) {
        // Replace this with the IP address or hostname of the remote system you want to check
        String remoteHost = "www.tufohss.edu.np"; // Example hostname
        // String remoteHost = "192.168.1.1"; // Example IP address

        try {
            InetAddress address = InetAddress.getByName(remoteHost);

            // Ping the remote host with a timeout of 5000 milliseconds (5 seconds)
            boolean isReachable = address.isReachable(5000);

            if (isReachable) {
                System.out.println(remoteHost + " is reachable.");
            } else {
                System.out.println(remoteHost + " is not reachable.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + remoteHost);
            e.printStackTrace();
        } catch (java.io.IOException e) {
            System.err.println("Error checking reachability of: " + remoteHost);
            e.printStackTrace();
        }
    }
}
