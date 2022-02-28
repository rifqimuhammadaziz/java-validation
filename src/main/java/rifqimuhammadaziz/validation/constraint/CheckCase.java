package rifqimuhammadaziz.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import rifqimuhammadaziz.validation.enums.CaseMode;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    CaseMode mode();

    String message() default "Invalid case format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
