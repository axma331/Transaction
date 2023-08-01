package org.example;

public abstract class BankCard {

    private double balance;


    public double getBalance() {
        return balance;
    }

    public void topUp(double value) {
        if (value > 0) {
            balance += value;
        }
    }

    public Boolean toPay(double value) {
        if (value > 0 && balance > 0 && getAvailableFunds() >= value) {
            balance -= value;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public abstract double getAvailableFunds();
}
