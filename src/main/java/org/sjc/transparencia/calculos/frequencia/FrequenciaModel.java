package org.sjc.transparencia.calculos.frequencia;

import com.google.gson.Gson;
import org.sjc.transparencia.funcionario.Funcionario;
import org.sjc.transparencia.funcionario.FuncionarioDao;

import java.util.ArrayList;
import java.util.List;

public class FrequenciaModel {

    private FuncionarioDao funcionarioDao;
    private Gson gson;

    public FrequenciaModel() {
        this.funcionarioDao = new FuncionarioDao();
        this.gson = new Gson();
    }


    public String getFrequencias() {
        List<Funcionario> funcionarioList = this.funcionarioDao.retrieveAll();
        List<FrequenciaDto> frequencia = new ArrayList<>();


        return gson.toJson(funcionarioList);
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
