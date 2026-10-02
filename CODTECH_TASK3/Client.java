import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) throws Exception {

        // Connect to the server using port 5000
        Socket socket = new Socket("localhost", 5000);

        // Read messages received from the server
        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

        // Read messages typed by the user
        BufferedReader keyboard =
                new BufferedReader(
                        new InputStreamReader(System.in));

        // Send messages to the server
        PrintWriter output =
                new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Connected to chat server!");
        System.out.println("Type your message:");

        // Create a thread to receive messages from the server
        Thread thread = new Thread(() -> {

            try {
                String message;

                // Display received messages
                while ((message = input.readLine()) != null) {
                    System.out.println("Message: " + message);
                }

            } catch (Exception e) {
                System.out.println("Disconnected from server.");
            }
        });

        // Start the receiving thread
        thread.start();

        String message;

        // Read and send user messages
        while ((message = keyboard.readLine()) != null) {

            output.println(message);

            // Exit the chat when user types exit
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }

        // Close the connection
        socket.close();
    }
}