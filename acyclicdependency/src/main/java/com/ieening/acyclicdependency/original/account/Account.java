package com.ieening.acyclicdependency.original.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ieening.acyclicdependency.original.order.Order;

public class Account {
    private List<Order> orders;

    public BigDecimal getDiscountAmount() {
        // 根据账号下的订单数来模拟折扣力度
        if (orders.size() > 5) {
            return new BigDecimal(0.1);
        } else {
            return new BigDecimal(0.03);
        }
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void createOrder(BigDecimal chargeAmount) {
        Order order = new Order(this, chargeAmount);
        if (orders == null) {
            orders = new ArrayList<Order>();
        }
        orders.add(order);
    }

    public BigDecimal pay() {
        BigDecimal total = new BigDecimal(0);
        for (Order order : orders) {
            total = total.add(order.pay());
        }
        return total;
    }
}
