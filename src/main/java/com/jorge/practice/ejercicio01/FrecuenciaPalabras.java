package com.jorge.practice.ejercicio01;


import java.util.HashMap;
import java.util.Map;

public class FrecuenciaPalabras {
    public static Map<String, Integer> contar(String texto) {
        Map<String, Integer> frecuencia = new HashMap<>();

        if (texto == null) {
            return frecuencia;
        }

        String[] palabras = texto.toLowerCase().split("\\P{L}");

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                frecuencia.merge(palabra, 1, Integer::sum);
            }
        }

        return frecuencia;
    }

    public static void main(String[] args){
        Map<String, Integer> conteo = contar("hola mundo, desde el salvador");

        conteo.forEach((palabra, cantidad) -> {
            System.out.println(palabra + " " + cantidad);
        });
    }
}
