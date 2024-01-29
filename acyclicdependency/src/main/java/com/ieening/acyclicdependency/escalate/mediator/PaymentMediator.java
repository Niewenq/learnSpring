package com.ieening.acyclicdependency.escalate.mediator;

import java.math.BigDecimal;
import java.util.List;

import com.ieening.acyclicdependency.escalate.account.Account;
import com.ieening.acyclicdependency.escalate.order.Order;

public class PaymentMediator {
    private Account account;

    public PaymentMediator(Account account) {
        this.account = account;
    }

    public BigDecimal pay(Order order) {
        BigDecimal discount = new BigDecimal(1).subtract(this.account.getDiscountAmount());
        return order.getChargeAmount().multiply(discount);
    }

    public BigDecimal pay(List<Order> orders) {
        BigDecimal total = new BigDecimal(0);
        for (Order order : orders) {
            total = total.add(pay(order));
        }
        return total;
    }
}