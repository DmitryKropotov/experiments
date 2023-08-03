package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String args[]) throws Exception
    {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] receivedData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
            datagramSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("RECEIVED " + sentence);
        }
    }
}
