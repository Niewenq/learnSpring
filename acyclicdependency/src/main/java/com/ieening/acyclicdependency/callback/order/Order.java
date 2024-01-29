package com.ieening.acyclicdependency.callback.order;

import java.math.BigDecimal;

import com.ieening.acyclicdependency.callback.calculator.DiscountCalculator;

public class Order {

    private BigDecimal chargeAmount;
    private DiscountCalculator discounter;

    public Order(DiscountCalculator discounter, BigDecimal chargeAmount) {
        this.discounter = discounter;
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getChargeAmount() {
        return this.chargeAmount;
    }

    public BigDecimal pay() {
        BigDecimal discount = new BigDecimal(1).subtract(this.discounter.getDiscountAmount());
        BigDecimal paidAmount = this.chargeAmount.multiply(discount);

        return paidAmount;
    }
}
