package org.example;

public class Main {
    public static void main(String[] args) {

        {
            DebitCard card = new DebitCard();
            System.out.println(card + "\n");
            card.topUpFunds(100);
            System.out.println(card + "\n");
            card.toPay(200);
            System.out.println(card + "\n");
            card.toPay(99);
            System.out.println(card + "\n");

        }
        {
            CreditCard card = new CreditCard();

            card.setCreditLimit(10000);
            System.out.println(card + "\n");
            card.topUpFunds(5000);
            System.out.println(card + "\n");
            card.toPay(5000);
            System.out.println(card + "\n");
            card.toPay(3000);
            System.out.println(card + "\n");
            card.topUpFunds(2000);
            System.out.println(card + "\n");
            card.topUpFunds(2000);
            System.out.println(card + "\n");
        }
        System.out.println();
        {
            MirBonus card = new MirBonus();

            System.out.println(card+ "\n");
            card.topUpFunds(1500);
            System.out.println(card+ "\n");
            card.toPay(500);
            System.out.println(card+ "\n");
            card.toPay(500);
            System.out.println(card+ "\n");
            card.topUpFunds(1500);
            System.out.println(card+ "\n");
        }
        System.out.println();
        {
            MirCreditCashback card = new MirCreditCashback();

            System.out.println(card+ "\n");
            card.topUpFunds(15000);
            System.out.println(card+ "\n");
            card.toPay(5000);
            System.out.println(card+ "\n");
            card.toPay(4000);
            System.out.println(card+ "\n");
            card.toPay(5500);
            System.out.println(card+ "\n");
        }
    }
}