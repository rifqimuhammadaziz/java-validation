package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.group.PaymentGroup;

public class GroupSequenceTest extends AbstractValidatorTest{

    @Test
    void testGroupSequence() {
        Payment payment = new Payment();
        payment.setOrderId("0001"); // true
        payment.setAmount(20_000_000L); // true
        payment.setCreditCard("4111111111111111"); // true

        validateWithGroups(payment, PaymentGroup.class);
    }
}
