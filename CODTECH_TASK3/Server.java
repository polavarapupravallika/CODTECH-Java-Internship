import java.io.*;
import java.net.*;
import java.util.*;

class Server {

    // Store output streams of all connected clients
    static ArrayList<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // Create server socket on port 5000
        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Chat Server Started...");
        System.out.println("Waiting for clients...");

        while (true) {

            // Accept a new client connection
            Socket socket = serverSocket.accept();

            System.out.println("New client connected!");

            // Create output stream for the client
            PrintWriter output =
                    new PrintWriter(socket.getOutputStream(), true);

            // Add the client to the list
            clients.add(output);

            // Create a separate thread for each client
            Thread thread = new Thread(() -> {

                try {

                    // Read messages from the client
                    BufferedReader input =
                            new BufferedReader(
                                    new InputStreamReader(socket.getInputStream()));

                    String message;

                    // Receive messages continuously
                    while ((message = input.readLine()) != null) {

                        System.out.println("Client: " + message);

                        // Send the message to all connected clients
                        for (PrintWriter client : clients) {
                            client.println(message);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Client disconnected.");
                }
            });

            // Start the client thread
            thread.start();
        }
    }
}