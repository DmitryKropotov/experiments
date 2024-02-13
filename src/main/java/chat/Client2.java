package chat;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        int portNumber = 80;
        ServerSocket scannerSocket = null;
        Socket socket = null;
        MyPrintWriter out;
        MyBufferedReader input;
        try  {
            scannerSocket = new ServerSocket(portNumber);
            System.out.println("scannerSocket is created");
            socket = scannerSocket.accept();
            System.out.println("socket is created");
            out = new MyPrintWriter(socket.getOutputStream(), true);
            input = new MyBufferedReader(new InputStreamReader(socket.getInputStream()));
            new Reader(input).start();
            new Writer(out, portNumber, socket.getLocalPort()).start();
            System.out.println("Client2 before while");
            while(!input.connectionClosed && !out.connectionClosed) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Connection is closed " + input.connectionClosed + " " + out.connectionClosed);
            }
            System.out.println("Client2 after while");
        } finally {
            System.out.println("finally block Client2");
            scannerSocket.close();
            socket.close();
        }
    }
}
