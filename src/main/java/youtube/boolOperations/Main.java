package youtube.boolOperations;

public class Main {

    public static void main(String[] args) {
        int x = 6;
        int y = 6;
        if(x>5 && y>5) {
            System.out.println("x is more than 5 AND y is less than 5");
        }
        if(x>5 || y<5) {
            System.out.println("x is more than 5 OR y is less than 5");
        }
    }

    private static boolean xIsMoreThanFive(int x) {
        System.out.println("xIsMoreThanFive function");
        return x>5;
    }

    private static boolean yIsLessThanFive(int y) {
        System.out.println("yIsLessThanFive function");
        return y<5;
    }
}
