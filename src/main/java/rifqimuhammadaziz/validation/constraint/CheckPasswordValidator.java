package rifqimuhammadaziz.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import rifqimuhammadaziz.validation.Register;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext constraintValidatorContext) {
        if (register.getPassword() == null || register.getRetypePassword() == null) return true; // skip validation if null

        // password must be equals with retypePassword
        return register.getPassword().equals(register.getRetypePassword());
    }
}
