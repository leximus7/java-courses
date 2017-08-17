package ru.alebedev.javacourse.clinic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import ru.alebedev.javacourse.clinic.*;

import java.util.HashMap;
import java.util.Map;

public class ClinicTest {
    private Clinic clinic;
    private Client john;
    private Client mike;
    private Map<String, Client> clients;
    private Map<String, Pet> pets;
    private Cat pushok;
    private Dog reks;
    private Dog tuzik;

    @Before
    public void setUp() {
        this.clinic = new Clinic();
        this.john = new Client("John");
        this.mike = new Client("Mike");
        this.clients = new HashMap();
        this.pets = new HashMap();
        this.pushok = new Cat("Pushok");
        this.reks = new Dog("Reks");
        this.tuzik = new Dog("Tuzik");
    }

    @Test
    public void testAddClientObject(){
        clinic.addClient(john);
        clients.put("John", john);
        assertEquals( clients, clinic.getClients());
    }

    @Test
    public void testAddTwoClientObjects(){
        clinic.addClient(john);
        clinic.addClient(mike);
        clients.put("Mike", mike);
        clients.put("John", john);
        assertEquals( clients, clinic.getClients());
    }


    @Test
    public void testAddTwoClientsString(){
        clinic.addClient("John");
        clinic.addClient("Mike");
        clients.put("John", john);
        clients.put("Mike", mike);
        assertEquals( clients, clinic.getClients());
    }

    @Test
    public void testAddExistingClient(){
        clinic.addClient(john);
        clinic.addClient(john);
        clients.put("John", john);
        assertEquals(clients, clinic.getClients());
    }

    @Test
    public void testAddPet(){
        clinic.addClient(john);
        clinic.addPet(pushok, john);
        clients.put("John", john);
        pets.put("Pushok", pushok);
        assertEquals(clients, clinic.getClients());
        assertEquals(pets, clinic.getPets());
    }

    @Test
    public void testAddTwoClientsThreePets(){
        clinic.addClient(john);
        clinic.addClient(mike);
        clinic.addPet(pushok, john);
        clinic.addPet(reks, mike);
        clinic.addPet(tuzik, john);

        clients.put("John", john);
        clients.put("Mike", mike);
        pets.put("Pushok", pushok);
        pets.put("Reks", reks);
        pets.put("Tuzik", tuzik);
        john.addPet(tuzik);
        john.addPet(pushok);
        mike.addPet(reks);

        assertEquals(clients, clinic.getClients());
        assertEquals(pets, clinic.getPets());
    }

    @Test
    public void testRemoveClientByName() {
        clinic.addClient(john);
        clinic.addClient(mike);
        clinic.removeClient("John");

        clients.put("Mike", mike);

        assertEquals(clients, clinic.getClients());
    }

}