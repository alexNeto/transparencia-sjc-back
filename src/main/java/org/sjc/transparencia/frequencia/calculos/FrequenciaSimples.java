package org.sjc.transparencia.frequencia.calculos;

import org.sjc.transparencia.frequencia.TabelaFrequencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class FrequenciaSimples {

    private List<BigDecimal> dadosList;
    private Integer numeroClasses;
    private Integer somatorioFrequenciaSimples;

    public FrequenciaSimples(List<BigDecimal> dadosList) {
        this.dadosList = dadosList;
        this.somatorioFrequenciaSimples = this.dadosList.size();
        this.numeroClasses = this.contaClasses();
    }

    public List<TabelaFrequencia> calculaFrequencia() {
        List<TabelaFrequencia> tabelaFrequenciaList = new ArrayList<>();
        Integer amplitude = this.calculaAmplitudeDasClasses();
        Integer xMin = this.xMin();
        Integer xMax = xMin;
        for (int i = 0; i < this.numeroClasses; i++) {
            xMax += amplitude;
            tabelaFrequenciaList.add(this.adicionaFrequenciaParaIntervalo(xMin, xMax));
            xMin = xMax;
        }
        return tabelaFrequenciaList;
    }

    public TabelaFrequencia adicionaFrequenciaParaIntervalo(Integer xMin, Integer xMax) {
        TabelaFrequencia tabelaFrequencia = new TabelaFrequencia(xMin, xMax);
        for (BigDecimal dado : dadosList) {
            if ((dado.intValue() >= xMin) && (dado.intValue() < xMax)) {
                tabelaFrequencia.adicionaFrequenciaSimples();
            }
        }
        tabelaFrequencia.calculaFrequenciaRelativa(this.somatorioFrequenciaSimples);
        return tabelaFrequencia;
    }
}
