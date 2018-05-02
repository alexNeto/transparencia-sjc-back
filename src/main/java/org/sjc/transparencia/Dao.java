package org.sjc.transparencia;

import org.sql2o.Sql2o;

public class Dao {

    private static Sql2o sql2o;

    public Dao() {
        if (sql2o == null) {
            sql2o = new Sql2o("jdbc:postgres://localhost:5432/transparencia_development", "trnsparencia", "postgres123");
        }
    }

    public Sql2o getDao() {
        return sql2o;
    }
}
