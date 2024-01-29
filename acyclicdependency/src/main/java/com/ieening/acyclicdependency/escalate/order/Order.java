package com.ieening.acyclicdependency.escalate.order;

import java.math.BigDecimal;

public class Order {

    private BigDecimal chargeAmount;

    public Order(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getChargeAmount() {
        return this.chargeAmount;
    }

}
