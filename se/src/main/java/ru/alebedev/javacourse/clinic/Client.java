package ru.alebedev.javacourse.clinic;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private String name;
    private Map<String, Pet> pets;


    public Client(String name) {
        this.name = name;
        pets = new HashMap();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Client) {
            Client anotherClient = (Client) anObject;
            return this.getName().equals(anotherClient.getName()) &&
                    this.getPets().equals(anotherClient.getPets());
        }
        return false;
    }


    public void addPet(Pet pet) {
        pets.put(pet.getName(), pet);
    }

    public Map<String, Pet>  getPets() {
        return pets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void removePet(String petName) {
        pets.remove(petName);

    }
}
