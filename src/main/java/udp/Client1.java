package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client1 {
    public static void main(String args[]) throws IOException, InterruptedException {
        DatagramSocket clientSocket = new DatagramSocket(0);
        InetAddress inetAddress =  InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];

        boolean stop = false;
        long count = 0;
        while (!stop) {
            String stringSendData = "Client 1 text message " + count++;
            sendData = stringSendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, inetAddress, 9090);
            clientSocket.send(sendPacket);
            Thread.sleep(3000);
        }
        clientSocket.close();

    }
}
