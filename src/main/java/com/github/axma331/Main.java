package com.github.axma331;

import com.github.axma331.cards.CreditCard;
import com.github.axma331.cards.DebitCard;
import com.github.axma331.cards.MirBonus;
import com.github.axma331.cards.MirCreditCashback;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        {
            DebitCard card = new DebitCard();
            System.out.println(card + "\n");
            card.topUpFunds(BigDecimal.valueOf(100));
            System.out.println(card + "\n");
            card.pay(BigDecimal.valueOf(200));
            System.out.println(card + "\n");
            card.pay(BigDecimal.valueOf(99));
            System.out.println(card + "\n");

        }
        System.out.println("CreditCard");
        {
            CreditCard card = new CreditCard();

            card.setCreditLimit(BigDecimal.valueOf(10000));
            System.out.println(card + "\n");
            card.topUpFunds(BigDecimal.valueOf(5000));
            System.out.println(card + "\n");
            card.pay(BigDecimal.valueOf(5000));
            System.out.println(card + "\n");
            card.pay(BigDecimal.valueOf(3000));
            System.out.println(card + "\n");
            card.topUpFunds(BigDecimal.valueOf(2000));
            System.out.println(card + "\n");
            card.topUpFunds(BigDecimal.valueOf(2000));
            System.out.println(card + "\n");
        }
        System.out.println("MirBonus");
        {
            MirBonus card = new MirBonus();

            System.out.println(card+ "\n");
            card.topUpFunds(BigDecimal.valueOf(1500));
            System.out.println(card+ "\n");
            card.pay(BigDecimal.valueOf(500));
            System.out.println(card+ "\n");
            card.pay(BigDecimal.valueOf(500));
            System.out.println(card+ "\n");
            card.topUpFunds(BigDecimal.valueOf(1500));
            System.out.println(card+ "\n");
        }
        System.out.println("Cashback");
        {
            MirCreditCashback card = new MirCreditCashback();

            System.out.println(card+ "\n");
            card.topUpFunds(BigDecimal.valueOf(15000));
            System.out.println(card+ "\n");
            card.pay(BigDecimal.valueOf(5000));
            System.out.println(card+ "\n");
            card.pay(BigDecimal.valueOf(4000));
            System.out.println(card+ "\n");
            card.pay(BigDecimal.valueOf(5500));
            System.out.println(card+ "\n");
        }
    }
}