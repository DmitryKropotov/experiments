package chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

public class WaitingForClosingClients extends Thread {

    private MyPrintWriter out;
    private MyBufferedReader input;
    private Socket socket;
    private Map<Integer, Socket> currentSockets;

    public WaitingForClosingClients(MyPrintWriter out, MyBufferedReader input, Socket socket, Map<Integer, Socket> currentSockets) {
        this.out = out;
        this.input = input;
        this.socket = socket;
        this.currentSockets = currentSockets;
    }

    @Override
    public void run() {
        while(!input.connectionClosed.get() && !out.connectionClosed.get()) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Connection is closed " + input.connectionClosed + " " + out.connectionClosed);
        }
        if(socket != null) {
            try {
                socket.close();
                currentSockets.remove(socket.getPort());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
