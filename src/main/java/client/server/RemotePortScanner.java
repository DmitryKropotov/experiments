package client.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class RemotePortScanner {

    public static void main(String[] args) {
        for (int i = 58295; i < 58310; i++) {
          scanPort(i);
        }
    }

    private static void scanPort(int portNumber) {
        try {
            Socket socket = new Socket("localhost", portNumber);
            System.out.println("Port " + portNumber + " is in listening/established");
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("Unknown host exception " + e);
        } catch (IOException e) {
            System.out.println("Port " + portNumber + " is not opened");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
