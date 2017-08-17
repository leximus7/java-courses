package ru.alebedev.javacourse.clinic;

import ru.alebedev.javacourse.clinic.Cat;
import ru.alebedev.javacourse.clinic.Dog;

public class Temp {

    public static void main(String[] args) {
        Cat cat1 = new Cat("pushok");
        Cat cat2 = new Cat("pushok");

        Dog dog1 = new Dog("pushok");

        System.out.println(cat1.equals(cat2));
        System.out.println(cat1.equals(dog1));

        System.out.println("cat1 hashcode " + cat1.hashCode());
        System.out.println("cat2 hashcode " + cat1.hashCode());
        System.out.println("dog1 hashcode " + dog1.hashCode());

        System.out.println(cat1.getClass().hashCode());
        System.out.println(cat2.getClass());
        System.out.println(dog1.getClass().hashCode());





    }



}
