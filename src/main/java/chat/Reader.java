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
                    inputMessage = input.readLine();
                    System.out.println(inputMessage);
                } catch (IOException ignored) {}
            } while(!input.connectionClosed && (inputMessage == null || !inputMessage.equals("bye")));
            if (inputMessage.equals("bye")) {
                break;
            }
            System.out.println(inputMessage);
        }
        input.connectionClosed = true;
    }
}
