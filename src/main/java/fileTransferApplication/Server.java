package fileTransferApplication;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String [] args) {
        try
        {
            //initialize the Server Socket class
            ServerSocket serverSocket = new ServerSocket(9090);

            while(true)
            {
                //create client socket object
                Socket clientSocket = serverSocket.accept();
                //create and start client thread
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        }
        catch(IOException e)
        {
            System.out.println("Port 9090 is already opened! Please use another port.");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
