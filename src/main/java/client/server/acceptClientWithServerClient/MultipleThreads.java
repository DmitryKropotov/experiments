package client.server.acceptClientWithServerClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultipleThreads {

    public static void main(String[] args) throws IOException {
        try (ServerSocket scannerSocket = new ServerSocket(90)) {
            while (true) {
                System.out.println("Waiting for clients");
                Socket socket = scannerSocket.accept();
                new ClientListenerThread(socket).start();
            }
        }
    }
}
