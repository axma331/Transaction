package org.example;

public abstract class BankCard {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void topUpFunds(double value) {
        if (value >= 0) {
            balance += value;
        } else {
            System.out.println("Невозможно пополнить баланс на отрицательную сумму!");
        }
    }

    public Boolean toPay(double value) {
        if (value > 0 && balance >= value) {
            balance -= value;
            return Boolean.TRUE;
        } else {
            System.out.println("Недостаточно средств для оплаты!");
        }
        return Boolean.FALSE;
    }

    public abstract double getAvailableFunds();
}
