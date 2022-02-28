package rifqimuhammadaziz.validation;

import jakarta.validation.constraints.NotBlank;
import rifqimuhammadaziz.validation.constraint.CheckPassword;

@CheckPassword(message = "Password and Re-type password must be same")
public class Register {

    @NotBlank(message = "Username can not blank")
    private String username;

    @NotBlank(message = "Password can not blank")
    private String password;

    @NotBlank(message = "Re-type Password can not blank")
    private String retypePassword;

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
