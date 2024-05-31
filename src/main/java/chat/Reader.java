package chat;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Reader extends Thread {
    private MyBufferedReader input;

    public Reader(MyBufferedReader input) {
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("run in Reader started");
        while (true) {
            String inputMessage = null;
            do {
                try {
                    inputMessage = input.readLine();
                    System.out.println(inputMessage);
                } catch (IOException ignored) {}
            } while(!input.connectionClosed.get() && (inputMessage == null || !inputMessage.equals("bye")));
        }
//        input.connectionClosed = new AtomicBoolean(true);
//        System.out.println("run in Reader finished");
    }
}
