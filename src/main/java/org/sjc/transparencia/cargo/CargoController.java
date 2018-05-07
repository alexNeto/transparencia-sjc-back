package org.sjc.transparencia.cargo;

import com.google.gson.Gson;

import static spark.Spark.get;

public class CargoController {
    private CargoDao cargoDao;

    public CargoController() {
        this.cargoDao = new CargoDao();
    }

    public void cargo() {
        get("/cargo", (req, res) -> new Gson().toJson(cargoDao.retrieveAll()));
    }
}
