package rifqimuhammadaziz.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;
import rifqimuhammadaziz.validation.payload.EmailErrorPayload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setOrderId("0001"); // true
        payment.setAmount(20_000_000L); // true
        payment.setCreditCard("1234"); // wrong credit card number

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload) {
                if (payloadClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

            System.out.println("===============");
        }
    }
}
