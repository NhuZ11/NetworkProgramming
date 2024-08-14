package lab5;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class PrintURLConnectionURL {
    public static void main(String[] args) {
        String urlString = "http://www.tufhoss.edu.np";

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            // Print the URL of the URLConnection
            System.out.println("URL: " + connection.getURL());

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

