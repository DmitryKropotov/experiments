package chat;

import org.apache.commons.collections.set.ListOrderedSet;

import java.net.Socket;
import java.util.Scanner;

public class AskingForClients extends Thread {

    private int portNumber;
    private Socket[] socket;
    private Scanner sc = new Scanner(System.in);
    private ListOrderedSet partnerPorts = new ListOrderedSet();

    public AskingForClients(int portNumber, Socket[] socket) {
        this.portNumber = portNumber;
        this.socket = socket;
    }

    @Override
    public void run() {
        String partnerPort = null;
        while (true) {
            do {
                String menu = "0 - connect with new client\\" +
                        "1 - watch available clients";
                System.out.println(menu);
                String userCommand = sc.next();
                if (userCommand.equals("0")) {
                    connectWithNewClient();
                } else if(userCommand.equals("1")) {
                    chooseChatWithClient();
                }
            } while (!partnerPort.matches("partner port [1-9][0-9]*"));
        }
    }

    private void connectWithNewClient() {
        while(true) {
            System.out.println("Print number of port you want to connect or print back to return to main menu");
            String partnerPort = sc.next();
            if (partnerPort.equals("back")) {
                return;
            } else if (partnerPort.matches("[1-9][0-9]*")) {
                partnerPorts.add(Integer.parseInt(partnerPort));
                new ConnectionInstaller(portNumber, Integer.parseInt(partnerPort.substring(13)), socket).start();
                return;
            }
        }
    }

    private void chooseChatWithClient() {
        while(true) {
            StringBuilder menu = new StringBuilder("0 - return to main menu");
            for (int i = 0; i < partnerPorts.size(); i++) {
                menu.append(i + 1 + " - open chat with client on port " + partnerPorts.get(i));
            }
            System.out.println(menu);
            String partnerPort = sc.next();
            if (partnerPort.equals("0")) {
                return;
            } else if (partnerPort.matches("[1-9][0-9]*")) {
                int clientPort = Integer.parseInt(partnerPort.substring(13));
                if (partnerPorts.contains(clientPort)) {
                    new ConnectionInstaller(portNumber, clientPort, socket).start();
                } else {
                    System.out.println("there is no chat with " + clientPort);
                }
            }
        }
    }
}
