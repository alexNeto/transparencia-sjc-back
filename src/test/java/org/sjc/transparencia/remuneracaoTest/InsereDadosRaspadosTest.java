package org.sjc.transparencia.remuneracaoTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.cargo.CargoDao;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.data.DataDao;
import org.sjc.transparencia.funcionario.Funcionario;
import org.sjc.transparencia.funcionario.FuncionarioDao;
import org.sjc.transparencia.remuneracao.InsereDadosRaspados;
import org.sjc.transparencia.remuneracao.RecebeDadosRaspados;
import org.sjc.transparencia.remuneracao.RemuneracaoJsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;


public class InsereDadosRaspadosTest {

    private InsereDadosRaspados insereDadosRaspados;
    private String url = "https://api.myjson.com/bins/1e154m";
    private RemuneracaoJsonParser parser;

    @Before
    public void setUp() {
        this.insereDadosRaspados = new InsereDadosRaspados(this.url);
    }

    @After
    public void apagaDados() throws IOException {
        JSONObject dadosJson = new RecebeDadosRaspados(this.url).leJsonDaUrl();
        this.parser = new RemuneracaoJsonParser();
        this.apagaData(dadosJson.getJSONObject("data"));
        this.apagaCargos(dadosJson.getJSONArray("cargos"));
        this.apagaFuncionarios(dadosJson.getJSONArray("funcionario"));
    }

    @Test
    public void insere() {
        assertTrue(this.insereDadosRaspados.insere());
    }

    private void apagaData(JSONObject dataJson) {
        Data data = this.parser.preparaData(dataJson);
        DataDao dataDao = new DataDao();
        Data dataDoBD = dataDao.retrieve(data);
        if (dataDoBD != null && dataDoBD.getData_uuid() != null)
            dataDao.delete(dataDoBD.getData_uuid());
    }

    private void apagaCargos(JSONArray cargos) {
        List<Cargo> cargoList = this.parser.preparaCargos(cargos);
        cargoList.forEach(this::deletaCargo);
    }

    private void deletaCargo(Cargo cargo) {
        CargoDao cargoDao = new CargoDao();
        Cargo cargoDoBD = cargoDao.retrieve(cargo);
        if (cargoDoBD != null && cargoDoBD.getCargo_uuid() != null)
            cargoDao.delete(cargoDoBD.getCargo_uuid());
    }

    private void apagaFuncionarios(JSONArray funcionarios) {
        List<Funcionario> funcionarioList = this.parser.preparaFuncionario(funcionarios);
        funcionarioList.forEach((this::deletaFuncionario));

    }

    private void deletaFuncionario(Funcionario funcionario) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionarioDoBD = funcionarioDao.retrieve(funcionario);
        if ((funcionarioDoBD != null) && (funcionarioDoBD.getFuncionario_uuid() != null))
            funcionarioDao.delete(funcionarioDoBD.getFuncionario_uuid());
    }
}
