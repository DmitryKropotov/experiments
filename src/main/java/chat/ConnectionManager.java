package chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionManager extends Thread {

    Map<Integer, Socket> socketsPartnerPort;
    Map<Socket, AtomicBoolean> socketAtomicBooleanMap;

    Map<Integer, Socket> currentSockets;
    Map<Integer, Socket> allSockets;

    public ConnectionManager(Map<Integer, Socket> socketsPartnerPort,  Map<Socket, AtomicBoolean> socketAtomicBooleanMap,
                             Map<Integer, Socket> currentSockets, Map<Integer, Socket> allSockets) {
        this.socketsPartnerPort = socketsPartnerPort;
        this.socketAtomicBooleanMap = socketAtomicBooleanMap;

        this.currentSockets = currentSockets;
        this.allSockets = allSockets;
    }

    @Override
    public void run() {
        /*socketAtomicBooleanMap.forEach((Socket socket, AtomicBoolean connectionClosed) -> {
            while (!connectionClosed) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    System.out.println("Connection with " + index + " failed " + e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                            socketsPartnerPort.remove(index);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                    }
                }
            }
        });*/
    }
}
