package lab5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastModifiedTime {
    public static void main(String[] args) {
        String urlString = args.length > 0 ? args[0] : "https://rajarambhurtel.com.npHt";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
            long lastModified = connection.getLastModified();

            if (lastModified == 0) {
                System.out.println("Last modified time is not available.");
            } else {
                System.out.println("Last Modified Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(lastModified)));
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

