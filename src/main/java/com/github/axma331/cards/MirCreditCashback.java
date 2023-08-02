package com.github.axma331.cards;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class MirCreditCashback extends CreditCard {

    private BigDecimal cashback = BigDecimal.ZERO;

    @Override
    public Boolean pay(BigDecimal amount) {
        Boolean isSuccess = super.pay(amount);
        if (isSuccess && amount.compareTo(BigDecimal.valueOf(5000)) >= 0) {
            cashback = cashback.add(
                    amount.multiply(BigDecimal.valueOf(0.005))
            );
        }
        return isSuccess;
    }

    @Override
    public BigDecimal getAvailableFunds() {
        return super.getAvailableFunds().add(cashback);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Cashback: " + cashback.toPlainString();
    }
}
