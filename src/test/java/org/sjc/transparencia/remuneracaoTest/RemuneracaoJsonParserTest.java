package org.sjc.transparencia.remuneracaoTest;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.remuneracao.RemuneracaoJsonParser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class RemuneracaoJsonParserTest {

    private JSONObject dados;
    private RemuneracaoJsonParser remuneracaoJsonParser;

    @Before
    public void setUp() {
        String jsonBulder = "{ \"data\": {\"mes\": 1, \"ano\": 2018}" + "," +
                "\"cargos\": [ \"a\", \"b\", \"c\"]" + "," +
                "\"funcionario\": [{" +
                "\"nome\": \"ABEL YOSHINOBU TAIRA\",\"cargo\": \"ANALISTA TEC.LEG-DESIGNER GRAFICO\"," +
                "\"salario_base\": 5021.76,\"plano_carreira\": 150.65,\"gratificacao\": 044.35,\"beneficio\": 374," +
                "\"abono\": 0,\"adiantamento\": 0,\"ferias\": 0,\"decimo_terceiro\": 0,\"abatimento\": 0," +
                "\"descontos\": 2702.6,\"salario_bruto\": 6590.76,\"salario_liquido\": 3888.16" +
                "}]}";
        this.dados = new JSONObject(jsonBulder);
        this.remuneracaoJsonParser = new RemuneracaoJsonParser();
    }

    @Test
    public void preparaCargos() {
        assertFalse(this.remuneracaoJsonParser.preparaCargos(this.dados.getJSONArray("cargos")).isEmpty());
    }

    @Test
    public void preparaData() {
        assertNotNull(this.remuneracaoJsonParser.preparaData(this.dados.getJSONObject("data")));
    }

    @Test
    public void preparaFuncionario() {
        assertFalse(this.remuneracaoJsonParser.preparaFuncionario(this.dados.getJSONArray("funcionario")).isEmpty());
    }
}
