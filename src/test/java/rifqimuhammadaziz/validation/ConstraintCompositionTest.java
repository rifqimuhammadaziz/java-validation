package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;

public class ConstraintCompositionTest extends AbstractValidatorTest{

    @Test
    void testComposition() {
        Payment payment = new Payment();
        payment.setOrderId("23123123123123123123asdss");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
