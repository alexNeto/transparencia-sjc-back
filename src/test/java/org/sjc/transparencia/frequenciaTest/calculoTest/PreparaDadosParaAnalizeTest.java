package org.sjc.transparencia.frequenciaTest.calculoTest;

import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.frequencia.calculos.PreparaDadosParaAnalize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreparaDadosParaAnalizeTest {

    private PreparaDadosParaAnalize preparaDadosParaAnalize;
    private List<BigDecimal> amostraDeDados;

    @Before
    public void setUp() {
        this.amostraDeDados = new ArrayList<>();
        for (Integer i = 0; i < 10; i++) {
            this.amostraDeDados.add(new BigDecimal(i.toString()));
        }
        this.preparaDadosParaAnalize = new PreparaDadosParaAnalize(this.amostraDeDados);
    }

    @Test
    public void geraRol() {
        this.amostraDeDados.sort(BigDecimal::compareTo);
        this.preparaDadosParaAnalize.criaRol();
        assertEquals(this.amostraDeDados, this.preparaDadosParaAnalize.getRol());
    }

    @Test
    public void pegaMaximo() {
        this.amostraDeDados.add(new BigDecimal("100"));
        assertEquals(new BigDecimal("100"), this.preparaDadosParaAnalize.procuraMaximo());
    }

    @Test
    public void pegaMinimo() {
        this.amostraDeDados.add(new BigDecimal("-100"));
        assertEquals(new BigDecimal("-100"), this.preparaDadosParaAnalize.procuraMinimo());
    }

    @Test
    public void calculaNumeroDeClasses() {
        assertEquals(new Integer("5"), this.preparaDadosParaAnalize.calculaNumeroDeClasses());
    }

    @Test
    public void calculaAmplitudeDasClasses() {
        BigDecimal min = this.preparaDadosParaAnalize.procuraMinimo();
        BigDecimal max = this.preparaDadosParaAnalize.procuraMaximo();
        assertEquals(new Integer("2"), this.preparaDadosParaAnalize.calculaAmplitude(min, max));
    }
}
