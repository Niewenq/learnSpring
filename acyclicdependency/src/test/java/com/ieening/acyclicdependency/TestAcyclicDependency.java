package com.ieening.acyclicdependency;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ieening.acyclicdependency.demote.calculator.DiscountCalculator;
import com.ieening.acyclicdependency.escalate.mediator.PaymentMediator;

public class TestAcyclicDependency {
    ArrayList<BigDecimal> chargeAmounts;

    @Before
    public void setUp() {
        chargeAmounts = new ArrayList<BigDecimal>() {
            {
                add(new BigDecimal(20));
                add(new BigDecimal(30));
                add(new BigDecimal(40));
                add(new BigDecimal(50));
                add(new BigDecimal(60));
            }
        };
    }

    @Test
    public void testOriginal() {
        com.ieening.acyclicdependency.original.account.Account account = new com.ieening.acyclicdependency.original.account.Account();

        for (BigDecimal chargeAmount : chargeAmounts) {
            account.createOrder(chargeAmount);
        }
        assertTrue(account.pay().doubleValue() == 194);
    }

    @Test
    public void testEscalate() {
        com.ieening.acyclicdependency.escalate.account.Account account = new com.ieening.acyclicdependency.escalate.account.Account();
        for (BigDecimal chargeAmount : chargeAmounts) {
            account.createOrder(chargeAmount);
        }
        PaymentMediator paymentMediator = new PaymentMediator(account);
        assertTrue(paymentMediator.pay(account.getOrders()).doubleValue() == 194);
    }

    @Test
    public void testDemote() {
        com.ieening.acyclicdependency.demote.account.Account account = new com.ieening.acyclicdependency.demote.account.Account();
        for (BigDecimal chargeAmount : chargeAmounts) {
            account.createOrder(chargeAmount);
        }
        DiscountCalculator discountCalculator = new DiscountCalculator(account.getOrders().size());
        assertTrue(account.pay(discountCalculator).doubleValue() == 194);
    }

    @Test
    public void testCallback() {
        com.ieening.acyclicdependency.callback.account.Account account = new com.ieening.acyclicdependency.callback.account.Account();
        for (BigDecimal chargeAmount : chargeAmounts) {
            account.createOrder(chargeAmount);
        }
        assertTrue(account.pay().doubleValue() == 194);
    }

}
