package org.sjc.transparencia.frequencia;

import java.util.List;

public class FrequenciaDto {

    private String cargo;
    private String nome;
    private String salario;
    private Integer somaFrequenciaSimples;
    private List<TabelaFrequencia> frequencia;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Integer getSomaFrequenciaSimples() {
        return somaFrequenciaSimples;
    }

    public void setSomaFrequenciaSimples(Integer somaFrequenciaSimples) {
        this.somaFrequenciaSimples = somaFrequenciaSimples;
    }

    public List<TabelaFrequencia> getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(List<TabelaFrequencia> frequencia) {
        this.frequencia = frequencia;
    }
}
