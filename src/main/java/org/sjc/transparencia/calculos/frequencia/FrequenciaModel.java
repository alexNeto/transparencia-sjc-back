package org.sjc.transparencia.calculos.frequencia;

import com.google.gson.Gson;
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
        FrequenciaDto frequenciaDto = new FrequenciaDto();
        if (salario == TipoSalario.SALARIO_BASE) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getSalario_base()));
        }
        if (salario == TipoSalario.PLANO_CARREIRA) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getPlano_carreira()));
        }
        if (salario == TipoSalario.GRATIFICACAO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getGratificacao()));
        }
        if (salario == TipoSalario.BENEFICIO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getBeneficio()));
        }
        if (salario == TipoSalario.ABONO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getAbono()));
        }
        if (salario == TipoSalario.ADIANTEMENTO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getAdiantamento()));
        }
        if (salario == TipoSalario.FERIAS) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getFerias()));
        }
        if (salario == TipoSalario.DECIMO_TERCEIRO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getDecimo_terceiro()));
        }
        if (salario == TipoSalario.ABATIMENTO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getAbatimento()));
        }
        if (salario == TipoSalario.DESCONTOS) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getDescontos()));
        }
        if (salario == TipoSalario.SALARIO_BRUTO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getSalario_bruto()));
        }
        if (salario == TipoSalario.SALARIO_LIQUIDO) {
            funcionarioList.forEach(funcionario -> salarioList.add(funcionario.getSalario().getSalario_liquido()));
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
