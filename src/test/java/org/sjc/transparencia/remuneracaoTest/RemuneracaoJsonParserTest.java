package org.sjc.transparencia.remuneracaoTest;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.remuneracao.RecebeDadosRaspados;
import org.sjc.transparencia.remuneracao.RemuneracaoJsonParser;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemuneracaoJsonParserTest {

    private JSONObject dados;
    private RemuneracaoJsonParser remuneracaoJsonParser;

    @Before
    public void setUp() throws IOException {
        this.dados = new RecebeDadosRaspados().leJsonDaUrl();
        this.remuneracaoJsonParser = new RemuneracaoJsonParser();
    }

    @Test
    public void preparaCargos() {
        assertFalse(this.remuneracaoJsonParser.preparaCargos(this.dados.getJSONArray("cargos")).isEmpty());
    }

    @Test
    public void preparaData() {
        assertTrue(this.remuneracaoJsonParser.preparaData(this.dados.getJSONObject("data")) != null);
    }

    @Test
    public void preparaFuncionario() {
        assertFalse(this.remuneracaoJsonParser.preparaFuncionario(this.dados.getJSONArray("funcionario")).isEmpty());
    }
}
