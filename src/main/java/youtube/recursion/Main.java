package youtube.recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculateFactorial(3));
        System.out.println(maleHofstader(6));
        System.out.println(femaleHofstader(6));
    }

    private static int calculateFactorial(int n) {
        if(n<0) {
            return n;
        } else if(n==0 || n==1) {
            return 1;
            //return a;
        } else {
           int x = calculateFactorial(n-1);
           return x*n;
           //return calculateFactorial(n-1, a*n);
        }
    }

    //F(0) = 1; M(0) = 0
    //F(n)=n-M(F(n-1)), n>0
    //M(n)=n-F(M(n-1)), n>0
    private static int femaleHofstader(int n) {
        System.out.println("femaleHofstader n is " + n);
        if(n<0) {
            return n;
        } else {
            return n==0 ? 1: n - maleHofstader(femaleHofstader(n-1));
        }
    }

    private static int maleHofstader(int n) {
        System.out.println("maleHofstader n is " + n);
        if(n<0) {
            return n;
        } else {
            return n==0 ? 0: n - femaleHofstader(maleHofstader(n-1));
        }
    }
}
