package com.github.axma331.cards;

import java.math.BigDecimal;

public class DebitCard extends BankCard {

    @Override
    public BigDecimal getAvailableFunds() {
        return getBalance();
    }

    @Override
    public String toString() {
        return "Available funds: " + getAvailableFunds().toPlainString() + "\n" +
                "Own funds: " + getBalance().toPlainString();
    }

}
