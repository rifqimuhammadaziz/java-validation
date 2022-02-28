package rifqimuhammadaziz.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.service.UserService;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest{

    @Test
    void testCrossParameterValidation() throws NoSuchMethodException {
        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);
        String username = "xenosty";
        String password = "secretpassword";
        String retypePassword = "secretpassword123";

        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, method, new Object[]{
                username, password, retypePassword
        });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());
            System.out.println("===============");
        }
    }
}
