package rifqimuhammadaziz.validation.group;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

// by order
@GroupSequence(value = {
        Default.class, // if error, the next group will not validate
        CreditCardPaymentGroup.class,
        VirtualAccountPaymentGroup.class
})
public interface PaymentGroup {
}
