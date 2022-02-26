package rifqimuhammadaziz.validation;

import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;
import rifqimuhammadaziz.validation.group.VirtualAccountPaymentGroup;

public class GroupTest extends AbstractValidatorTest{

    @Test
    void testCreditCardGroup() {
        Payment payment = new Payment();
        payment.setOrderId("0002");
        payment.setAmount(20_000L);
        payment.setCreditCard("111");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccount() {
        Payment payment = new Payment();
        payment.setOrderId("0002");
        payment.setAmount(20_000L);
        payment.setVirtualAccount("");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
