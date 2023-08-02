package com.github.axma331.cards;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class MirBonus extends DebitCard {

    private BigDecimal bonus = BigDecimal.ZERO;
    private BigDecimal savings = BigDecimal.ZERO;

    @Override
    public Boolean pay(BigDecimal amount) {
        Boolean isSuccess = super.pay(amount);
        if (isSuccess) {
            bonus = bonus.add(
                    amount.multiply(BigDecimal.valueOf(0.001))
            );
        }
        return isSuccess;
    }

    @Override
    public void topUpFunds(BigDecimal amount) {
        super.topUpFunds(amount);
        savings = savings.add(
                amount.multiply(BigDecimal.valueOf(0.00005))
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
