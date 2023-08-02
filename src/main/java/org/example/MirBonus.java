package org.example;

import java.math.BigDecimal;

public class MirBonus extends DebitCard {

    private BigDecimal bonus;
    private BigDecimal savings;

    public MirBonus() {
        this.bonus = BigDecimal.ZERO;
        this.savings = BigDecimal.ZERO;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public BigDecimal getSavings() {
        return savings;
    }

    @Override
    public Boolean pay(BigDecimal value) {
        Boolean isSuccess = super.pay(value);
        if (isSuccess) {
            bonus = bonus.add(
                    value.multiply(BigDecimal.valueOf(0.001))
            );
        }
        return isSuccess;
    }

    @Override
    public void topUpFunds(BigDecimal value) {
        super.topUpFunds(value);
        savings = savings.add(
                value.multiply(BigDecimal.valueOf(0.00005))
        );
    }

    @Override
    public BigDecimal getAvailableFunds() {
        return super.getAvailableFunds().add(
                bonus.add(savings)
        );
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Bonus: " + bonus.toPlainString() + "\n" +
                "Savings: " + savings.toPlainString();
    }
}
