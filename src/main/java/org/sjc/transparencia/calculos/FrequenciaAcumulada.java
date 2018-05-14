package org.sjc.transparencia.calculos;

import java.math.BigDecimal;
import java.util.List;

public class FrequenciaAcumulada extends Frequencia {


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
