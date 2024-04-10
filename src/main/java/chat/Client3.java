package chat;

import java.io.IOException;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) throws IOException {
        int portNumber = 70;
        final int CLIENT_LIMIT = 5;
        Socket[] socket = new Socket[CLIENT_LIMIT];
        new AskingForClients(portNumber, socket).start();
        new WaitingForClients(portNumber, socket).start();
    }
}
