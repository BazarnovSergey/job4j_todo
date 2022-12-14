package ru.job4j.todo.service;

import org.springframework.stereotype.Service;
import ru.job4j.todo.model.User;
import ru.job4j.todo.store.UserDBStore;

import java.time.ZoneId;
import java.util.*;

@Service
public class UserService {

    private final UserDBStore userDBStore;

    public UserService(UserDBStore userDBStore) {
        this.userDBStore = userDBStore;
    }

    public Optional<User> add(User user) {
        return userDBStore.add(user);
    }

    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userDBStore.findByLoginAndPassword(login, password);
    }

    public Optional<User> findByLogin(String login) {
        return userDBStore.findByLogin(login);
    }

    public Set<String> getAvailableZones() {
        return new HashSet<String>(ZoneId.getAvailableZoneIds());
    }
}
