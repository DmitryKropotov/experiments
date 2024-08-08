package youtube.switchCase;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<10; i++) {
            String command = sc.next();
            if(command.equals("cont")) {
                continue;
            }
            if(command.equals("finish")) {
                break;
            }
            while (!command.equals("go furher " + i)) {
                System.out.println("Wrong code");
            }
        }
    }
}
