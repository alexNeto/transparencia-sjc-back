package org.sjc.transparencia.remuneracao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.funcionario.Funcionario;
import org.sjc.transparencia.salario.Salario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemuneracaoModel {

    private String url = "http://127.0.0.1:5000/";
    private List<String> cargoList;
    private Funcionario funcionario;
    private Data data;

    public JSONObject leJsonDaUrl() throws IOException, JSONException {
        try (InputStream input = new URL(this.url).openStream()) {
            BufferedReader read = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            String jsonText = this.leResposta(read);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }

    public String leResposta(BufferedReader reader) throws IOException {
        StringBuilder responseBuilder = new StringBuilder();
        String linhaResposta;
        while (((linhaResposta = reader.readLine())) != null) {
            responseBuilder.append(linhaResposta);
        }
        return responseBuilder.toString();
    }

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
