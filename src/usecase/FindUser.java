package usecase;

import domain.entity.User;
import usecase.port.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class FindUser {
    private final UserRepository repository;

    public FindUser(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public Optional<User> findById(final String id){
        return repository.findById(id);
    }

    public List<User> findAllUsers(){
        return repository.findAllUsers();
    }
}
