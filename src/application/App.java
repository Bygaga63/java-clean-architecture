package application;

import config.ManualConfig;
import domain.entity.User;

public class App {
    public static void main(String[] args) {
        var config = new ManualConfig();
        var createUser = config.createUser();
        var findUser = config.findUser();
        var loginUser = config.loginUser();
        var userCandidate = User.builder()
                .email("john.doe@gmail.com")
                .password("mypassword")
                .lastName("doe")
                .firstName("john")
                .build();

        var user = createUser.create(userCandidate);
        System.out.println("User created with id " + user.getId());

        // Find a user by id
        var actualFindUser = findUser.findById(user.getId());
        System.out.println("Found user with id " + actualFindUser.get().getId());

        // List all users
        var users = findUser.findAllUsers();
        System.out.println("List all users: " + users);

        // Login
        loginUser.login("john.doe@gmail.com", "mypassword");
        System.out.println("Allowed to login with email 'john.doe@gmail.com' and password  'mypassword'");

    }
}
