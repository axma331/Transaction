package org.example;

import java.math.BigDecimal;

public abstract class BankCard {

    private BigDecimal balance;

    public BankCard() {
        this.balance = BigDecimal.ZERO;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void topUpFunds(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) >= 0) {
            balance = balance.add(value);
        } else {
            System.out.println("Невозможно пополнить баланс на отрицательную сумму!");
        }
    }

    public Boolean pay(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(value) >= 0) {
            balance = balance.subtract(value);
            return Boolean.TRUE;
        } else {
            System.out.println("Недостаточно средств для оплаты!");
        }
        return Boolean.FALSE;
    }

    public abstract BigDecimal getAvailableFunds();
}
