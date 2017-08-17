package ru.alebedev.javacourse.clinic;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("myau");
    }

}
