package ru.alebedev.javacourse.clinic;

public class CatDog extends Animal {
    private Cat cat;
    private Dog dog;

    public CatDog(String name) {
        super(name);
        this.cat = new Cat("");
        this.dog = new Dog("");
    }

    public void makeSound() {
        cat.makeSound();
        dog.makeSound();
    }
}
