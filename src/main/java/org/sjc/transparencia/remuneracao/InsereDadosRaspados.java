package org.sjc.transparencia.remuneracao;

import org.json.JSONArray;
import org.json.JSONObject;
import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.cargo.CargoDao;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.data.DataDao;
import org.sjc.transparencia.funcionario.Funcionario;
import org.sjc.transparencia.funcionario.FuncionarioDao;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class InsereDadosRaspados {

    private RemuneracaoJsonParser parser = new RemuneracaoJsonParser();
    private CargoDao cargoDao = new CargoDao();

    public Boolean insere() {
        Boolean result;
        try {
            JSONObject remuneracao = this.pegaJson();
            UUID dataUuid = this.insereData(remuneracao.getJSONObject("data"));
            result = this.insereCargos(remuneracao.getJSONArray("cargos"));
            if (result)
                result = this.insereFuncionarios(dataUuid, remuneracao.getJSONArray("funcionario"));
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public JSONObject pegaJson() throws IOException {
        return new RecebeDadosRaspados("http://127.0.0.1:5000").leJsonDaUrl();
    }

    public UUID insereData(JSONObject dataJson) {
        Data data = this.parser.preparaData(dataJson);
        return new DataDao().insert(data);
    }

    public Boolean insereCargos(JSONArray cargoJsonArray) {
        Boolean result = true;
        try {
            List<Cargo> cargoList = this.parser.preparaCargos(cargoJsonArray);
            cargoList.forEach(cargo -> this.cargoDao.insert(cargo));
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public Boolean insereFuncionarios(UUID dataUuid, JSONArray funcionarioJsonArray) {
        Boolean result = true;
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        try {
            List<Funcionario> funcionarioList = this.parser.preparaFuncionario(funcionarioJsonArray);
            funcionarioList.forEach(funcionario -> {
                funcionario.getCargo().setCargo_uuid(this.cargoDao.retrieve(funcionario.getCargo()).getCargo_uuid());
                funcionario.getData().setData_uuid(dataUuid);
                funcionarioDao.insert(funcionario);
            });
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
