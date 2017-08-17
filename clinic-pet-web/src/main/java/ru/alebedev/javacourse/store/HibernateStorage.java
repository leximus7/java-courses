package ru.alebedev.javacourse.store;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.alebedev.javacourse.models.User;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.function.Function;

public class HibernateStorage implements Storage {

    private Configuration cfg;
    private SessionFactory sessionFactory;

    public HibernateStorage() {
        cfg = new Configuration();
//        cfg.addResource("hibernate.properties");
        cfg.addAnnotatedClass(User.class);
        sessionFactory = cfg.buildSessionFactory();
    }

    private <T> T execute(Function<Session, T> command) {
        try (Session session = sessionFactory.openSession()) {
            Transaction trx = session.beginTransaction();
            T t = command.apply(session);
            trx.commit();
            return t;
        }
    }


    @Override
    public Collection<User> values() {
        return null;
    }

    @Override
    public int add(final User user) {
        return execute(session -> (Integer) session.save(user));
    }

    @Override
    public User get(final int id) {
        return execute(session -> session.get(User.class, id));
    }

    @Override
    public void edit(final User user) {
        execute(session -> {
            session.update(user);
            return null;
        });
    }

    @Override
    public void delete(final int id) {
        execute(session -> {
            session.delete(session.load(User.class, id));
            return null;
        });
    }

    @Override
    public User findByLogin(final String login) {
        return execute(session -> {
                    return (User) session.createQuery("from User where login=:login")
                            .setParameter("login", login)
                            .list()
                            .get(0);
                }
        );
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }
}
