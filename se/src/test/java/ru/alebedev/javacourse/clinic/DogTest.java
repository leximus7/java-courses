package ru.alebedev.javacourse.clinic;

import org.junit.Test;

import static org.junit.Assert.*;

public class DogTest {

    @Test
    public void testDogName() {
        Dog dog = new Dog("reks");
        assertEquals("reks", dog.getName());
    }

    @Test
    public void testCatSetName() {
        Dog dog = new Dog("reks");
        dog.setName("tuzik");
        assertEquals("tuzik", dog.getName());
    }

    @Test
    public void testCatSound() {
        Dog dog = new Dog("reks");
        PrintTest printTest = new PrintTest();
        printTest.setUpStreams();
        dog.makeSound();
        assertEquals("gav", printTest.getOutContent().toString().trim() );

        printTest.cleanUpStreams();
    }

}