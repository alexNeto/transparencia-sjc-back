package org.sjc.transparencia.salario;

import org.sjc.transparencia.Dao;
import org.sjc.transparencia.Model;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.UUID;

public class SalarioDao implements Model<Salario> {

    private Sql2o connection;

    public SalarioDao() {
        this.connection = Dao.getConnection();
    }

    @Override
    public List<Salario> retrieveAll() {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from salario")
                    .executeAndFetch(Salario.class);
        }
    }

    @Override
    public Salario retrieveByUuid(UUID uuid) {
        try (Connection conn = connection.open()) {
            return conn.createQuery("select * from salario where salario_uuid=:salario_uuid")
                    .addParameter("salario_uuid", uuid)
                    .executeAndFetch(Salario.class).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public Salario retrieve(Salario salario) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select * from data where ");
        queryBuilder.append("salario_base=:salario_base ").append("and ");
        queryBuilder.append("plano_carreira=:plano_carreira ").append("and ");
        queryBuilder.append("gratificacao=:gratificacao ").append("and ");
        queryBuilder.append("beneficio=:beneficio ").append("and ");
        queryBuilder.append("abono=:abono ").append("and ");
        queryBuilder.append("adiantamento=;adiantamento ").append("and ");
        queryBuilder.append("ferias=:ferias ").append("and ");
        queryBuilder.append("decimo_terceiro=:decimo_terceiro ").append("and ");
        queryBuilder.append("abatimento=:abatimento ").append("and ");
        queryBuilder.append("descontos=:descontos ").append("and ");
        queryBuilder.append("salario_bruto=:salario_bruto ").append("and ");
        queryBuilder.append("salario_liquido=:salario_liquido ").append(";");
        try (Connection conn = connection.open()) {
            return conn.createQuery(queryBuilder.toString())
                    .addParameter("salario_base", salario.getSalario_base())
                    .addParameter("plano_carreira", salario.getPlano_carreira())
                    .addParameter("gratificacao", salario.getGratificacao())
                    .addParameter("beneficio", salario.getBeneficio())
                    .addParameter("abono", salario.getAbono())
                    .addParameter("adiantamento", salario.getAdiantamento())
                    .addParameter("ferias", salario.getFerias())
                    .addParameter("decimo_terceiro", salario.getDecimo_terceiro())
                    .addParameter("abatimento", salario.getAbatimento())
                    .addParameter("descontos", salario.getDescontos())
                    .addParameter("salario_bruto", salario.getSalario_bruto())
                    .addParameter("salario_liquido", salario.getSalario_liquido())
                    .executeAndFetch(Salario.class).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public UUID insert(Salario salario) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("insert into salario");
        queryBuilder.append("values").append("(");
        queryBuilder.append("salario_uuid").append(", ");
        queryBuilder.append(":salario_base").append(", ");
        queryBuilder.append(":plano_carreira").append(", ");
        queryBuilder.append(":gratificacao").append(", ");
        queryBuilder.append(":beneficio").append(", ");
        queryBuilder.append(":abono").append(", ");
        queryBuilder.append(";adiantamento").append(", ");
        queryBuilder.append(":ferias").append(", ");
        queryBuilder.append(":decimo_terceiro").append(", ");
        queryBuilder.append(":abatimento").append(", ");
        queryBuilder.append(":descontos").append(", ");
        queryBuilder.append(":salario_bruto").append(", ");
        queryBuilder.append(":salario_liquido ").append(");");
        try (Connection conn = connection.beginTransaction()) {
            UUID uuid = UUID.randomUUID();
            conn.createQuery(queryBuilder.toString())
                    .addParameter("salario_uuid", uuid)
                    .addParameter("salario_base", salario.getSalario_base())
                    .addParameter("plano_carreira", salario.getPlano_carreira())
                    .addParameter("gratificacao", salario.getGratificacao())
                    .addParameter("beneficio", salario.getBeneficio())
                    .addParameter("abono", salario.getAbono())
                    .addParameter("adiantamento", salario.getAdiantamento())
                    .addParameter("ferias", salario.getFerias())
                    .addParameter("decimo_terceiro", salario.getDecimo_terceiro())
                    .addParameter("abatimento", salario.getAbatimento())
                    .addParameter("descontos", salario.getDescontos())
                    .addParameter("salario_bruto", salario.getSalario_bruto())
                    .addParameter("salario_liquido", salario.getSalario_liquido())
                    .executeUpdate();
            conn.commit();
            return uuid;
        }
    }

    @Override
    public Boolean delete(UUID uuid) {
        try (Connection conn = connection.open()) {
            conn.createQuery("delete from salario where salario_uuid=:salario_uuid")
                    .addParameter("salario_uuid", uuid)
                    .executeUpdate();
            return true;
        } catch (Sql2oException e) {
            return false;
        }
    }
}
