package org.example;

import java.math.BigDecimal;

public class MirCreditCashback extends CreditCard {

    private BigDecimal cashback;

    public MirCreditCashback() {
        this.cashback = BigDecimal.ZERO;
    }

    public BigDecimal getCashback() {
        return cashback;
    }

    @Override
    public Boolean pay(BigDecimal value) {
        Boolean isSuccess = super.pay(value);
        if (isSuccess && value.compareTo(BigDecimal.valueOf(5000)) >= 0) {
            cashback = cashback.add(
                    value.multiply(BigDecimal.valueOf(0.005))
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
