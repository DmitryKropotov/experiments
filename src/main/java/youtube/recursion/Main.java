package youtube.recursion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    private static int calculateFactorial(int n) {
        if(n>1) {
            return n*calculateFactorial(n);
        } else if(n<0) {
            return n;
        } else {
           return 1;
        }
    }

    private static int fibonaciRow(int n) {
        if(n<=1) {
            return n;
        }
        return fibonaciRow(n);
    }
}
