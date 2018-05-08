package org.sjc.transparencia.funcionario;

import com.google.gson.Gson;

import static spark.Spark.get;

public class FuncionarioController {

    private FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        this.funcionarioDao = new FuncionarioDao();
    }

    public void funcionario() {
        get("/funcionario", (req, res) -> new Gson().toJson(this.funcionarioDao.retrieveAll()));
    }
}
