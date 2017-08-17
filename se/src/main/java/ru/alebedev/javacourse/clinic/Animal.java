package ru.alebedev.javacourse.clinic;

public abstract class Animal implements Pet {

    private String name;

    public Animal(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + this.getClass().hashCode();
        return result;
    }


    @Override
    public void makeSound() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
