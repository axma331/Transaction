package com.github.axma331.cards;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Getter
public abstract class BankCard {

    private BigDecimal balance = BigDecimal.ZERO;

    public void topUpFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            balance = balance.add(amount);
        } else {
            System.out.println("Невозможно пополнить баланс на отрицательную сумму!");
        }
    }

    public Boolean pay(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            return Boolean.TRUE;
        } else {
            System.out.println("Недостаточно средств для оплаты!");
        }
        return Boolean.FALSE;
    }

    public abstract BigDecimal getAvailableFunds();
}
