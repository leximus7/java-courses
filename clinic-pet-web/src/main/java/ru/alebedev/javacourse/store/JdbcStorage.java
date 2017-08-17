package ru.alebedev.javacourse.store;

import ru.alebedev.javacourse.models.User;
import ru.alebedev.javacourse.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcStorage implements Storage {

    private final Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getINSTANCE();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"),
                    settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException();
        }

    }

    @Override
    public Collection<User> values() {
        final List<User> users = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from clients")) {
            while (rs.next()) {
                users.add(new User(rs.getInt("userid"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int add(User user) {
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into users (name) values (?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
    }

    @Override
    public void edit(User user) {
        try (final PreparedStatement statement =
                     this.connection.prepareStatement("update users set name = (?) where userid = (?)")) {
            statement.setString(1, user.getLogin());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("delete from users where userid = (?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from users where userid = (?)")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new User(rs.getInt("userid"), rs.getString("name"), rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("User with id=%s does not exist", id));
    }

    @Override
    public User findByLogin(String login) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from users where name = (?)")) {
            statement.setString(1, login);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new User(rs.getInt("userid"), rs.getString("name"), rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
