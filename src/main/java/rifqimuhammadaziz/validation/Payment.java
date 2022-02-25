package rifqimuhammadaziz.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @NotBlank(message = "Order ID can not blank")
    private String orderId;

    @NotNull(message = "Amount can not null")
    @Range(min = 10_000L, max = 1000_000_000L, message = "Amount must between 10.000 and 100.000.000")
    private Long amount;

    @NotBlank(message = "Credit Card Number can not blank")
    @LuhnCheck(message = "Credit Card Number is wrong, check again.") // credit card validation general
    private String creditCard;

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
                '}';
    }
}
