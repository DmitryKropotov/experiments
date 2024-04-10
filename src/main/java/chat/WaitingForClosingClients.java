package chat;

import java.io.IOException;
import java.net.Socket;

public class WaitingForClosingClients extends Thread {

    private MyPrintWriter out;
    private MyBufferedReader input;
    private Socket socket;

    public WaitingForClosingClients(MyPrintWriter out, MyBufferedReader input, Socket socket) {
        this.out = out;
        this.input = input;
        this.socket = socket;
    }

    @Override
    public void run() {
        while(!input.connectionClosed && !out.connectionClosed) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Connection is closed " + input.connectionClosed + " " + out.connectionClosed);
        }
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
