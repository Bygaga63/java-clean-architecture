package usecase.validator;

import domain.entity.User;
import usecase.exception.UserValidationException;

public class UserValidator {
    public static void validationCreateUser(User user){
        if (user == null) throw new UserValidationException("User should not be null");
        if (user.getEmail() == null || user.getEmail().trim().length() == 0 ) throw new UserValidationException("Email should not be null");
        if (user.getFirstName() == null || user.getFirstName().trim().length() == 0 ) throw new UserValidationException("First name should not be null");
        if (user.getLastName() == null || user.getLastName().trim().length() == 0) throw new UserValidationException("Last name should not be null");
    }
}
