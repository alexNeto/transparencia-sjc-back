package org.sjc.transparencia.frequencia.calculos;

import org.sjc.transparencia.frequencia.TabelaFrequencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

public class CalculaFrequencia {

    private List<TabelaFrequencia> tabelaFrequencias;
    private PreparaDadosParaAnalize dadosProntos;

    public CalculaFrequencia(List<BigDecimal> dadosList) {
        this.dadosProntos = new PreparaDadosParaAnalize(dadosList);
        this.tabelaFrequencias = new ArrayList<>();
    }

    public List<TabelaFrequencia> calcula() {
        TabelaFrequencia tabelaFrequencia;
        Integer amplitude = this.dadosProntos.calculaAmplitude(
                this.dadosProntos.procuraMinimo(), this.dadosProntos.procuraMaximo());
        Integer xMin = (int) floor(this.dadosProntos.procuraMinimo().doubleValue());
        Integer xMax = xMin;
        for (Integer i = 0; i < this.dadosProntos.calculaNumeroDeClasses(); i++) {
            xMax += xMin + amplitude;
            tabelaFrequencia = new TabelaFrequencia(xMin, xMax);
            tabelaFrequencia.setFrequenciaSimples(this.calculaFrequencia(xMin, xMax));
            xMin = xMax;
            this.tabelaFrequencias.add(tabelaFrequencia);
        }
        return this.tabelaFrequencias;
    }

    public Integer calculaFrequencia(Integer xMin, Integer xMax) {
        return (int) this.dadosProntos.criaRol().stream().filter(dados ->
                dados.doubleValue() >= xMin && dados.doubleValue() < xMax).count();
    }

}
