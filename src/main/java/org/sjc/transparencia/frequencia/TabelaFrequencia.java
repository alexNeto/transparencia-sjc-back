package org.sjc.transparencia.frequencia;

public class TabelaFrequencia {
    private Integer xMin;
    private Integer xMax;
    private Integer frequenciaSimples;
    private Float frequenciaRelativaSimples;
    private Integer frequenciaAcumulada;
    private Float frequenciaRelativaAcumulada;

    public TabelaFrequencia(Integer xMin, Integer xMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.frequenciaSimples = 0;
    }

    public void adicionaFrequenciaSimples() {
        this.frequenciaSimples++;
    }

    public void calculaFrequenciaRelativa(Integer somatorioFrequenciaSimples) {
        this.frequenciaRelativaSimples = (float) (this.frequenciaSimples / somatorioFrequenciaSimples);
    }

    public Integer getFrequenciaSimples() {
        return this.frequenciaSimples;
    }

    public void adicionaFrequenciaAcumulada(Integer frequenciaAcumulada) {
        this.frequenciaAcumulada = frequenciaAcumulada;
    }
}
