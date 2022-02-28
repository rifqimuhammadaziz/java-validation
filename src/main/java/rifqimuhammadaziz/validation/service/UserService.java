package rifqimuhammadaziz.validation.service;

import jakarta.validation.constraints.NotBlank;
import rifqimuhammadaziz.validation.constraint.CheckPasswordParameter;

public class UserService {

    @CheckPasswordParameter(
            passwordParam = 1,
            retypePasswordParam = 2)
    public void register(@NotBlank(message = "Username can not blank") String username,
                         @NotBlank(message = "Password can not blank") String password,
                         @NotBlank(message = "Retype Password can not blank") String retypePassword) {
        // TODO Register
    }
}
