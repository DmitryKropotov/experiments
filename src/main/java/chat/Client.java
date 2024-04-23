package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws IOException {
        int portNumber = 90;
        final int CLIENT_LIMIT = 5;
        Map<Integer, Socket> allSockets= new HashMap();
        Map<Integer, Socket> currentSockets= new HashMap();
        ListOrderedSet partnerPorts = new ListOrderedSet();
        new AskingForClients(portNumber, allSockets, currentSockets, partnerPorts, CLIENT_LIMIT).start();
        new WaitingForClients(portNumber, allSockets, currentSockets, partnerPorts, CLIENT_LIMIT).start();
    }
}
