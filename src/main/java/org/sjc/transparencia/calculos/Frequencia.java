package org.sjc.transparencia.calculos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Frequencia {

    private List<BigDecimal> dadosList;
    private Integer numeroClasses;
    private Integer tamanhoDados;

    public Frequencia(List<BigDecimal> dadosList) {
        this.dadosList = dadosList;
        this.tamanhoDados = this.dadosList.size();
        this.numeroClasses = this.contaClasses();
    }

    public Integer contaClasses() {
        return (int) ceil(1 + 3.3 * log(this.tamanhoDados));
    }

    public Integer calculaAmplitudeDasClasses() {
        this.ordenaLista();
        return (int) ceil((this.xMax() - this.xMin()) / this.numeroClasses);
    }

    public List<TabelaFrequencia> calculaFrequencia() {
        List<TabelaFrequencia> tabelaFrequenciaList = new ArrayList<>();
        TabelaFrequencia tabelaFrequencia;
        Integer amplitude = this.calculaAmplitudeDasClasses();
        Integer xMin = this.xMin();
        Integer xMax = xMin;
        for (int i = 0; i < this.numeroClasses; i++) {
            xMax += amplitude;
            tabelaFrequencia = new TabelaFrequencia(xMin, xMax);
            for (BigDecimal dado : dadosList) {
                if ((dado.intValue() >= xMin) && (dado.intValue() < xMax)) {
                    tabelaFrequencia.adicionaFrequenciaSimples();
                }
            }
            tabelaFrequencia.calculaFrequenciaRelativa(this.tamanhoDados);
            tabelaFrequenciaList.add(tabelaFrequencia);
            xMin = xMax;
        }
        return tabelaFrequenciaList;
    }

    public Integer xMin() {
        return (int) round(this.dadosList.get(0).doubleValue());
    }

    public Integer xMax() {
        return (int) floor(this.dadosList.get(this.tamanhoDados - 1).doubleValue());
    }

    private void ordenaLista() {
        this.dadosList.sort(BigDecimal::compareTo);
    }

}
