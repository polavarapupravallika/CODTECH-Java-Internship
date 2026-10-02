import java.net.URI;
import java.net.http.*;

class Main {
    public static void main(String[] args) throws Exception {

        // URL of the public weather REST API
        String url = "https://api.open-meteo.com/v1/forecast?latitude=14.4426&longitude=79.9865&current=temperature_2m,wind_speed_10m";

        // Create HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create HTTP GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send request and receive JSON response
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Store the JSON response
        String json = response.body();

        // Get the current weather section from JSON
        String current = json.substring(json.indexOf("\"current\":"));

        // Extract required values from the JSON response
        String time = getValue(current, "\"time\":\"", "\"");
        String temperature = getValue(current, "\"temperature_2m\":", ",");
        String wind = getValue(current, "\"wind_speed_10m\":", "}");

        // Display the weather information
        System.out.println("===== WEATHER INFORMATION =====");
        System.out.println();
        System.out.println("Time        : " + time);
        System.out.println("Temperature : " + temperature + " °C");
        System.out.println("Wind Speed  : " + wind + " km/h");
        System.out.println();
        System.out.println("===============================");
    }

    // Method to extract a value from the JSON response
    static String getValue(String text, String start, String end) {
        int a = text.indexOf(start) + start.length();
        int b = text.indexOf(end, a);
        return text.substring(a, b);
    }
}