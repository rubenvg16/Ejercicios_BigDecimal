package org.example;

import java.math.BigInteger;

public class Ejercicio_1 {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("5");
        BigInteger y = new BigInteger("1");
        while (x.compareTo(BigInteger.ZERO) > 0) {
            y = y.multiply(x);
            x = x.subtract(BigInteger.ONE);
        }
        System.out.println(y);
    }
}
