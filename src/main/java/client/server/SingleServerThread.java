package client.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleServerThread {

    public static void main(String[] args) {
	// write your code here
        int port = 90;
        //while (port<=65535) {
            Socket socket = null;
            try {
                String clientMessage;
                //ServerSocket scannerSocket = new ServerSocket(port);
                do {
                    ServerSocket scannerSocket = new ServerSocket(port);
                    System.out.println("Waiting for clients");
                    socket = scannerSocket.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello, client");
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    clientMessage = input.readLine();
                    System.out.println(clientMessage);
                    input.close();
                    out.close();
                    socket.close();
                    scannerSocket.close();
                } while (!clientMessage.equals("close connection"));
            } catch (IOException e) {
                System.out.println("Port " + port + " is opened");
            }
//            finally {
//                try {
//                    System.out.println("Socket is getting closed");
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //port++;
        //}
    }
}
