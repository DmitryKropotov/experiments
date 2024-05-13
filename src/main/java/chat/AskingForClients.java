package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class AskingForClients extends Thread {

    private int portNumber;
    private Map<Integer, Socket> allSockets;
    private Map<Integer, Socket> currentSockets;//amount is limited by CLIENT_LIMIT
    Map<Integer, Socket> socketsPartnerPort;
    private final int CLIENT_LIMIT;
    private Scanner sc = new Scanner(System.in);
    private ListOrderedSet partnerPorts;

    public AskingForClients(int portNumber, Map<Integer, Socket> allSockets, Map<Integer, Socket> currentSockets,
                            Map<Integer, Socket> socketsPartnerPort, ListOrderedSet partnerPorts, final int CLIENT_LIMIT) {
        this.portNumber = portNumber;
        this.allSockets = allSockets;
        this.currentSockets = currentSockets;
        this.socketsPartnerPort = socketsPartnerPort;
        this.partnerPorts = partnerPorts;
        this.CLIENT_LIMIT = CLIENT_LIMIT;
    }

    @Override
    public void run() {
        while (true) {
            String menu = "0 - connect with new client " +
                    "1 - watch available clients";
            System.out.println(menu);
            String userCommand = sc.next();
            if (userCommand.equals("0")) {
                 connectWithNewClient();
            } else if(userCommand.equals("1")) {
                 chooseChatWithClient();
            }
        }
    }

    private void connectWithNewClient() {
        while(true) {
            System.out.println("Print number of port you want to connect or print back to return to main menu");
            String partnerPort = sc.next();
            if (partnerPort.equals("back")) {
                return;
            } else if (partnerPort.matches("[1-9][0-9]*")) {
                try {
                    installConnection(Integer.parseInt(partnerPort));
                } catch (IOException e) {
                    System.out.println(e);
                    return;
                }
                openChatWithClient(socketsPartnerPort.get(Integer.parseInt(partnerPort)), Integer.parseInt(partnerPort));
                return;
            }
        }
    }

    private void chooseChatWithClient() {
        while(true) {
            StringBuilder menu = new StringBuilder("0 - return to main menu");
            for (int i = 0; i < partnerPorts.size(); i++) {
                menu.append(" " + (i + 1) + " - open chat with client on port " + partnerPorts.get(i));
            }
            System.out.println(menu);
            String partnerPort = sc.next();
            if (partnerPort.equals("0")) {
                return;
            } else if (partnerPort.matches("[1-9][0-9]*")) {
                int clientPort = Integer.parseInt(partnerPort);
                if (partnerPorts.contains(clientPort)) {
                    if (!currentSockets.containsKey(clientPort)) {
                        try {
                            installConnection(Integer.parseInt(partnerPort));
                        } catch (IOException e) {
                            System.out.println(e);
                            continue;
                        }
                        openChatWithClient(allSockets.get(portNumber), Integer.parseInt(partnerPort));
                    }
                } else {
                    System.out.println("there is no chat with " + clientPort);
                }
            }
        }
    }

    private void installConnection(int partnerPort) throws IOException {
        Socket newSocket = null;
        int indexOfNewSocket = 0;
            newSocket = new Socket("127.0.0.1", partnerPort);
            int i = 0;
            while (true) {
                if(allSockets.get(i) == null) {
                    allSockets.put(i, newSocket);
                    currentSockets.put(i, newSocket);
                    partnerPorts.add(partnerPort);
                    socketsPartnerPort.put(partnerPort, newSocket);
                    break;
                } else if(!allSockets.get(i).isConnected()) {
                    Socket oldSocket = allSockets.get(i);
                    oldSocket.bind(new InetSocketAddress(partnerPort));
                    newSocket = oldSocket;
                    partnerPorts.add(partnerPort);
                    socketsPartnerPort.put(partnerPort, newSocket);
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

    private void openChatWithClient(Socket socket, int partnerPort) {
        MyPrintWriter out = null;
        try {
            out = new MyPrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Writer(out, portNumber, partnerPort).write();
    }
}
