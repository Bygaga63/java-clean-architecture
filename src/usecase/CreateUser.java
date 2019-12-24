package usecase;

import domain.entity.User;
import usecase.exception.UserAlreadyExistException;
import usecase.port.idGenerator.IdGenerator;
import usecase.port.encoder.PasswordEncoder;
import usecase.port.repository.UserRepository;
import usecase.validator.UserValidator;

public class CreateUser {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;

    public CreateUser(UserRepository repository, PasswordEncoder passwordEncoder, IdGenerator idGenerator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.idGenerator = idGenerator;
    }

    public User create(User user){
        UserValidator.validationCreateUser(user);

        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(user.getEmail());
        }

        var userToSave = User.builder()
                .id(idGenerator.generate())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();

        return repository.create(userToSave);

    }
}
