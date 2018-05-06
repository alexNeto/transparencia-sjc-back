package org.sjc.transparencia.data;

import org.sjc.transparencia.Dao;
import org.sjc.transparencia.Post;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class DataDao {

    private Sql2o connection;

    public DataDao() {
        this.connection = Dao.getConnection();
    }

    public List<Data> retrieveAllData() {
        try (Connection conn = connection.open()) {
            List<Data> datas = conn.createQuery("select * from data")
                    .executeAndFetch(Data.class);
            return datas;
        }
    }


    public List<Data> retrieveByYear(Integer ano) {
        try (Connection conn = connection.open()) {
            List<Data> datas = conn.createQuery("select * from data where ano=:ano")
                    .addParameter("ano", ano)
                    .executeAndFetch(Data.class);
            return datas;
        }
    }

    public Data retrieveById(Integer data_id) {
        // TODO - implements
        return null;
    }

    public Data retrieveDataId(Data data) {
        // TODO - implements
        return null;
    }

    public Boolean insertData(Data data) {
        // TODO - implements
        return null;
    }
}
