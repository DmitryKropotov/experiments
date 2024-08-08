package youtube.loops;

public class Main {
    public static void main(String[] args) {
        int x = (int)(100*Math.random());
        while(x>50) {
          System.out.println("x1 is " + x);
            x = (int)(100*Math.random());
        }
        do {
            x = (int)(100*Math.random());
            System.out.println("x2 is " + x);
        } while(x>50);
    }
}
