package chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Writer extends Thread {
    private MyPrintWriter out;
    private int myPortNumber;
    private int partnerPort;
    private Scanner sc = new Scanner(System.in);


    public Writer(MyPrintWriter out, int myPortNumber, int partnerPort) {
        this.out = out;
        this.myPortNumber = myPortNumber;
        this.partnerPort = partnerPort;
    }

    @Override
    public void run() {
        while (true) {
            ObjectOutputStream os = null;
            try {
                Socket s = new Socket("localhost", partnerPort);
                while(true) {
                    os = new ObjectOutputStream(s.getOutputStream());
                    String outputMessage = sc.next();
                    out.println(outputMessage);
                    if (outputMessage.equals("bye")) {
                        System.out.println("bye is here");
                        out.connectionClosed = true;
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }
}
