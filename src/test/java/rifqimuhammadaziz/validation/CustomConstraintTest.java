package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;

public class CustomConstraintTest extends AbstractValidatorTest{

    @Test
    void testCustomConstraint() {
        Payment payment = new Payment();
        payment.setOrderId("UPPERID"); // OrderID must be UPPERCASE

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
