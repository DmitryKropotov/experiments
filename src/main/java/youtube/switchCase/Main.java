package youtube.switchCase;

public class Main {
    public static void main(String[] args) {
        int apples = 11;
        System.out.println("Mary: how many apples do you have?");
        //switch (apples) {
            //case 0:
        System.out.println("John: I have" + (apples==0 ? " no apples": apples == 1? " an apple": apples<10? " " + apples + " apples": " many apples"));
//            break;
//            case 1:
//            System.out.println("John: I have an apple");
//            break;
//            case 2, 3, 4, 5, 6, 7, 8, 9:
//            System.out.println("John: I have " + apples + " apples");
//            break;
//            default:
//            System.out.println("John: I have many apples");
//        }
    }
}
