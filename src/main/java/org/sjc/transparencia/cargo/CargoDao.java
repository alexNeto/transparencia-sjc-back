package org.sjc.transparencia.cargo;

import org.sjc.transparencia.Dao;
import org.sjc.transparencia.Model;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.UUID;

public class CargoDao implements Model<Cargo> {
    private Sql2o connection;

    public CargoDao() {
        this.connection = Dao.getConnection();
    }

    @Override
    public List<Cargo> retrieveAll() {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from cargo")
                    .executeAndFetch(Cargo.class);
        }
    }

    @Override
    public Cargo retrieveByUuid(UUID uuid) {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from cargo where cargo_uuid=:cargo_uuid")
                    .addParameter("cargo_uuid", uuid)
                    .executeAndFetch(Cargo.class).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public Cargo retrieve(Cargo cargo) {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from cargo where cargo=:cargo")
                    .addParameter("cargo", cargo.getCargo())
                    .executeAndFetch(Cargo.class).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public UUID insert(Cargo cargo) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("insert into cargo");
        queryBuilder.append("(cargo_uuid, cargo) ");
        queryBuilder.append("values");
        queryBuilder.append("(:cargo_uuid, :cargo)");
        try (Connection conn = connection.beginTransaction()) {
            UUID uuid = cargo.getCargo_uuid() != null ? cargo.getCargo_uuid() : UUID.randomUUID();
            conn.createQuery(queryBuilder.toString())
                    .addParameter("cargo_uuid", uuid)
                    .addParameter("cargo", cargo.getCargo())
                    .executeUpdate();
            conn.commit();
            return uuid;
        }
    }

    @Override
    public Boolean delete(UUID uuid) {
        try (Connection conn = connection.open()) {
            conn.createQuery("delete from cargo where cargo_uuid=:cargo_uuid")
                    .addParameter("cargo_uuid", uuid)
                    .executeUpdate();
            return true;
        } catch (Sql2oException e) {
            return false;
        }
    }
}
