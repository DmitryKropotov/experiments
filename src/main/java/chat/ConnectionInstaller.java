package chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionInstaller extends Thread {

    private int portNumber;
    private Scanner sc = new Scanner(System.in);

    public ConnectionInstaller(int portNumber) {
        this.portNumber = portNumber;
    }

    @Override
    public void run() {
        String partnerPort;
        do {
            System.out.println("Your port number is " + portNumber + ". Print number of port you want to connect");
            partnerPort = sc.next();
        } while (!partnerPort.matches("[1-9][0-9]*"));
        Socket socket = null;
        try {
            socket = new Socket("localhost", Integer.parseInt(partnerPort));
            MyPrintWriter out = new MyPrintWriter(socket.getOutputStream(), true);
            MyBufferedReader input = new MyBufferedReader(new InputStreamReader(socket.getInputStream()));
            new Reader(input).start();
            new Writer(out, portNumber, Integer.parseInt(partnerPort)).start();
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
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
