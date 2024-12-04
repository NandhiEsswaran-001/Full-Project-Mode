import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Localhost
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to echo server");
            String userInput;
            System.out.println("Type messages to send to the server. Type 'exit' to quit.");

            while (true) {
                System.out.print("You: ");
                userInput = consoleInput.readLine();
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                output.println(userInput); // Send message to server
                System.out.println("Server: " + input.readLine()); // Read echoed message from server
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
