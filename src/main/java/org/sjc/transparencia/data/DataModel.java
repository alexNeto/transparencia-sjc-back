package org.sjc.transparencia.data;

import com.google.gson.Gson;

import java.util.List;

import static java.lang.Integer.parseInt;

public class DataModel {

    private DataDao dataDao;

    public DataModel() {
        this.dataDao = new DataDao();
    }

    public String getdata() {
        return new Gson().toJson(this.dataDao.retrieveAll());
    }

    public String getDataPorAno(String ano) {
        List<Data> dataList = this.dataDao.retrieveByYear(parseInt(ano));
        return new Gson().toJson(dataList);
    }

    public String getDataPorAnoEMes(String mes, String ano) {
        Data data = new Data(parseInt(mes), parseInt(ano));
        return new Gson().toJson(dataDao.retrieve(data));
    }
}
