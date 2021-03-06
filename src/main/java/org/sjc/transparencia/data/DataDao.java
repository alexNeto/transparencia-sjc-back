package org.sjc.transparencia.data;

import org.sjc.transparencia.Dao;
import org.sjc.transparencia.Model;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.UUID;

public class DataDao implements Model<Data> {

    private Sql2o connection;

    public DataDao() {
        this.connection = Dao.getConnection();
    }

    @Override
    public List<Data> retrieveAll() {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from data")
                    .executeAndFetch(Data.class);
        }
    }

    public List<Data> retrieveByYear(Integer ano) {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from data where ano=:ano")
                    .addParameter("ano", ano)
                    .executeAndFetch(Data.class);
        }
    }

    @Override
    public Data retrieveByUuid(UUID uuid) {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from data where data_uuid=:data_uuid")
                    .addParameter("data_uuid", uuid)
                    .executeAndFetch(Data.class).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public Data retrieve(Data data) {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from data where mes=:mes and ano=:ano")
                    .addParameter("mes", data.getMes())
                    .addParameter("ano", data.getAno())
                    .executeAndFetch(Data.class).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public UUID insert(Data data) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("insert into data");
        queryBuilder.append("(data_uuid, mes, ano) ");
        queryBuilder.append("values");
        queryBuilder.append("(:data_uuid, :mes, :ano)");
        try (Connection conn = connection.beginTransaction()) {
            UUID uuid = data.getData_uuid() != null ? data.getData_uuid() : UUID.randomUUID();
            conn.createQuery(queryBuilder.toString())
                    .addParameter("data_uuid", uuid)
                    .addParameter("mes", data.getMes())
                    .addParameter("ano", data.getAno())
                    .executeUpdate();
            conn.commit();
            return uuid;
        }
    }

    @Override
    public Boolean delete(UUID uuid) {
        try (Connection conn = connection.open()) {
            conn.createQuery("delete from data where data_uuid=:data_uuid")
                    .addParameter("data_uuid", uuid)
                    .executeUpdate();
            return true;
        } catch (Sql2oException e) {
            return false;
        }
    }
}