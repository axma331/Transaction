package org.example;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    private BigDecimal creditBalance;
    private BigDecimal creditLimit;

    public CreditCard() {
        this.creditBalance = BigDecimal.ZERO;
        this.creditLimit = BigDecimal.ZERO;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        BigDecimal diff = this.creditLimit.subtract(creditBalance);
        if (diff.compareTo(creditLimit) <= 0) {
            this.creditLimit = creditLimit;
            creditBalance = creditLimit.subtract(diff);
        }
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal getCreditBalance() {
        return creditBalance;
    }

    @Override
    public void topUpFunds(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal diff = creditLimit.subtract(creditBalance);
            if (diff.compareTo(BigDecimal.ZERO) > 0) {
                creditBalance = value.compareTo(diff) > 0
                        ? creditLimit
                        : creditBalance.add(value);
            }
            super.topUpFunds(value.subtract(diff));
        } else {
            System.out.println("Пополнить баланс на отрицательную сумму невозможно!");
        }
    }

    @Override
    public Boolean pay(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0 || value.compareTo(getAvailableFunds()) >= 0) {
            if (value.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("Оплата на отрицательную сумму невозможна");
            } else {
                System.out.println("Недостаточно средств для оплаты!");
            }
            return Boolean.FALSE;
        }
        BigDecimal remains = value.subtract(getBalance());
        if (remains.compareTo(BigDecimal.ZERO) > 0) {
            creditBalance = creditBalance.add(remains);
            return super.pay(getBalance());
        } else {
            return super.pay(value);
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
