package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ejercicio_2 {
    public static void main(String[] args) {
        BigDecimal principal = new BigDecimal("10000.00");
        BigDecimal interes = new BigDecimal("0.05");
        int anios = 10;
        int t = 4;
        BigDecimal uno = BigDecimal.ONE;
        BigDecimal interes_dividido = interes.divide(new BigDecimal(t), 10, RoundingMode.HALF_UP);
        BigDecimal exponente = new BigDecimal(t * anios);
        BigDecimal base = uno.add(interes_dividido);
        BigDecimal resultado = principal.multiply(base.pow(exponente.intValueExact()));

        System.out.println("Después de " + anios + " años, habrá ahorrado un total de: " + resultado.setScale(2, RoundingMode.HALF_UP));
    }
}
