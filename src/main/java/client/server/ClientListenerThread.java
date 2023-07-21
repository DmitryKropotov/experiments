package client.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientListenerThread extends Thread {

    private  Socket socket;
    private int threadNumber;
    private static AtomicInteger threadAmounts = new AtomicInteger(0);

    public ClientListenerThread(Socket socket) {
        threadNumber = threadAmounts.getAndIncrement();
        this.socket = socket;
        Thread.currentThread().setName("thread " + threadNumber);
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is started");
        try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello, client");
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientMessage = input.readLine();
                System.out.println(clientMessage + " in thread " + Thread.currentThread().getName());
                input.close();
                out.close();
                socket.close();
        } catch (IOException e) {
            System.out.println("IOException in thread " + Thread.currentThread().getName() + " is catched");
        }
    }
}
