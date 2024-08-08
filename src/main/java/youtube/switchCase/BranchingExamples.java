package youtube.switchCase;

public class BranchingExamples {
    public static void main(String[] args) {
        int x = (int) (100 * Math.random());
        int y = (int) (100 * Math.random());
        if (x < 50 && y < 50) {
            System.out.println("first branch");
        } else if (x > 60 && y > 70) {
            System.out.println("second branch");
        } else if (x>50 && y>55) {
            System.out.println("third branch");
        } else {
            System.out.println("last branch");
        }

        switch(x) {
            case 10:
                System.out.println("x is ten");
                break;
            case 12:
                System.out.println("x is twelve");
                break;
            case 20:
                System.out.println("x is twenty");
                break;
            default:
                System.out.println("other value");
        }

        System.out.println(x < 30 ? "We won a price" : "We lost");
    }
}
