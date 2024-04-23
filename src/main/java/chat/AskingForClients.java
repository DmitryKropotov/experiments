package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class AskingForClients extends Thread {

    private int portNumber;
    private Map<Integer, Socket> allSockets;
    private Map<Integer, Socket> currentSockets;//amount is limited by CLIENT_LIMIT
    private final int CLIENT_LIMIT;
    private Scanner sc = new Scanner(System.in);
    private ListOrderedSet partnerPorts;

    public AskingForClients(int portNumber, Map<Integer, Socket> allSockets, Map<Integer, Socket> currentSockets,
                            ListOrderedSet partnerPorts, final int CLIENT_LIMIT) {
        this.portNumber = portNumber;
        this.allSockets = allSockets;
        this.currentSockets = currentSockets;
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
                new ConnectionInstaller(portNumber, Integer.parseInt(partnerPort), allSockets, currentSockets, partnerPorts, CLIENT_LIMIT).start();
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
                int clientPort = Integer.parseInt(partnerPort.substring(13));
                if (partnerPorts.contains(clientPort)) {
                    if (!currentSockets.containsKey(clientPort)) {
                        new ConnectionInstaller(portNumber, clientPort, allSockets, currentSockets, partnerPorts, CLIENT_LIMIT).start();
                    }
                } else {
                    System.out.println("there is no chat with " + clientPort);
                }
            }
        }
    }
}
