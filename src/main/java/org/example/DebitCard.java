package org.example;

public class DebitCard extends BankCard {

    @Override
    public double getAvailableFunds() {
        return getBalance();
    }

    @Override
    public String toString() {
        return "Available funds: " + getAvailableFunds() + "\n" +
                "Own funds: " + getBalance();
    }

}
