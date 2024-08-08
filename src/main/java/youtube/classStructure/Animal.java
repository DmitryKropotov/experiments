package youtube.classStructure;

public class Animal {
    public String name = "cat";
    public int age = 3;
    protected String x = "protected var";
    private int privateVar = 10;
    int defaultPackagePrivateVar = 12;

    public void say() {
//        System.out.println("I am an animal. My name is " + name + " I am " + age + " years old");
//        go();
//        System.out.println(x);

        System.out.println("privateVar is " + privateVar);
        privateMethod();

        System.out.println("defaultPackagePrivateVar is " + defaultPackagePrivateVar);
        defaultPackagePrivateMethod();
    }

    protected void go() {
        System.out.println("I am an animal. I can go");
    }

    private void privateMethod() {
        System.out.println("I am a private method in Animal");
    }

    void defaultPackagePrivateMethod() {
        System.out.println("I am default/pacjkage-private method in the class Animal");
    }
}
