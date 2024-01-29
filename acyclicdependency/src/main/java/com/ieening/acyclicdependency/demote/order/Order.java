package com.ieening.acyclicdependency.demote.order;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.ieening.acyclicdependency.demote.calculator.DiscountCalculator;

public class Order {

    private BigDecimal chargeAmount;

    public Order(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getChargeAmount() {
        return this.chargeAmount;
    }

    public BigDecimal pay(DiscountCalculator discountCalculator) {
        BigDecimal discount = new BigDecimal(1).subtract(discountCalculator.getDiscountAmount()).setScale(2,
                RoundingMode.HALF_UP);
        BigDecimal paidAmount = this.chargeAmount.multiply(discount).setScale(2);

        return paidAmount;
    }

}
