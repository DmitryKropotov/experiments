package chat;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class WaitingForClients extends Thread {

    private int portNumber;
    private Socket[] socket;
    private int CLIENT_LIMIT = 5;
    int connectedClients = 0;

    public WaitingForClients(int portNumber, Socket[] socket) {
        this.portNumber = portNumber;
        this.socket = socket;
    }

    @Override
    public void run() {
        try  {
            ServerSocket scannerSocket = new ServerSocket(portNumber);
            MyPrintWriter out = null;
            MyBufferedReader input = null;
            while(true) {
                Socket currentSocket = null;
                while(currentSocket == null) {
                    for (int i = 0; i < CLIENT_LIMIT; i++) {
                        if(socket[i] == null || !socket[i].isConnected()) {
                            socket[i] = scannerSocket.accept();
                            currentSocket = socket[i];
                        }
                    }
                }
                new WaitingForClosingClients(out, input, currentSocket).start();
                connectedClients++;
                System.out.println("socket is created");
                out = new MyPrintWriter(currentSocket.getOutputStream(), true);
                input = new MyBufferedReader(new InputStreamReader(currentSocket.getInputStream()));
                new Reader(input).start();
                new Writer(out, portNumber, currentSocket.getLocalPort()).start();
                System.out.println("Client2 before while");
                System.out.println("Client2 after while");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
