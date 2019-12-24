package adapter.repository;

import domain.entity.User;
import usecase.port.repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private static Map<String, User> db = new HashMap<>();

    @Override
    public User create(User user) {
        db.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return db.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(db.values());
    }
}
