package com.pim.jrgs2526.pf03;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @ParameterizedTest
    @CsvSource({
            "5,1",
            "6,1",
            "7,1",
            "8,1",
            "9,1",
            "10,1"
    })
    public void testCalcularAprobado(int note, int expected) {
        App main = new App();
        int resultado = main.calcularNota(note);
        Assertions.assertEquals(expected, resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "1,-1",
            "2,-1",
            "3,-1",
            "4,-1"
    })
    public void testCalcularSuspenso(int note, int expected) {
        App main = new App();
        int resultado = main.calcularNota(note);
        Assertions.assertEquals(expected, resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "35,Error al calcular la nota",
            "63,Error al calcular la nota",
            "72,Error al calcular la nota",
            "-8,Error al calcular la nota",
            "-96,Error al calcular la nota",
            "-14,Error al calcular la nota"
    })
    public void testCalcularError(int note, String expected) {
        App main = new App();
        try {
            int resultado = main.calcularNota(note);
        }
        catch (IllegalArgumentException e) {
            Assertions.assertEquals(expected, e.getMessage());
            return;
        }
        Assertions.fail();
    }
}
