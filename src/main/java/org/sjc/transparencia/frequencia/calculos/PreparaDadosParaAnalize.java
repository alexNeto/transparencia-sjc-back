package org.sjc.transparencia.frequencia.calculos;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.ceil;
import static java.lang.Math.log10;

public class PreparaDadosParaAnalize {

    private List<BigDecimal> rol;
    private List<BigDecimal> dadosNaoOrganizados;
    private Integer quantidadeClasses;
    private Integer amplitude;

    public PreparaDadosParaAnalize(List<BigDecimal> dadosNaoOrganizados) {
        this.dadosNaoOrganizados = dadosNaoOrganizados;
    }

    public List<BigDecimal> criaRol() {
        this.rol = this.dadosNaoOrganizados;
        this.rol.sort(BigDecimal::compareTo);
        return this.rol;
    }

    public BigDecimal procuraMaximo() {
        return Collections.max(dadosNaoOrganizados);
    }

    public BigDecimal procuraMinimo() {
        return Collections.min(dadosNaoOrganizados);
    }

    public List<BigDecimal> getRol() {
        return this.rol;
    }

    public Integer calculaNumeroDeClasses() {
        this.quantidadeClasses = (int) ceil(1 + 3.3 * log10(this.dadosNaoOrganizados.size()));
        return this.quantidadeClasses;
    }

    public Integer calculaAmplitude(BigDecimal min, BigDecimal max) {
        this.amplitude =
                (int) ceil((max.doubleValue() - min.doubleValue()) / this.calculaNumeroDeClasses());
        return this.amplitude;
    }
}
