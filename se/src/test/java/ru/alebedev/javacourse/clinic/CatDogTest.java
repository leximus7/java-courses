package ru.alebedev.javacourse.clinic;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatDogTest {

    @Test
    public void testCatDogName() {
        CatDog cat = new CatDog("murka");
        assertEquals("murka", cat.getName());
    }


    @Test
    public void testCatSetName() {
        CatDog catdog = new CatDog("murka");
        catdog.setName("pushok");
        assertEquals("pushok", catdog.getName());

    }

    @Test
    public void testCatSound() {
        CatDog catdog = new CatDog("murka");
        PrintTest printTest = new PrintTest();
        printTest.setUpStreams();
        catdog.makeSound();
        String lineSeparator = System.getProperty("line.separator");
        assertEquals("myau" + lineSeparator + "gav", printTest.getOutContent().toString().trim() );

        printTest.cleanUpStreams();
    }


}