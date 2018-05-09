package org.sjc.transparencia;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;

import java.util.UUID;

public class Dao {

    private static Sql2o connection;


    public static Sql2o connect() {
        connection = new Sql2o("jdbc:postgresql://localhost:5432/transparencia_development",
                "postgres", "", new PostgresQuirks() {
            {
                converters.put(UUID.class, new UUIDConverter());
            }
        });
        return connection;
    }

    public static Sql2o getConnection() {
        if (connection == null) {
            connection = connect();
            createAllTables();
        }
        return connection;
    }

    public static Boolean createAllTables() {
        Boolean result = true;

        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append(data());
        tableBuilder.append(cargo());
        tableBuilder.append(salario());
        tableBuilder.append(funcionario());

        try (Connection conn = connection.open()) {
            conn.createQuery(tableBuilder.toString())
                    .executeUpdate();
        } catch (Sql2oException e) {
            result = false;
        }
        return result;
    }

    public static StringBuilder data() {
        StringBuilder dataBuilder = new StringBuilder();
        dataBuilder.append("create table if not exists data (");
        dataBuilder.append("data_uuid uuid primary key,");
        dataBuilder.append("mes integer not null,");
        dataBuilder.append("ano integer not null");
        dataBuilder.append(");");
        return dataBuilder;
    }

    public static StringBuilder cargo() {
        StringBuilder cargoBuilder = new StringBuilder();
        cargoBuilder.append("create table if not exists cargo(");
        cargoBuilder.append("cargo_uuid uuid primary key,");
        cargoBuilder.append("cargo text");
        cargoBuilder.append(");");
        return cargoBuilder;
    }

    public static StringBuilder salario() {
        StringBuilder salarioBuilder = new StringBuilder();
        salarioBuilder.append("create table if not exists salario(");
        salarioBuilder.append("salario_uuid uuid primary key,");
        salarioBuilder.append("salario_base numeric,");
        salarioBuilder.append("plano_carreira numeric,");
        salarioBuilder.append("gratificacao numeric,");
        salarioBuilder.append("beneficio numeric,");
        salarioBuilder.append("abono numeric,");
        salarioBuilder.append("adiantamento numeric,");
        salarioBuilder.append("ferias numeric,");
        salarioBuilder.append("decimo_terceiro numeric,");
        salarioBuilder.append("abatimento numeric,");
        salarioBuilder.append("descontos numeric,");
        salarioBuilder.append("salario_bruto numeric,");
        salarioBuilder.append("salario_liquido numeric");
        salarioBuilder.append(");");
        return salarioBuilder;
    }

    public static StringBuilder funcionario() {
        StringBuilder funcionarioBuilder = new StringBuilder();
        funcionarioBuilder.append("create table if not exists funcionario(");
        funcionarioBuilder.append("funcionario_uuid uuid primary key, ");
        funcionarioBuilder.append("data_uuid uuid references data, ");
        funcionarioBuilder.append("cargo_uuid uuid references cargo, ");
        funcionarioBuilder.append("salario_uuid uuid references salario, ");
        funcionarioBuilder.append("nome text not null");
        funcionarioBuilder.append(");");
        return funcionarioBuilder;
    }
}
