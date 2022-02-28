package rifqimuhammadaziz.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import rifqimuhammadaziz.validation.constraint.CheckCase;
import rifqimuhammadaziz.validation.constraint.CheckOrderID;
import rifqimuhammadaziz.validation.enums.CaseMode;
import rifqimuhammadaziz.validation.group.CreditCardPaymentGroup;
import rifqimuhammadaziz.validation.group.VirtualAccountPaymentGroup;
import rifqimuhammadaziz.validation.payload.EmailErrorPayload;

public class Payment {

    @CheckOrderID(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "{order.id.invalid}")
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "Amount can not null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 10_000L,
            max = 1000_000_000L,
            message = "{order.amount.range}")
    private Long amount;

    @NotBlank(groups = {CreditCardPaymentGroup.class},
            message = "Credit Card Number can not blank")
    @LuhnCheck(groups = {CreditCardPaymentGroup.class},
            message = "Credit Card Number is wrong, check again.",
            payload = {EmailErrorPayload.class})
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class},
            message = "Virtual Account can not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
            message = "Customer can not null.")
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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
                ", customer=" + customer +
                '}';
    }
}
