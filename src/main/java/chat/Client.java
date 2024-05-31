package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client {
    public static void main(String[] args) throws IOException {
        int portNumber = 70;
        final int CLIENT_LIMIT = 5;
        Map<Integer, Socket> allSockets= new HashMap();
        Map<Integer, Socket> currentSockets= new HashMap();
        Map<Integer, Socket> socketsPartnerPort= new HashMap();
        Map<Socket, AtomicBoolean> socketAtomicBooleanMap = new HashMap();
        ListOrderedSet partnerPorts = new ListOrderedSet();
        new AskingForClients(portNumber, allSockets, currentSockets, socketsPartnerPort, socketAtomicBooleanMap, partnerPorts, CLIENT_LIMIT).start();
        new WaitingForClients(portNumber, allSockets, currentSockets, socketsPartnerPort, socketAtomicBooleanMap, partnerPorts, CLIENT_LIMIT).start();
        new ConnectionManager(socketsPartnerPort, socketAtomicBooleanMap,
                currentSockets, allSockets);
    }

//            while(!input.connectionClosed && !out.connectionClosed) {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Connection with " + partnerPort + " failed " + e);
//        } finally {
//            if(newSocket != null) {
//                try {
//                    newSocket.close();
//                    currentSockets.remove(indexOfNewSocket);
//                } catch (IOException e) {
//                    System.out.println(e);
//                }
//            }
//        }
}
