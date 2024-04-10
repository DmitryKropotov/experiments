package chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionInstaller extends Thread {

    private int portNumber;
    private int partnerPort;
    private Socket[] socket;
    private Scanner sc = new Scanner(System.in);

    private final int CLIENT_LIMIT = 5;

    public ConnectionInstaller(int portNumber, int partnerPort, Socket[] socket) {
        this.portNumber = portNumber;
        this.partnerPort = partnerPort;
        this.socket = socket;
    }

    @Override
    public void run() {
        Socket newSocket = null;
        try {
            newSocket = new Socket("localhost", partnerPort);
            int i = 0;
            while (true) {
                if(socket[i] == null || !socket[i].isConnected()) {
                    socket[i] = newSocket;
                    break;
                }
                i++;
                if(i>=CLIENT_LIMIT) {
                    i=0;
                }
            }
            MyPrintWriter out = new MyPrintWriter(newSocket.getOutputStream(), true);
            MyBufferedReader input = new MyBufferedReader(new InputStreamReader(newSocket.getInputStream()));
            new Reader(input).start();
            new Writer(out, portNumber, partnerPort).start();
            while(!input.connectionClosed && !out.connectionClosed) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                newSocket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
