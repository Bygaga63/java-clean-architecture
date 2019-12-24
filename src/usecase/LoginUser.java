package usecase;

import domain.entity.User;
import usecase.exception.NotAllowedException;
import usecase.port.encoder.PasswordEncoder;
import usecase.port.repository.UserRepository;

public class LoginUser {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public LoginUser(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User login(final String email, final String password){
        var user = repository.findByEmail(email).orElseThrow(() -> new NotAllowedException("Not found"));
        var hashedPassword = encoder.encode(email + password);
        if (!user.getPassword().equals(hashedPassword)) throw new NotAllowedException("Wrong password");

        return user;
    }
}
