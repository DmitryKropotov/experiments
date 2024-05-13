package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

public class ConnectionInstaller extends Thread {

    private int portNumber;
    private int partnerPort;
    private final int CLIENT_LIMIT;
    private Map<Integer, Socket> allSockets;
    private Map<Integer, Socket> currentSockets;
    private ListOrderedSet partnerPorts;

    public ConnectionInstaller(int portNumber, int partnerPort, Map<Integer, Socket> allSockets, Map<Integer, Socket> currentSockets,
                               ListOrderedSet partnerPorts, final int CLIENT_LIMIT) {
        this.portNumber = portNumber;
        this.partnerPort = partnerPort;
        this.allSockets = allSockets;
        this.currentSockets = currentSockets;
        this.partnerPorts = partnerPorts;
        this.CLIENT_LIMIT = CLIENT_LIMIT;
    }

    @Override
    public void run() {
        Socket newSocket = null;
        int indexOfNewSocket = 0;
        try {
            newSocket = new Socket("127.0.0.1", partnerPort);
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//           newSocket = new Socket("localhost", partnerPort, Inet4Address.getByName("localhost"), portNumber);//connection installed
            int i = 0;
            while (true) {
                if(allSockets.get(i) == null) {
                    allSockets.put(i, newSocket);
                    currentSockets.put(i, newSocket);
                    partnerPorts.add(partnerPort);
                    break;
                } else if(!allSockets.get(i).isConnected()) {
                    Socket oldSocket = allSockets.get(i);
                    oldSocket.bind(new InetSocketAddress(partnerPort));
                    newSocket = oldSocket;
                    partnerPorts.add(partnerPort);
                    break;
                }
                i++;
                if(i>=CLIENT_LIMIT) {
                    i=0;
                }
            }
            currentSockets.put(i, newSocket);
            indexOfNewSocket = i;
            MyPrintWriter out = new MyPrintWriter(newSocket.getOutputStream(), true);
            MyBufferedReader input = new MyBufferedReader(new InputStreamReader(newSocket.getInputStream()), false);
            new Reader(input).start();
            //new Writer(out, portNumber, partnerPort).start();
//            while(!input.connectionClosed && !out.connectionClosed) {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        } catch (IOException e) {
            System.out.println("Connection with " + partnerPort + " failed " + e);
        } finally {
//            if(newSocket != null) {
//                try {
//                    newSocket.close();
//                    currentSockets.remove(indexOfNewSocket);
//                } catch (IOException e) {
//                    System.out.println(e);
//                }
//            }
        }
    }
}
