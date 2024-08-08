package chat;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Writer {
    private MyPrintWriter out;
    private int myPortNumber;
    private int partnerPort;
    private Scanner sc = new Scanner(System.in);


    public Writer(MyPrintWriter out, int myPortNumber, int partnerPort) {
        this.out = out;
        this.myPortNumber = myPortNumber;
        this.partnerPort = partnerPort;
    }

    public void write() {
        System.out.println("chat is going to be opened in writer " + out.chatOpened);
        out.chatOpened = new AtomicBoolean(true);
        System.out.println("chat is opened in writer " + out.chatOpened);
        while(true) {
               String outputMessage = sc.next();
               out.println(outputMessage);
               if (outputMessage.equals("bye")) {
                   out.chatOpened = new AtomicBoolean(false);
                   break;
               }
        }
    }
}
