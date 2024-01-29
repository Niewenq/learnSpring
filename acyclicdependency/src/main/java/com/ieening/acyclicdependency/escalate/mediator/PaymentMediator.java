package com.ieening.acyclicdependency.escalate.mediator;

import java.math.BigDecimal;

import com.ieening.acyclicdependency.escalate.account.Account;
import com.ieening.acyclicdependency.escalate.order.Order;

public class PaymentMediator {
    private Account account;

    public PaymentMediator(Account account) {
        this.account = account;
    }

    public BigDecimal pay() {
        BigDecimal total = new BigDecimal(0);
        BigDecimal discount = new BigDecimal(1).subtract(this.account.getDiscountAmount());
        for (Order order : account.getOrders()) {
            total = total.add(order.getChargeAmount().multiply(discount));
        }
        return total;
    }
}