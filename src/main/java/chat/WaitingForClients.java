package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class WaitingForClients extends Thread {

    private int portNumber;
    private Map<Integer, Socket> allSockets;
//    private Map<Integer, Socket> currentSockets;
//    Map<Integer, Socket> socketsPartnerPort;
//    Map<Socket, AtomicBoolean> socketAtomicBooleanMap;
//    ListOrderedSet partnerPorts;
    private final int CLIENT_LIMIT;

    private Map<Socket, InputOut> socketInputOut = new HashMap<>();

    public WaitingForClients(int portNumber, Map<Integer, Socket> allSockets, Map<Integer, Socket> currentSockets,
                             Map<Integer, Socket> socketsPartnerPort,  Map<Socket, AtomicBoolean> socketAtomicBooleanMap, ListOrderedSet partnerPorts, final int CLIENT_LIMIT) {
        this.portNumber = portNumber;
        this.allSockets = allSockets;
//        this.currentSockets = currentSockets;
//        this.socketsPartnerPort = socketsPartnerPort;
//        this.socketAtomicBooleanMap = socketAtomicBooleanMap;
//        this.partnerPorts = partnerPorts;
        this.CLIENT_LIMIT = CLIENT_LIMIT;
    }

    @Override
    public void run() {
        try  {
            ServerSocket scannerSocket = new ServerSocket(portNumber);
            MyPrintWriter out = null;
            MyBufferedReader input = null;
            while(true) {
                Socket currentSocket = scannerSocket.accept();//connection accepted
                if (currentSocket != null) {
//                    for (int i = 0; i < CLIENT_LIMIT; i++) {
//                        if(allSockets.get(i) == null) {
                    allSockets.put(currentSocket.getPort(), currentSocket);
//                            currentSockets.put(currentSocket.getPort(), currentSocket);
//                            partnerPorts.add(currentSocket.getPort());
//                            break;
//                        } else if(!allSockets.get(i).isConnected()) {
//                            Socket oldSocket = allSockets.get(i);
//                            oldSocket.bind(new InetSocketAddress(currentSocket.getPort()));
//                            currentSocket = oldSocket;
//                            partnerPorts.add(currentSocket.getPort());
//                            break;
//                        }
                    //}
                    AtomicBoolean connectionClosed = new AtomicBoolean(false);
//                    out = new MyPrintWriter(currentSocket.getOutputStream(), connectionClosed);
                    input = new MyBufferedReader(new InputStreamReader(currentSocket.getInputStream()), connectionClosed);
                    // new WaitingForClosingClients(out, input, currentSocket, currentSockets).start();
                    new Reader(input).start();
//                    new Writer(out, portNumber, currentSocket.getLocalPort()).start();
                }
            }
//                socketInputOut.put(currentSocket, new InputOut(input, out));
//
//                currentSockets.entrySet().forEach(portSocket -> {
//                    InputOut inputOut = socketInputOut.get(portSocket.getValue());
//                    if(inputOut.input.connectionClosed.get() || inputOut.out.connectionClosed.get()) {
//                        try {
//                            portSocket.getValue().close();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                        currentSockets.remove(portSocket.getKey());
//                    }
//                });
//            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private class InputOut {
        MyBufferedReader input;
        MyPrintWriter out;

        public InputOut(MyBufferedReader input, MyPrintWriter out) {
            this.out = out;
            this.input = input;
        }
    }
}
