package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client2 {
    public static void main(String[] args) throws IOException {
        int portNumber = 80;
        final int CLIENT_LIMIT = 5;
        Map<Integer, Socket> allSockets= new HashMap();
        Map<Integer, Socket> currentSockets= new HashMap();
        Map<Integer, Socket> socketsPartnerPort= new HashMap();
        Map<Socket, AtomicBoolean> socketAtomicBooleanMap = new HashMap();
        ListOrderedSet partnerPorts = new ListOrderedSet();

        Map<Socket, AtomicBoolean> chatWithClientsOpened = new HashMap<>();
        Map<Socket, AtomicBoolean> connectionWithClientsClosed = new HashMap<>();
        new AskingForClients(portNumber, allSockets, currentSockets, socketsPartnerPort, socketAtomicBooleanMap, partnerPorts,
                chatWithClientsOpened, connectionWithClientsClosed, CLIENT_LIMIT).start();
        new WaitingForClients(portNumber, allSockets, currentSockets, socketsPartnerPort, socketAtomicBooleanMap, partnerPorts,
                chatWithClientsOpened, connectionWithClientsClosed, CLIENT_LIMIT).start();
    }
}
