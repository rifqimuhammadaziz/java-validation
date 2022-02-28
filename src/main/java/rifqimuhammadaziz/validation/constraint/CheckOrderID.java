package rifqimuhammadaziz.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import rifqimuhammadaziz.validation.enums.CaseMode;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;
import rifqimuhammadaziz.validation.group.VirtualAccountPaymentGroup;

import java.lang.annotation.*;

@CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        message = "{order.id.notblank}")
@Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        min = 1,
        max = 10,
        message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderID {

    String message() default "Invalid OrderID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
