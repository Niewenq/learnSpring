package com.ieening.acyclicdependency.original.order;

import java.math.BigDecimal;

import com.ieening.acyclicdependency.original.account.Account;

public class Order {

    private BigDecimal chargeAmount;
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Order(Account account, BigDecimal chargeAmount) {
        this.account = account;
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getChargeAmount() {
        return this.chargeAmount;
    }

    public BigDecimal pay() {
        BigDecimal discount = new BigDecimal(1).subtract(this.account.getDiscountAmount());
        BigDecimal paidAmount = this.chargeAmount.multiply(discount);

        return paidAmount;
    }
}
