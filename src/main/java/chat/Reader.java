package chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader extends Thread {
    private MyBufferedReader input;
    private List<String> bufferedMessages = new ArrayList();

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
                    if(!bufferedMessages.isEmpty() && input.chatOpened.get()) {
                        bufferedMessages.forEach(System.out::println);
                    }
                    inputMessage = input.readLine();
                    if(!input.chatOpened.get()) {
                        bufferedMessages.add(inputMessage);
                    } else {
                        System.out.println(inputMessage);
                    }
                } catch (IOException ignored) {}
            } while(!input.connectionClosed.get() && (inputMessage == null || !inputMessage.equals("bye")));
            System.out.println("while in Reader ended iteration");
        }
//        input.connectionClosed = new AtomicBoolean(true);
    }
}
