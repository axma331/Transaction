package org.example;

public class DebitCard extends BankCard {

    @Override
    public void topUp(double value) {
        super.topUp(value);
    }

    @Override
    public double getAvailableFunds() {
        return getBalance();
    }

    @Override
    public String toString() {
        return "Own funds: " + getBalance();
    }

}
