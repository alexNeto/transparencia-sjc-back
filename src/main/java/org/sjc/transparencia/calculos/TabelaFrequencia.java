package org.sjc.transparencia.calculos;

public class TabelaFrequencia {
    private Integer xMin;
    private Integer xMax;
    private Integer frequenciaSimples;
    private Float fri;
    private Integer Fi;
    private Float Fri;
    private Integer somaFi;

    public TabelaFrequencia(Integer xMin, Integer xMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.frequenciaSimples = 0;
    }

    public void adicionaFrequenciaSimples() {
        this.frequenciaSimples++;
    }

    public void adicionaFrequenciaAcumulada(Integer Fi) {
        this.Fi = Fi;
        this.Fri = (float) (this.Fi / this.somaFi);
    }

    public void calculaFrequenciaRelativa(Integer somaFi) {
        this.somaFi = somaFi;
        this.fri = (float) (this.frequenciaSimples / this.somaFi);
    }

    public Integer getFrequenciaSimples() {
        return this.frequenciaSimples;
    }
}
