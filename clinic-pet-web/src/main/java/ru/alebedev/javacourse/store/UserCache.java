package ru.alebedev.javacourse.store;

import ru.alebedev.javacourse.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class UserCache implements Storage {
//    private static final UserCache INSTANCE = new UserCache();
//
//    private static Storage storage = new MemoryStorage();

    private Storage storage;

//    public static UserCache getInstance() {
//        return INSTANCE;
//    }


    public UserCache() {
    }

    public UserCache(Storage storage) {
        this.storage = storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Collection<User> values() {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
