package org.sjc.transparencia.data;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

public class DataController {

    private DataDao dataDao;

    public DataController() {
        this.dataDao = new DataDao();
    }

    public void data() {
        get("/data/ano=:ano", (req, res) -> dataDao.retrieveByYear(parseInt(req.params("ano"))));

        get("/data/:mes:ano", (req, res) -> {
            Data data = new Data(null, parseInt(req.params("mes")), parseInt(req.params("ano")));
            return dataDao.retrieve(data);
        });
        get("/data", (req, res) -> dataDao.retrieveAll());
    }
}
