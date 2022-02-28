package rifqimuhammadaziz.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordParameterValidator.class})
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface CheckPasswordParameter {

    int passwordParam();

    int retypePasswordParam();

    String message() default "Password and Re-type password must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
