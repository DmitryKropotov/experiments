package chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
        while (true) {
            //ObjectOutputStream os = null;
            //try {
                //Socket s = new Socket("localhost", partnerPort);
                while(true) {
                    //os = new ObjectOutputStream(s.getOutputStream());
                    String outputMessage = sc.next();
                    System.out.println("A message has been read from console for chat " + outputMessage);
                    out.println(outputMessage);
                    System.out.println("The message has been sent " + outputMessage);
                    if (outputMessage.equals("bye")) {
                        System.out.println("bye is here");
                        out.connectionClosed = true;
                        break;
                    }
                }
//            } catch (IOException e) {
//                System.out.println(e);
//            } finally {
//                if (os != null) {
//                    try {
//                        os.close();
//                    } catch (IOException e) {
//                        System.out.println(e);
//                    }
//                }
//            }
        }
    }
}
