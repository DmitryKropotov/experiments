package youtube.classStructure.anotherPackage;

import youtube.classStructure.Animal;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("I am an animal in the same package. My name is " + animal.name + " I am " + animal.age + " years oid");
        animal.say();
//        System.out.println(animal.x);
//        animal.go();
//        System.out.println("privateVar in the class Animal is " + privateVar);
//        animal.privateMethod();
//        System.out.println("defaultPackagePrivateVar in the class Animal is " + animal.defaultPackagePrivateVar);
//        animal.defaultPackagePrivateMethod();

        Dog dog = new Dog();
        dog.dogSays();
//        System.out.println(dog.x);
//        dog.go();
//        System.out.println("privateVar in the class Animal calling on object of class Cat is " + privateVar);
//        animal.privateMethod();
//        System.out.println("privateVar in the class Animal calling on object of class Cat is " + dog.defaultPackagePrivateVar);
//        dog.defaultPackagePrivateMethod();
    }
}
