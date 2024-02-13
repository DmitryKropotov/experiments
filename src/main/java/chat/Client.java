package chat;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        int portNumber = 90;
        new ConnectionInstaller(portNumber).start();
    }
}
