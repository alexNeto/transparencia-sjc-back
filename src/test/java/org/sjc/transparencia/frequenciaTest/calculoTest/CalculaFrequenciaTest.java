package org.sjc.transparencia.frequenciaTest.calculoTest;

import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.frequencia.calculos.CalculaFrequencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculaFrequenciaTest {

    private CalculaFrequencia calculaFrequencia;
    private List<BigDecimal> amostraDeDados;

    @Before
    public void setUp() {
        this.amostraDeDados = new ArrayList<>();
        for (Integer i = 0; i < 10; i++) {
            this.amostraDeDados.add(new BigDecimal(i.toString()));
        }
        this.calculaFrequencia = new CalculaFrequencia(this.amostraDeDados);
    }

    @Test
    public void testaCalculo() {

    }

    @Test
    public void testaFrequenca() {
        assertEquals(new Integer("2"), this.calculaFrequencia.calculaFrequencia(new Integer("0"), new Integer("2")));
    }


}
