package ru.alebedev.javacourse.clinic;

import org.junit.Before;
import org.junit.Test;
import ru.alebedev.javacourse.clinic.Cat;
import ru.alebedev.javacourse.clinic.Client;
import ru.alebedev.javacourse.clinic.Dog;
import ru.alebedev.javacourse.clinic.Pet;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ClientTest {
    private Client john;
    private Cat pushok;
    private Dog reks;
    private Dog tuzik;
    private Map<String, Pet> pets;

    @Before
    public void setUp() {
        this.john = new Client("John");
        this.pushok = new Cat("Pushok");
        this.reks = new Dog("Reks");
        this.tuzik = new Dog("Tuzik");
        this.pets = new HashMap<>();
    }

    @Test
    public void testClientName() {
        assertEquals("John", john.getName());
    }

    @Test
    public void testClientSetName() {
        john.setName("Mike");
        assertEquals("Mike", john.getName());
    }

    @Test
    public void testClientAddPet() {
        john.addPet(pushok);
        pets.put("Pushok", pushok);
        assertEquals(pets, john.getPets());
    }

    @Test
    public void testClientAddTwoPets() {
        john.addPet(pushok);
        john.addPet(reks);
        pets.put("Reks", reks);
        pets.put("Pushok", pushok);
        assertEquals(pets, john.getPets());
    }

    @Test
    public void testClientRemovePet() {
        john.addPet(pushok);
        john.addPet(reks);
        john.addPet(tuzik);
        john.removePet("Reks");
        pets.put("Tuzik", tuzik);
        pets.put("Pushok", pushok);
        assertEquals(pets, john.getPets());
    }


}