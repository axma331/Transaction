package com.github.axma331.cards;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class CreditCard extends BankCard {

    private BigDecimal creditBalance;
    private BigDecimal creditLimit;

    public CreditCard() {
        creditLimit = BigDecimal.valueOf(10000);
        creditBalance = creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        BigDecimal diff = this.creditLimit.subtract(creditBalance);
        if (diff.compareTo(creditLimit) <= 0) {
            this.creditLimit = creditLimit;
            creditBalance = creditLimit.subtract(diff);
        }
    }

    @Override
    public void topUpFunds(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal diff = creditLimit.subtract(creditBalance);
            if (diff.compareTo(BigDecimal.ZERO) > 0) {
                creditBalance = amount.compareTo(diff) > 0
                        ? creditLimit
                        : creditBalance.add(amount);
            }
            super.topUpFunds(amount.subtract(diff));
        } else {
            System.out.println("Пополнить баланс на отрицательную сумму невозможно!");
        }
    }

    @Override
    public Boolean pay(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0 || amount.compareTo(getAvailableFunds()) >= 0) {
            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("Оплата на отрицательную сумму невозможна");
            } else {
                System.out.println("Недостаточно средств для оплаты!");
            }
            return Boolean.FALSE;
        }
        BigDecimal remains = amount.subtract(getBalance());
        if (remains.compareTo(BigDecimal.ZERO) > 0) {
            creditBalance = creditBalance.add(remains);
            return super.pay(getBalance());
        } else {
            return super.pay(amount);
        }
    }

    @Override
    public BigDecimal getAvailableFunds() {
        return getBalance().add(creditBalance);
    }

    @Override
    public String toString() {
        return "Available funds: " + getAvailableFunds().toPlainString() + "\n" +
                "CreditLimit: " + getCreditLimit().toPlainString() + "\n" +
                "Credit funds: " + getCreditBalance().toPlainString() + "\n" +
                "Own funds: " + getBalance().toPlainString();
    }
}
