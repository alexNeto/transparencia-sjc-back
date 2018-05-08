package org.sjc.transparencia.salario;

import com.google.gson.Gson;

import static spark.Spark.get;

public class SalarioController {

    private SalarioDao salarioDao;

    public SalarioController() {
        this.salarioDao = new SalarioDao();
    }

    public void salario() {
        get("/salario", (req, res) -> new Gson().toJson(salarioDao.retrieveAll()));
    }
}
