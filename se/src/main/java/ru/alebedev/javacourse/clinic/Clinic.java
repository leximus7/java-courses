package ru.alebedev.javacourse.clinic;

import java.util.HashMap;
import java.util.Map;

/**
 * Pet clinic
 * @Author Alexey Lebedev
 * @since 2017-08-03
 */
public class Clinic {

    private static final Clinic clinic = new Clinic();

    private final Map<String, Client> clients;

    private final Map<String, Pet> pets;

    public Clinic() {
        this.clients = new HashMap<>();
        this.pets = new HashMap<>();
    }

    public static Clinic getInstance() {
        return clinic;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public Map<String, Pet> getPets() {
        return pets;
    }

    public void addClient(Client client) {
        String clientName = client.getName();
        if (!clients.containsKey(clientName)) {
            clients.put(clientName, client);
        }
    }

    public void addClient(String clientName) {
        if ( !clients.containsKey(clientName) ) {
            clients.put(clientName, new Client(clientName));
        }
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void removeClient(String name) {
        clients.remove(name);

        //TO DO: add remove pets logic

    }

    public void addPet(Pet pet, Client client) {
        String petName = pet.getName();
        if ( !pets.containsKey(petName) && clients.containsKey(client.getName()) ) {
            pets.put(petName, pet);
            client.addPet(pet);
        }
    }

//    public void removePet(Pet pet) {
//        String petName = pet.getName();
//        if ( !pets.containsKey(petName) && clients.containsKey(client.getName()) ) {
//            pets.put(petName, pet);
//            client.addPet(pet);
//        }
//    }



}
