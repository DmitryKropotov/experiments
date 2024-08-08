package youtube.classStructure;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("I am an animal in the same package. My name is " + animal.name + " I am " + animal.age + " years oid");
        animal.say();
        System.out.println(animal.x);
        animal.go();
//        System.out.println("privateVar in the class Animal is " + privateVar);
//        animal.privateMethod();
        System.out.println("defaultPackagePrivateVar in the class Animal is " + animal.defaultPackagePrivateVar);
        animal.defaultPackagePrivateMethod();

        Cat cat = new Cat();
        cat.catSays();
        System.out.println(cat.x);
        cat.go();
//        System.out.println("privateVar in the class Animal calling on object of class Cat is " + privateVar);
//        cat.privateMethod();
        System.out.println("privateVar in the class Animal calling on object of class Cat is " + animal.defaultPackagePrivateVar);
        cat.defaultPackagePrivateMethod();
    }
}
