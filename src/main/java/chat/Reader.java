package chat;

import java.io.IOException;

public class Reader extends Thread {
    private MyBufferedReader input;

    public Reader(MyBufferedReader input) {
        this.input = input;
    }

    @Override
    public void run() {
        while (true) {
            String inputMessage = null;
            do {
                try {
                    System.out.println("A message is going to be read");
                    inputMessage = input.readLine();
                    System.out.println("A message is read. It is " + inputMessage);
                } catch (IOException ignored) {}
            } while(!input.connectionClosed && inputMessage == null);
            System.out.println("Reader after first while");
            if (inputMessage.equals("bye")) {
                System.out.println("bye is here");
                break;
            }
            System.out.println(inputMessage);
        }
        input.connectionClosed = true;
    }
}
