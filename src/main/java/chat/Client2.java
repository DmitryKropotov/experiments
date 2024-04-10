package chat;

import java.io.IOException;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        int portNumber = 80;
        final int CLIENT_LIMIT = 5;
        Socket[] socket = new Socket[CLIENT_LIMIT];
        new AskingForClients(portNumber, socket).start();
        new WaitingForClients(portNumber, socket).start();
    }
}
