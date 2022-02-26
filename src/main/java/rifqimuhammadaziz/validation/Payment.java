package rifqimuhammadaziz.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;
import rifqimuhammadaziz.validation.group.VirtualAccountPaymentGroup;

public class Payment {

    @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "Order ID can not blank")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "Amount can not null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 10_000L,
            max = 1000_000_000L,
            message = "Amount must between 10.000 and 100.000.000")
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class},
            message = "Credit Card Number can not blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class},
            message = "Credit Card Number is wrong, check again.") // credit card validation general
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class},
            message = "Virtual Account can not blank")
    private String virtualAccount;

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                '}';
    }
}
