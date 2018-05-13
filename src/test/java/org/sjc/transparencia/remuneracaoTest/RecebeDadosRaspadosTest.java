package org.sjc.transparencia.remuneracaoTest;

import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.remuneracao.RecebeDadosRaspados;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class RecebeDadosRaspadosTest {

    private RecebeDadosRaspados recebeDadosRaspados;

    @Before
    public void setUp() {
        recebeDadosRaspados = new RecebeDadosRaspados("https://api.myjson.com/bins/1e154m");
    }

    @Test
    public void recebeJson() throws IOException {
        assertNotNull(this.recebeDadosRaspados.leJsonDaUrl());
    }
}
