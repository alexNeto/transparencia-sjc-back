package org.sjc.transparencia.calculos;

public class TabelaFrequencia {
    private Integer xMin;
    private Integer xMax;
    private Integer fi;
    private Integer fri;
    private Integer Fi;
    private Integer Fri;
    private Integer somaFi;
    private Integer somaFri;

    public TabelaFrequencia(Integer xMin, Integer xMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.fi = 0;
    }

    public void adicionaFi() {
        this.fi++;
    }


}
