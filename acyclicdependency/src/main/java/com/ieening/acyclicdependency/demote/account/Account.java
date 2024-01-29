package com.ieening.acyclicdependency.demote.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ieening.acyclicdependency.demote.calculator.DiscountCalculator;
import com.ieening.acyclicdependency.demote.order.Order;

public class Account {
    private List<Order> orders;

    public List<Order> getOrders() {
        return this.orders;
    }

    public void createOrder(BigDecimal chargeAmount) {
        Order bill = new Order(chargeAmount);
        if (orders == null) {
            orders = new ArrayList<Order>();
        }
        orders.add(bill);
    }

    public BigDecimal pay(DiscountCalculator discountCalculator) {
        BigDecimal total = new BigDecimal(0);
        for (Order order : orders) {
            total = total.add(new BigDecimal(1).subtract(discountCalculator.getDiscountAmount())
                    .multiply(order.getChargeAmount()));
        }
        return total;
    }

}
