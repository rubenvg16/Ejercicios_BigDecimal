package org.example.Ejercicio_4;

import java.math.BigDecimal;
import java.math.MathContext;

public class Extensions {
    private BigDecimal RadioTierraKm = new BigDecimal("6378.0");
    private Posicion posicion;
    private Posicion posicion2;

    public Extensions(Posicion posicion2, Posicion posicion) {
        this.posicion2 = posicion2;
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion2() {
        return posicion2;
    }

    public void setPosicion2(Posicion posicion2) {
        this.posicion2 = posicion2;
    }

    public BigDecimal DistanciaKm(Posicion x, Posicion y){
        BigDecimal DiferenciaLats = x.latitud.subtract(y.latitud);
        BigDecimal DiferenciaLongs = x.longitud.subtract(y.longitud);

        //Paso de grados a radianes
        BigDecimal pi = BigDecimal.valueOf(Math.PI);
        DiferenciaLats = DiferenciaLats.multiply(pi).divide(BigDecimal.valueOf(180), MathContext.DECIMAL128);
        DiferenciaLongs = DiferenciaLongs.multiply(pi).divide(BigDecimal.valueOf(180), MathContext.DECIMAL128);

        //Calculo del seno de la diferencia de latitud y longitud al cuadrado
        BigDecimal seno = BigDecimal.valueOf(Math.sin(DiferenciaLats.doubleValue() / 2));
        BigDecimal seno2 = BigDecimal.valueOf(Math.sin(DiferenciaLongs.doubleValue() / 2));

        //Calculo de la posicion "x" e "y" en radianes
        BigDecimal Lat1 = x.latitud.multiply(pi).divide(BigDecimal.valueOf(180), MathContext.DECIMAL128);
        BigDecimal Lat2 = y.latitud.multiply(pi).divide(BigDecimal.valueOf(180), MathContext.DECIMAL128);

        //Calculo de a
        BigDecimal a = seno.pow(2).multiply(BigDecimal.valueOf(Math.cos(Lat2.doubleValue())));
        a = a.multiply(seno2.pow(2));
        a = a.add(BigDecimal.valueOf(Math.cos(Lat1.doubleValue())));

        //Calculo de c
        BigDecimal raizA = BigDecimal.valueOf(Math.sqrt(a.doubleValue()));
        BigDecimal raizB = BigDecimal.valueOf(Math.sqrt(1 - a.doubleValue()));
        BigDecimal c = BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(Math.atan2(raizA.doubleValue(), raizB.doubleValue())), MathContext.DECIMAL128);

        return c.multiply(RadioTierraKm);
    }

}
