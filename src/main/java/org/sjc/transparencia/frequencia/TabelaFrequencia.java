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
    }

    public Integer getxMin() {
        return xMin;
    }

    public Integer getxMax() {
        return xMax;
    }

    public Integer getFrequenciaSimples() {
        return frequenciaSimples;
    }

    public void setFrequenciaSimples(Integer frequenciaSimples) {
        this.frequenciaSimples = frequenciaSimples;
    }

    public Float getFrequenciaRelativaSimples() {
        return frequenciaRelativaSimples;
    }

    public void setFrequenciaRelativaSimples(Float frequenciaRelativaSimples) {
        this.frequenciaRelativaSimples = frequenciaRelativaSimples;
    }

    public Integer getFrequenciaAcumulada() {
        return frequenciaAcumulada;
    }

    public void setFrequenciaAcumulada(Integer frequenciaAcumulada) {
        this.frequenciaAcumulada = frequenciaAcumulada;
    }

    public Float getFrequenciaRelativaAcumulada() {
        return frequenciaRelativaAcumulada;
    }

    public void setFrequenciaRelativaAcumulada(Float frequenciaRelativaAcumulada) {
        this.frequenciaRelativaAcumulada = frequenciaRelativaAcumulada;
    }
}
