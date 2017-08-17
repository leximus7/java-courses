package ru.alebedev.javacourse.store;

import org.junit.*;
import ru.alebedev.javacourse.models.User;

import static org.junit.Assert.*;


public class JdbcStorageTest {

    private static JdbcStorage storage;

    @BeforeClass
    public static void setUp() {
        storage = new JdbcStorage();
    }

    @AfterClass
    public static void destroy() {
        storage.close();
    }

    @Test
    public void testCreate() throws Exception {
        final int id = storage.add(new User(-1, "test", null));
        final User user = storage.get(id);
        assertEquals(id, user.getId());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddDelete() throws Exception {
        final int id = storage.add(new User(-1, "test", null));
        final User user = storage.get(id);

        assertEquals(id, user.getId());
        assertNotNull(storage.get(id));
        storage.delete(id);
        storage.get(id);
    }

    @Test
    public void testEdit() {
        final int id = storage.add(new User(-1, "before_edit", null));
        final User userBefore = storage.get(id);
        User userAfter = new User(id, "after_edit", null);

        assertEquals("before_edit", userBefore.getLogin());

        storage.edit(userAfter);
        userAfter = storage.get(id);
        assertEquals("after_edit", userAfter.getLogin());
    }

    @Test
    public void testFindByLogin() {
        User user;

        while ((user = storage.findByLogin("test")) != null) {
            storage.delete(user.getId());
        }

        assertNull(storage.findByLogin("test"));
        int id = storage.add(new User(-1, "test", null));
        assertEquals(id, storage.findByLogin("test").getId());
    }

}