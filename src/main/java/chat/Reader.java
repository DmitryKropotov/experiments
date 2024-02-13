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
            try {
                String inputMessage = null;
                do {
                    inputMessage = input.readLine();
                } while(!input.connectionClosed && inputMessage == null);
                if (inputMessage.equals("bye")) {
                    System.out.println("bye is here");
                    break;
                }
                System.out.println(inputMessage);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        input.connectionClosed = true;
    }
}
