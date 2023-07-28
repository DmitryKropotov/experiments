package youtube.boolOperations;

public class Main {

    public static void main(String[] args) {
        int x1 = 6;
        int y1 = 6;
        if(xIsMoreThanFive(x1) && yIsMoreThanFive(y1)) {
            System.out.println("x1 is more than 5 AND y1 is more than 5");
        }
        System.out.println("--------");
        if(xIsMoreThanFive(x1) || yIsMoreThanFive(y1)) {
            System.out.println("x1 is more than 5 OR y1 is more than 5");
        }

        System.out.println("-------------------------");

        int x2 = 4;
        int y2 = 6;
        if(xIsMoreThanFive(x2) && yIsMoreThanFive(y2)) {
            System.out.println("x2 is more than 5 AND y2 is more than 5");
        }
        System.out.println("--------");
        if(xIsMoreThanFive(x2) || yIsMoreThanFive(y2)) {
            System.out.println("x2 is more than 5 OR y2 is more than 5");
        }

        System.out.println("-------------------------");

        int x3 = 6;
        int y3 = 4;
        if(xIsMoreThanFive(x3) && yIsMoreThanFive(y3)) {
            System.out.println("x3 is more than 5 AND y3 is more than 5");
        }
        System.out.println("--------");
        if(xIsMoreThanFive(x3) || yIsMoreThanFive(y3)) {
            System.out.println("x3 is more than 5 OR y3 is more than 5");
        }

        System.out.println("-------------------------");

        int x4 = 4;
        int y4 = 4;
        if(xIsMoreThanFive(x4) && yIsMoreThanFive(y4)) {
            System.out.println("x4 is more than 5 AND y4 is more than 5");
        }
        System.out.println("--------");
        if(xIsMoreThanFive(x4) || yIsMoreThanFive(y4)) {
            System.out.println("x4 is more than 5 OR y4 is more than 5");
        }
    }

    private static boolean xIsMoreThanFive(int x) {
        System.out.println("xIsMoreThanFive function");
        return x>5;
    }

    private static boolean yIsMoreThanFive(int y) {
        System.out.println("yIsMoreThanFive function");
        return y>5;
    }
}

// condition1 condition2   condition1 && condition2  condition1 || condition2
// true(1)    true(1)      true(1)(1*1=1)            true(1)(1+1=1)
// true(1)    false(0)     false(0)(1*0=0)           true(1)(1+0=1)
// false(0)   true(1)      false(0)(0*1=0)           true(1)(0+1=1)
// false(0)   false(0)     false(0)(0*0=0)           false(0)(0+0=0)