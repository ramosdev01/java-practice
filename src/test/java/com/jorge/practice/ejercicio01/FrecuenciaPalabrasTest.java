package com.jorge.practice.ejercicio01;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrecuenciaPalabrasTest {

    @Test
    void cuentaPalabrasSinImportarMayusculas() {
        Map<String, Integer> resultado = FrecuenciaPalabras.contar("Hola mundo hola");
        assertEquals(Map.of("hola", 2, "mundo", 1), resultado);
    }

    @Test
    void ignoraSignosDePuntuacion() {
        Map<String, Integer> resultado = FrecuenciaPalabras.contar("El sol, el mar. ¡El cielo!");
        assertEquals(Map.of("el", 3, "sol", 1, "mar", 1, "cielo", 1), resultado);
    }

    @Test
    void textoSoloConEspaciosDevuelveMapaVacio() {
        assertTrue(FrecuenciaPalabras.contar("   ").isEmpty());
    }

    @Test
    void textoNullDevuelveMapaVacio() {
        assertTrue(FrecuenciaPalabras.contar(null).isEmpty());
    }

    @Test
    void respetaTildesYEnie() {
        Map<String, Integer> resultado = FrecuenciaPalabras.contar("La canción del niño, la canción");
        assertEquals(Map.of("la", 2, "canción", 2, "del", 1, "niño", 1), resultado);
    }

    @Test
    void cuentaPalabrasSinImportarSignos() {
        Map<String, Integer> resultado = FrecuenciaPalabras.contar("!Hola mundo, el mundo te da la bienvenida?.");
        assertEquals(Map.of("hola", 1, "mundo", 2, "el", 1, "te", 1, "da", 1, "la", 1, "bienvenida", 1), resultado);
    }

    @Test
    void textoSoloSignosDevuelveMapaVacio() {
        assertTrue(FrecuenciaPalabras.contar("????!!!!!..... ??.. [[[[]]]]").isEmpty());
    }

    @Test
    void textoVacioDevuelveMapaVacio() {
        assertTrue(FrecuenciaPalabras.contar("").isEmpty());
    }
}
