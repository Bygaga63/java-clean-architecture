package config;

import adapter.encoder.FakePasswordEncoder;
import adapter.idGenerator.UUidGenerator;
import adapter.repository.InMemoryUserRepository;
import usecase.CreateUser;
import usecase.FindUser;
import usecase.LoginUser;
import usecase.port.encoder.PasswordEncoder;
import usecase.port.idGenerator.IdGenerator;
import usecase.port.repository.UserRepository;

public class ManualConfig {
    private final UserRepository userRepository = new InMemoryUserRepository();
    private final IdGenerator idGenerator = new UUidGenerator();
    private final PasswordEncoder passwordEncoder = new FakePasswordEncoder();

    public CreateUser createUser(){
        return new CreateUser(userRepository, passwordEncoder, idGenerator);
    }

    public FindUser findUser(){
        return new FindUser(userRepository);
    }

    public LoginUser loginUser(){
        return new LoginUser(userRepository, passwordEncoder);
    }


}
