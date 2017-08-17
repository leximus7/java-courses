package ru.alebedev.javacourse.store;

import ru.alebedev.javacourse.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStorage implements Storage {

    private final AtomicInteger id = new AtomicInteger();

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();


    @Override
    public Collection<User> values() {
        return this.users.values();
    }


    @Override
    public int add (final User user) {
        this.users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public void edit (final User user) {
        this.users.replace(user.getId(), user);
    }


    @Override
    public void delete (int id) {
        this.users.remove(id);
    }

    @Override
    public User get(int id) {
        return this.users.get(id);
    }

    @Override
    public User findByLogin(String login) {
        return users.values()
                .stream()
                .filter(x -> x.getLogin().equals(login))
                .findAny()
                .get();
    }

    @Override
    public int generateId() {
        return this.id.incrementAndGet();
    }

    @Override
    public void close() {
    }
}
