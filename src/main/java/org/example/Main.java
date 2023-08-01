package org.example;

public class Main {
    public static void main(String[] args) {
        {
            CreditCard card = new CreditCard();

            card.setCreditLimit(10000);
            System.out.println(card + "\n");
            card.topUp(5000);
            System.out.println(card + "\n");
            card.toPay(5000);
            System.out.println(card + "\n");
            card.toPay(3000);
            System.out.println(card + "\n");
            card.topUp(2000);
            System.out.println(card + "\n");
            card.topUp(2000);
            System.out.println(card + "\n");
        }
        System.out.println();
        {
            MirBonus mir = new MirBonus();

            System.out.println(mir+ "\n");
            mir.topUp(1500);
            System.out.println(mir+ "\n");
            mir.toPay(500);
            System.out.println(mir+ "\n");
            mir.toPay(500);
            System.out.println(mir+ "\n");
            mir.topUp(1500);
            System.out.println(mir+ "\n");
        }
        System.out.println();
        {
            MirCreditCashback cashback = new MirCreditCashback();

            System.out.println(cashback+ "\n");
            cashback.topUp(15000);
            System.out.println(cashback+ "\n");
            cashback.toPay(5000);
            System.out.println(cashback+ "\n");
            cashback.toPay(4000);
            System.out.println(cashback+ "\n");
            cashback.toPay(5500);
            System.out.println(cashback+ "\n");
        }
    }
}