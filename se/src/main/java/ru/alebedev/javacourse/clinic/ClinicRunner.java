package ru.alebedev.javacourse.clinic;

/**
 *
 */
public class ClinicRunner {

    public static void main(String[] args) {
        Clinic clinic = Clinic.getInstance();

        Client john = new Client("John");
        Client oleg = new Client("Oleg");
        Client masha = new Client("Masha");

        clinic.addClient(john);
        clinic.addClient(oleg);
        clinic.addClient(masha);

        clinic.addPet(new Cat("barsik"), john);
        clinic.addPet(new Dog("reks"), oleg);
        clinic.addPet(new Cat("pushok"), john);
        clinic.addPet(new Dog("tuzik"), masha);
        clinic.addPet(new Cat("murka"), masha);


        clinic.getClients().forEach( (name, client) -> {
            System.out.println("Client name: " + name);
            System.out.println("Pets:");
            client.getPets().forEach( (petName, pet) -> System.out.println(petName));
            System.out.println();
        });


    }
}
