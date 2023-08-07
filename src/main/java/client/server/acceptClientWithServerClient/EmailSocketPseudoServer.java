package client.server.acceptClientWithServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EmailSocketPseudoServer {
    public static void main(String[] args) {
        // write your code here
        int port = 90;
        //while (port<=65535) {
        ServerSocket scannerSocket = null;
        Socket socket = null;
        BufferedReader input = null;
        PrintWriter out = null;
        try {
            scannerSocket = new ServerSocket(port);
            System.out.println("Waiting for clients");
            socket = scannerSocket.accept();
            out = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            out.println("Hello, client220");
            String clientMessage;

            System.out.println("step 1");
            readingLine(out, input, "Hello, client220");

            System.out.println("step 2");

            readingLine(out, input, "Hello, client250");

            System.out.println("step 3");

            readingLine(out, input, "Hello, client250");

            System.out.println("step 4");

            readingLine(out, input, "Hello, client250");

            System.out.println("step 5");

            readingLine(out, input, "Hello, client354");

            System.out.println("step 6");

            readingManyLines(out, input, "Hello, client250");

            System.out.println("step 7");

            readingLine(out, input, "Hello, client221");


        } catch (IOException e) {
            System.out.println("Port " + port + " is opened");
        }
        finally {
            System.out.println("Socket is getting closed");
            try {
                input.close();
                out.close();
                socket.close();
                scannerSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //port++;
        //}
    }

    private static void readingLine(PrintWriter out, BufferedReader input, String messageToClient) throws IOException {
        out.println(messageToClient);

        //System.out.println("reading line from client");
        String clientMessage = input.readLine();
        System.out.println(clientMessage);
    }

    private static void readingManyLines(PrintWriter out, BufferedReader input, String messageToClient) throws IOException {
        out.println(messageToClient);
        String clientMessage;

        do {
            //System.out.println("reading line from client");
            clientMessage = input.readLine();
            System.out.println(clientMessage);
        } while (!clientMessage.equals("."));
    }
}
