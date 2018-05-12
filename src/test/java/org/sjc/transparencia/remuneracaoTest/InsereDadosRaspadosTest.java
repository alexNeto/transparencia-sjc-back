package org.sjc.transparencia.remuneracaoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.remuneracao.InsereDadosRaspados;

import static org.junit.Assert.assertTrue;


public class InsereDadosRaspadosTest {

    private InsereDadosRaspados insereDadosRaspados;

    @Before
    public void setUp() {
        this.insereDadosRaspados = new InsereDadosRaspados("https://api.myjson.com/bins/q7cq6");
    }

    @Test
    public void insere() {
        assertTrue(this.insereDadosRaspados.insere());
    }


}
