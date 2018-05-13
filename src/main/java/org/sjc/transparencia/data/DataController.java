package org.sjc.transparencia.data;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;

import static java.lang.Integer.parseInt;
import static spark.Spark.get;

public class DataController {

    private DataModel dataModel;

    public DataController() {
        this.dataModel = new DataModel();
    }

    public void data() {
        get("/data", (req, res) -> this.dataModel.getdata());
        get("/data/algo", (req, res) -> Calendar.getInstance());
        get("/data/:ano", (req, res) -> this.dataModel.getDataPorAno(req.params("ano")));
        get("/data/:mes/:ano", (req, res) ->
                this.dataModel.getDataPorAnoEMes(req.params("mes"), req.params("ano")));
    }
}
