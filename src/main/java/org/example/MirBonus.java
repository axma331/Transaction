package org.example;

public class MirBonus extends DebitCard {

    private double bonus;
    private double savings;

    public double getBonus() {
        return bonus;
    }

    public double getSavings() {
        return savings;
    }

    @Override
    public Boolean toPay(double value) {
        Boolean isSuccess = super.toPay(value);
        if (isSuccess) {
            bonus += value * 0.001;
        }
       return isSuccess;
    }

    @Override
    public void topUpFunds(double value) {
        super.topUpFunds(value);
        savings += value * 0.00005;
    }

    @Override
    public double getAvailableFunds() {
        return super.getAvailableFunds() + bonus + savings;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Bonus: " + bonus + "\n" +
                "Savings: "+ savings;
    }
}
