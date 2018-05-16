package org.sjc.transparencia.calculos.frequencia;

import org.sjc.transparencia.funcionario.FuncionarioDao;

public class FrequenciaModel {

    private FuncionarioDao funcionarioDao;

    public FrequenciaModel() {
        this.funcionarioDao = new FuncionarioDao();
    }


    public String getFrequencias() {
        return null;
    }

    public String getFrequenciasPorCargo(String cargo) {
        return null;
    }

    public String getFrequenciasPorCargoENome(String cargo, String nome) {
        return null;
    }

    public String getFrequenciasPorSalario(String salario) {
        return null;
    }

    public String getFrequenciasPorSalarioENome(String salario, String nome) {
        return null;
    }

    public String getFrequenciasPorCargoESalario(String cargo, String salario) {
        return null;
    }
}
