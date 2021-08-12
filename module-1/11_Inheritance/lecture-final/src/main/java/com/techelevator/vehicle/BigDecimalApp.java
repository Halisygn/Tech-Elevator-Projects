package com.techelevator.vehicle;

import java.math.BigDecimal;

public class BigDecimalApp {

    public static void main(String[] args) {

        double d = 2.0;
        for (int i = 0; i < 100; i++) {
            d += 0.2;
        }
        System.out.println(d);

        BigDecimal bd = new BigDecimal("2.0");
        //BigDecimal incr = new BigDecimal(0.2);
        double incr = 0.2;
        for (int i = 0; i < 100; i++) {
            bd = bd.add(new BigDecimal(incr));
        }
        System.out.println(bd);

        BigDecimal bigNumber = new BigDecimal("123789");
        BigDecimal littleNumber = new BigDecimal("0.001");

        if (bigNumber.compareTo(littleNumber) >= 0) {
            System.out.println("bigNumber is bigger or equal to littleNumber");
        }
    }
}
