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
        StringBuilder jsonBulder = new StringBuilder();
        jsonBulder.append("{ \"data\": {\"mes\": 1, \"ano\": 2018}").append(",");
        jsonBulder.append("\"cargos\": [ \"a\", \"b\", \"c\"]").append(",");
        jsonBulder.append("\"funcionario\": [{");
        jsonBulder.append("\"nome\": \"ABEL YOSHINOBU TAIRA\",\"cargo\": \"ANALISTA TEC.LEG-DESIGNER GRAFICO\",");
        jsonBulder.append("\"salario_base\": 5021.76,\"plano_carreira\": 150.65,\"gratificacao\": 044.35,\"beneficio\": 374,");
        jsonBulder.append("\"abono\": 0,\"adiantamento\": 0,\"ferias\": 0,\"decimo_terceiro\": 0,\"abatimento\": 0,");
        jsonBulder.append("\"descontos\": 2702.6,\"salario_bruto\": 6590.76,\"salario_liquido\": 3888.16");
        jsonBulder.append("}]}");
        this.dados = new JSONObject(jsonBulder.toString());
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
