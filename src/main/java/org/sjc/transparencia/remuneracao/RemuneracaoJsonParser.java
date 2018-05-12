package org.sjc.transparencia.remuneracao;

import org.json.JSONArray;
import org.json.JSONObject;
import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.funcionario.Funcionario;
import org.sjc.transparencia.salario.Salario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemuneracaoJsonParser {

    public List<Cargo> preparaCargos(JSONArray cargosJsonArray) {
        List<Cargo> cargoList = new ArrayList<>();
        Cargo cargo;
        Iterator<Object> cargoIterator = cargosJsonArray.iterator();
        while (cargoIterator.hasNext()) {
            cargo = new Cargo(null, cargoIterator.next().toString());
            cargoList.add(cargo);
        }
        return cargoList;
    }

    public Data preparaData(JSONObject dataJsonObject) {
        Integer mes = dataJsonObject.getInt("mes");
        Integer ano = dataJsonObject.getInt("ano");
        return new Data(null, mes, ano);
    }

    public List<Funcionario> preparaFuncionario(JSONArray funcionarioJsonArray) {
        Iterator<Object> funcionarioIterator = funcionarioJsonArray.iterator();
        List<Funcionario> funcionarioList = new ArrayList<>();
        while (funcionarioIterator.hasNext()) {
            funcionarioList.add(this.resolveFuncionario((JSONObject) funcionarioIterator.next()));
        }
        return funcionarioList;
    }

    private Funcionario resolveFuncionario(JSONObject funcionarioJsonObject) {
        Cargo cargo = new Cargo(null, funcionarioJsonObject.getString("cargo"));
        Salario salario = this.preparaSalario(funcionarioJsonObject);
        Funcionario funcionario = new Funcionario(null, null, cargo, salario,
                funcionarioJsonObject.getString("nome"));
        return funcionario;
    }

    public Salario preparaSalario(JSONObject funcionarioJsonObject) {
        Salario salario = new Salario(null,
                funcionarioJsonObject.getBigDecimal("salario_base"),
                funcionarioJsonObject.getBigDecimal("plano_carreira"),
                funcionarioJsonObject.getBigDecimal("gratificacao"),
                funcionarioJsonObject.getBigDecimal("beneficio"),
                funcionarioJsonObject.getBigDecimal("abono"),
                funcionarioJsonObject.getBigDecimal("adiantamento"),
                funcionarioJsonObject.getBigDecimal("ferias"),
                funcionarioJsonObject.getBigDecimal("decimo_terceiro"),
                funcionarioJsonObject.getBigDecimal("abatimento"),
                funcionarioJsonObject.getBigDecimal("descontos"),
                funcionarioJsonObject.getBigDecimal("salario_bruto"),
                funcionarioJsonObject.getBigDecimal("salario_liquido"));
        return salario;
    }
}
