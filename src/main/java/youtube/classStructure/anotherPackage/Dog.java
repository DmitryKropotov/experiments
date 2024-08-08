package youtube.classStructure.anotherPackage;
import youtube.classStructure.Animal;

public class Dog extends Animal {
    public void dogSays() {
        System.out.println("I am a dog. My name is " + name + ". I am " + age + " years old");
        System.out.println(x);
        go();
//        System.out.println("privateVar from ancestor is " + privateVar);
//        privateMethod();
//        System.out.println("defaultPackagePrivateVar from ancestor is " + defaultPackagePrivateVar);
//        defaultPackagePrivateMethod();
    }
}
