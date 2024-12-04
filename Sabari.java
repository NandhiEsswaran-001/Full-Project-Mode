Program no 1



import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String fileName = input.readUTF();
                File file = new File(fileName);

                if (file.exists()) {
                    output.writeUTF("File found. Preparing to send...");

                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }

                    fileInputStream.close();
                    System.out.println("File sent: " + fileName);
                } else {
                    output.writeUTF("File not found.");
                }

                socket.close();
                System.out.println("Connection closed.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
            }




Program no 2



import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 8080;
        String fileName = "example.txt"; // Change this to the desired file name

        try (Socket socket = new Socket(serverAddress, port)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());

            output.writeUTF(fileName);

            String response = input.readUTF();
            System.out.println("Server response: " + response);

            if (response.startsWith("File found")) {
                FileOutputStream fileOutputStream = new FileOutputStream("downloaded_" + fileName);
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = input.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.close();
                System.out.println("File downloaded successfully.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
