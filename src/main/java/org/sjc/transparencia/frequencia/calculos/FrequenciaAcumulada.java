package org.sjc.transparencia.frequencia.calculos;

import org.sjc.transparencia.frequencia.TabelaFrequencia;

import java.math.BigDecimal;
import java.util.List;

public class FrequenciaAcumulada extends FrequenciaSimples {


    public FrequenciaAcumulada(List<BigDecimal> dadosList) {
        super(dadosList);
    }

    public List<TabelaFrequencia> calculaFrequenciaAcumulada() {
        List<TabelaFrequencia> tabelaFrequenciaList = super.calculaFrequencia();
        Integer atual;
        Integer anterior = 0;
        for (TabelaFrequencia tabelaFrequencia : tabelaFrequenciaList) {
            atual = tabelaFrequencia.getFrequenciaSimples();
            tabelaFrequencia.adicionaFrequenciaAcumulada(atual + anterior);
            anterior += atual;
        }
        return tabelaFrequenciaList;
    }
}
