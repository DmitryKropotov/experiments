package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String args[]) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            byte[] sendData = new byte[1024];   //store outgoing data.
            byte[] receiveData = new byte[1024];  //store incoming data
            //Amount of data = 65535 - 20 (IP Header) - 8 (UDP Header) = 65508

            InetAddress serverAddress = InetAddress.getByName("localhost");

            clientSocket.setSoTimeout(3000);
            String stringSendData = "Hello Server!";
            sendData = stringSendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9090);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            receiveData = receivePacket.getData();
            String stringReceiveData = new String(receiveData);
            System.out.println("FROM SERVER: " + stringReceiveData);
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
