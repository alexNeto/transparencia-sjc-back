package org.sjc.transparencia.funcionario;

import org.sjc.transparencia.Dao;
import org.sjc.transparencia.Model;
import org.sjc.transparencia.cargo.CargoDao;
import org.sjc.transparencia.data.DataDao;
import org.sjc.transparencia.salario.SalarioDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FuncionarioDao implements Model<Funcionario> {

    private Sql2o connection;
    private SalarioDao salarioDao;
    private CargoDao cargoDao;
    private DataDao dataDao;

    public FuncionarioDao() {
        this.connection = Dao.getConnection();
        this.salarioDao = new SalarioDao();
        this.cargoDao = new CargoDao();
        this.dataDao = new DataDao();
    }

    @Override
    public List<Funcionario> retrieveAll() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select * from funcionario;");
        try (Connection conn = connection.open()) {
            List<FuncionarioRepository> funcionariosRepositories = conn.createQuery(queryBuilder.toString())
                    .executeAndFetch(FuncionarioRepository.class);
            return converter(funcionariosRepositories);
        }
    }

    @Override
    public Funcionario retrieveByUuid(UUID uuid) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select * from funcionario where funcionario_uuid=:funcionario_uuid;");
        try (Connection conn = connection.open()) {
            List<FuncionarioRepository> funcionariosRepositories = conn.createQuery(queryBuilder.toString())
                    .addParameter("funcionario_uuid", uuid)
                    .executeAndFetch(FuncionarioRepository.class);
            return converter(funcionariosRepositories).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public Funcionario retrieve(Funcionario funcionario) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select * from funcionario where ");
        queryBuilder.append("data_uuid=:data_uuid ").append("and ");
        queryBuilder.append("cargo_uuid=:cargo_uuid ").append("and ");
        queryBuilder.append("salario_uuid=:salario_uuid ").append(";");
        try (Connection conn = connection.open()) {
            List<FuncionarioRepository> funcionariosRepositories = conn.createQuery(queryBuilder.toString())
                    .addParameter("data_uuid", funcionario.getData().getData_uuid())
                    .addParameter("cargo_uuid", funcionario.getCargo().getCargo_uuid())
                    .addParameter("salario_uuid", funcionario.getSalario().getSalario_uuid())
                    .executeAndFetch(FuncionarioRepository.class);
            return converter(funcionariosRepositories).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public UUID insert(Funcionario funcionario) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("insert into funcionario");
        queryBuilder.append("(funcionario_uuid, data_uuid, cargo_uuid, salario_uuid, nome) ");
        queryBuilder.append("values ");
        queryBuilder.append("(:funcionario_uuid, :data_uuid, :cargo_uuid, :salario_uuid, :nome);");
        try (Connection conn = connection.beginTransaction()) {
            UUID uuid = funcionario.getFuncionario_uuid() != null ? funcionario.getFuncionario_uuid() : UUID.randomUUID();
            conn.createQuery(queryBuilder.toString())
                    .addParameter("funcionario_uuid", uuid)
                    .addParameter("data_uuid", this.dataDao.insert(funcionario.getData()))
                    .addParameter("cargo_uuid", this.cargoDao.insert(funcionario.getCargo()))
                    .addParameter("salario_uuid", this.salarioDao.insert(funcionario.getSalario()))
                    .addParameter("nome", funcionario.getNome())
                    .executeUpdate();
            conn.commit();
            return uuid;
        }
    }

    @Override
    public Boolean delete(UUID uuid) {
        Boolean result = true;
        Funcionario funcionario = retrieveByUuid(uuid);
        try (Connection conn = connection.open()) {
            conn.createQuery("delete from funcionario where funcionario_uuid=:funcionario_uuid;")
                    .addParameter("funcionario_uuid", uuid)
                    .executeUpdate();
        } catch (Sql2oException e) {
            result = false;
        }
        if (funcionario == null)
            result = false;
        if (!this.salarioDao.delete(funcionario.getSalario().getSalario_uuid()))
            result = false;
        if (!this.dataDao.delete(funcionario.getData().getData_uuid()))
            result = false;
        if (!this.cargoDao.delete(funcionario.getCargo().getCargo_uuid()))
            result = false;
        return result;
    }

    public List<Funcionario> converter(List<FuncionarioRepository> funcionariosRepositories) {
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = new Funcionario();
        funcionariosRepositories.forEach((funcionarioRepository) -> {
            funcionario.setFuncionario_uuid(funcionarioRepository.getFuncionario_uuid());
            funcionario.setNome(funcionarioRepository.getNome());
            funcionario.setData(this.dataDao.retrieveByUuid(funcionarioRepository.getData_uuid()));
            funcionario.setCargo(this.cargoDao.retrieveByUuid(funcionarioRepository.getCargo_uuid()));
            funcionario.setSalario(this.salarioDao.retrieveByUuid(funcionarioRepository.getSalario_uuid()));
            funcionarios.add(funcionario);
        });
        return funcionarios;
    }
}
