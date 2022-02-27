package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.group.VirtualAccountPaymentGroup;

public class MessageInterpolationTest extends AbstractValidatorTest{

    @Test
    void testMessage() {
        Payment payment = new Payment();
        payment.setOrderId("2301293092039");
        payment.setVirtualAccount("123456");
        payment.setAmount(10L);

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
