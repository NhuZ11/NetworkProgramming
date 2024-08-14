package lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestMethods {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts";

        // GET request
        sendRequest(url, "GET", null);

        // POST request
        sendRequest(url, "POST", "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}");

        // PUT request
        sendRequest(url + "/1", "PUT", "{\"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}");

        // DELETE request
        sendRequest(url + "/1", "DELETE", null);
    }

    private static void sendRequest(String url, String method, String data) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            if (data != null) {
                conn.setDoOutput(true);
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(data.getBytes("utf-8"));
                }
            }

            System.out.println(method + " Response Code: " + conn.getResponseCode());

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
                System.out.println("Response: " + response);
            }
        } catch (Exception e) {
            System.err.println(method + " request error: " + e.getMessage());
        }
    }
}

