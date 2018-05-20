package org.sjc.transparencia.frequencia;

import com.google.gson.Gson;
import org.sjc.transparencia.frequencia.calculos.FrequenciaAcumulada;
import org.sjc.transparencia.funcionario.Funcionario;
import org.sjc.transparencia.funcionario.FuncionarioDao;

import java.math.BigDecimal;
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
        FrequenciaDto frequenciaDto;
        for (TipoSalario salario : TipoSalario.values()) {
            frequenciaDto = new FrequenciaDto();
            frequenciaDto.setFrequencia(new FrequenciaAcumulada(
                    this.criaListaParaSalarioSelecionado(funcionarioList, salario)).calculaFrequenciaAcumulada());
            frequenciaDto.setCargo("todos");
            frequenciaDto.setNome("todos");
            frequenciaDto.setSalario(salario.toString());
            frequencia.add(frequenciaDto);
        }

        return gson.toJson(frequencia);
    }

    private List<BigDecimal> criaListaParaSalarioSelecionado(List<Funcionario> funcionarioList, TipoSalario salario) {
        List<BigDecimal> salarioList = new ArrayList<>();

        switch (salario) {
            case SALARIO_BASE:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getSalario_base()));
                break;
            case PLANO_CARREIRA:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getPlano_carreira()));
                break;
            case GRATIFICACAO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getGratificacao()));
                break;
            case BENEFICIO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getBeneficio()));
                break;
            case ABONO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getAbono()));
                break;
            case ADIANTEMENTO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getAdiantamento()));
                break;
            case FERIAS:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getFerias()));
                break;
            case DECIMO_TERCEIRO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getDecimo_terceiro()));
                break;
            case ABATIMENTO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getAbatimento()));
                break;
            case DESCONTOS:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getDescontos()));
                break;
            case SALARIO_BRUTO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getSalario_bruto()));
                break;
            case SALARIO_LIQUIDO:
                funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getSalario_liquido()));
                break;
        }
        return salarioList;
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

