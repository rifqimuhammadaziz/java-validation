package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationClass extends AbstractValidatorTest{

    @Test
    void testClassLevelValidation() {
        Register register = new Register();
        register.setUsername("Xenosty");
        register.setPassword("secretpassword");
        register.setRetypePassword("passwordrahasia");

        // has not propertyPath, because its only validate in Class Level
        validate(register);
    }
}
