package org.example.Ejercicio_4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class main {
    public static void main(String[] args) {
        BigDecimal latitud_gra = new BigDecimal("37.18817");
        BigDecimal longitud_gra = new BigDecimal("-3.60667");
        BigDecimal latitud_igu = new BigDecimal("41.5809800");
        BigDecimal longitud_igu = new BigDecimal("1.6172000");

        //Definicion de las posiciones de las ciudades
        Posicion granada = new Posicion(latitud_gra, longitud_gra);
        Posicion igualada = new Posicion(latitud_igu, longitud_igu);

        //Definición de la clase "extensions" para calcular la distancia
        Extensions x = new Extensions(granada, igualada);
        System.out.println("La distancia de Granada a Igualada es de " + x.DistanciaKm(granada,igualada).setScale(2, RoundingMode.HALF_UP) + " kilometros");


    }
}
