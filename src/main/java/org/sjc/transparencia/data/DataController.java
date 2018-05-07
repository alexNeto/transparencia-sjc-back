package org.sjc.transparencia.data;

import com.google.gson.Gson;

import static java.lang.Integer.parseInt;
import static spark.Spark.get;

public class DataController {

    private DataDao dataDao;

    public DataController() {
        this.dataDao = new DataDao();
    }

    public void data() {
        get("/data/:ano", (req, res) -> new Gson().toJson(dataDao.retrieveByYear(parseInt(req.params("ano")))));
        get("/data/:mes/:ano", (req, res) -> {
            Data data = new Data(null, parseInt(req.params("mes")), parseInt(req.params("ano")));
            return new Gson().toJson(dataDao.retrieve(data));
        });
        get("/data", (req, res) -> new Gson().toJson(dataDao.retrieveAll()));
    }
}
