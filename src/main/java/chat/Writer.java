package chat;

import java.util.Scanner;

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
          while(true) {
               String outputMessage = sc.next();
               out.println(outputMessage);
               if (outputMessage.equals("bye")) {
                   out.connectionClosed = true;
                   break;
               }
          }
    }
}
