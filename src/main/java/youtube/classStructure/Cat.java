package youtube.classStructure;

public class Cat extends Animal {
    public void catSays() {
        System.out.println("I am a cat. My name is " + name + ". I am " + age + " years old");
        System.out.println(x);
        go();
//        System.out.println("privateVar from ancestor is " + privateVar);
//        privateMethod();
        System.out.println("defaultPackagePrivateVar from ancestor is " + defaultPackagePrivateVar);
        defaultPackagePrivateMethod();
    }
}
