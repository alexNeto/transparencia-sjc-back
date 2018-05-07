package org.sjc.transparencia.salario;

import static spark.Spark.get;

public class SalarioController {

    private SalarioDao salarioDao;

    public SalarioController() {
        this.salarioDao = new SalarioDao();
    }

    public void salario() {
        get("/salario", (req, res) -> salarioDao.retrieveAll());
    }
}
