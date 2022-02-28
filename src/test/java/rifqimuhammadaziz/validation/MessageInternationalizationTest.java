package rifqimuhammadaziz.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;

import java.util.Locale;
import java.util.Set;

public class MessageInternationalizationTest extends AbstractValidatorTest{

    // automatic
    @Test
    void testI18N() {
        Locale.setDefault(new Locale("in", "ID"));
        Payment payment = new Payment();
        payment.setOrderId("2923987129837971"); // wrong id
        payment.setAmount(11L);

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    // manual
    @Test
    void testMessageInterpolator() {
        Locale.setDefault(new Locale("in", "ID"));
        Payment payment = new Payment();
        payment.setOrderId("2923987129837971"); // wrong id
        payment.setAmount(11L);

        Locale locale = new Locale("in", "ID");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate()); // get key message

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
            System.out.println(message);
            System.out.println("===============");
        }

    }
}
