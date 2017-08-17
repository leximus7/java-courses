package ru.alebedev.javacourse.clinic;


import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {

    @Test
    public void testCatName() {
        Cat cat = new Cat("murka");
        assertEquals("murka", cat.getName());

    }


    @Test
    public void testCatSetName() {
        Cat cat = new Cat("murka");
        cat.setName("pushok");
        assertEquals("pushok", cat.getName());

    }

    @Test
    public void testCatSound() {
        Cat cat = new Cat("murka");
        PrintTest printTest = new PrintTest();
        printTest.setUpStreams();
        cat.makeSound();
        assertEquals("myau", printTest.getOutContent().toString().trim() );

        printTest.cleanUpStreams();
    }




}
