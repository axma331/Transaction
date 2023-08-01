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
    public void topUp(double value) {
        if (value > 0) {
            double diff = creditLimit - creditBalance;
            if (diff > 0) {
                creditBalance = value > diff
                        ? creditLimit
                        : creditBalance + value;
            }
            super.topUp(value - diff);
        }
    }

    @Override
    public double getAvailableFunds() {
        return getBalance() + creditBalance;
    }

    @Override
    public Boolean toPay(double value) {
        if (value < 0 && value >= getBalance() + creditBalance) {
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
    public String toString() {
        return "CreditLimit: " + getCreditLimit() + "\n" +
                "Credit funds: " + getCreditBalance() + "\n" +
                "Own funds: " + getBalance() + "\n" +
                "Available funds: " + getAvailableFunds();
    }
}
