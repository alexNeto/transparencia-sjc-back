package org.sjc.transparencia.cargo;

import org.sjc.transparencia.Dao;
import org.sjc.transparencia.data.Data;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.UUID;

public class CargoDao {
    private Sql2o connection;

    public CargoDao() {
        this.connection = Dao.getConnection();
    }

    public List<Cargo> retrieveAll() {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from cargo")
                    .executeAndFetch(Cargo.class);
        }
    }

    public Cargo retrieveByUuid(UUID cargoUuid) {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from cargo where cargo_uuid=:cargo_uuid")
                    .addParameter("cargo_uuid", cargoUuid)
                    .executeAndFetch(Cargo.class).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public UUID insert(Cargo cargo) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("insert into cargo");
        queryBuilder.append("(cargo_uuid, cargo) ");
        queryBuilder.append("values");
        queryBuilder.append("(:cargo_uuid, :cargo)");
        try (Connection conn = connection.beginTransaction()) {
            UUID dataUuid = UUID.randomUUID();
            conn.createQuery(queryBuilder.toString())
                    .addParameter("cargo_uuid", cargo.getCargo_uuid())
                    .addParameter("cargo", cargo.getCargo())
                    .executeUpdate();
            conn.commit();
            return dataUuid;
        }
    }

    public Boolean delete(UUID cargoUuid) {
        try (Connection conn = connection.open()) {
            conn.createQuery("delete from cargo where cargo_uuid=:cargo_uuid")
                    .addParameter("cargo_uuid", cargoUuid)
                    .executeUpdate();
            return true;
        } catch (Sql2oException e) {
            return false;
        }
    }
}
