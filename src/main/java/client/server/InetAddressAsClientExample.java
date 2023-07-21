package client.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAddressAsClientExample {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getAddress());
        System.out.println(inetAddress.getHostAddress());
        InetAddress inetAddress2 = InetAddress.getByName("google.com");
        System.out.println(inetAddress2.getHostName());
        System.out.println(inetAddress2.getAddress());
        System.out.println(inetAddress2.getHostAddress());

        try {
            Socket socket = new Socket(inetAddress, 90);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = input.readLine();
            System.out.println(clientMessage);
            out.println("Hello, server");
            input.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
