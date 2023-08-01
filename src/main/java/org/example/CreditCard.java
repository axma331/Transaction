package org.example;

public class CreditCard extends BankCard {

    private double creditBalance;
    private double creditLimit;

    public void setCreditLimit(double creditLimit) {
        double diff = this.creditLimit - this.creditBalance;
        if (diff <= creditLimit) {
            this.creditLimit = creditLimit;
            this.creditBalance = creditLimit - diff;
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    @Override
    public void topUpFunds(double value) {
        if (value > 0) {
            double diff = creditLimit - creditBalance;
            if (diff > 0) {
                creditBalance = value > diff
                        ? creditLimit
                        : creditBalance + value;
            }
            super.topUpFunds(value - diff);
        } else {
            System.out.println("Пополнить баланс на отрицательную сумму невозможно!");
        }
    }

    @Override
    public Boolean toPay(double value) {
        if (value < 0 || value >= getAvailableFunds()) {
            if (value < 0) {
                System.out.println("Оплата на отрицательную сумму невозможна");
            } else {
                System.out.println("Недостаточно средств для оплаты!");
            }
            return Boolean.FALSE;
        }
        double remains = value - getBalance();
        if (remains > 0) {
            creditBalance -= remains;
            return super.toPay(getBalance());
        } else {
            return super.toPay(value);
        }
    }

    @Override
    public double getAvailableFunds() {
        return getBalance() + creditBalance;
    }

    @Override
    public String toString() {
        return "Available funds: " + getAvailableFunds() + "\n" +
                "CreditLimit: " + getCreditLimit() + "\n" +
                "Credit funds: " + getCreditBalance() + "\n" +
                "Own funds: " + getBalance();
    }
}
