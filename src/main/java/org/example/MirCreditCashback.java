package org.example;

public class MirCreditCashback extends CreditCard {
    private double cashback;

    public double getCashback() {
        return cashback;
    }

    @Override
    public Boolean toPay(double value) {
        Boolean isSuccess = super.toPay(value);
        if (isSuccess && value >= 5000) {
            cashback += value * 0.005;
        }
        return isSuccess;
    }

    @Override
    public double getAvailableFunds() {
        return super.getAvailableFunds() + cashback;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Cashback: " + cashback;
    }
}
