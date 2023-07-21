package client.server;

import org.apache.commons.validator.routines.InetAddressValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ping {

    public static void main(String[] args) {
        //BufferedReader inputStream = null;
        try {
            InetAddress host = InetAddress.getByName("google.com");
            System.out.println(host.isReachable(1000));

//            Process p = Runtime.getRuntime().exec("port " + host);
//            inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//            String commandOutput = "";
//            while ((commandOutput = inputStream.readLine()) != null) {
//                System.out.println(commandOutput);
//                if(commandOutput.contains("Destination host unreachable")) {
//                    break;
//                }
//            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        InetAddressValidator inetAddressValidator = new InetAddressValidator();
        System.out.println(inetAddressValidator.isValid("128.0.0.4"));
        System.out.println(inetAddressValidator.isValid("128.0.259.4"));
    }
}
