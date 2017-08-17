package ru.alebedev.javacourse.store;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.alebedev.javacourse.models.User;

import static org.junit.Assert.*;

public class HibernateStorageTest {

    private HibernateStorage hs;

    @Before
    public void setUp(){
        hs = new HibernateStorage();
    }

    @Test
    public void testAddUser() {
        int id = hs.add(new User(-1, "testHS1", null));
        System.out.println(id);
        assertNotEquals(0, id);
    }

    @Test
    public void testGetUser() {
        int id = hs.add(new User(-1, "testHS2", null));
        User user = hs.get(id);
        assertEquals("testHS2", user.getLogin());
    }

    @Test
    public void testDeleteUser() {
        int id = hs.add(new User(-1, "testHS3", null));
        assertNotEquals(0, id);
        hs.delete(id);
        assertNull(hs.get(id));
    }

    @Test
    public void testEditUser() {
        int id = hs.add(new User(-1, "testHS4", null));
        assertNotEquals(0, id);
        hs.edit(new User(id, "testHS4_mod", null));
        assertEquals("testHS4_mod", hs.get(id).getLogin());
    }

    @Test
//    @Ignore
    public void testFindByLogin() {
        int id = hs.add(new User(-1, "testHS5", null));
//        System.out.println(hs.findByLogin("testHS5").getId());
        assertEquals("testHS5", hs.findByLogin("testHS5").getLogin());
    }



}