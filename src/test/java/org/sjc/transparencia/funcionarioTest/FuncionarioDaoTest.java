package org.sjc.transparencia.funcionarioTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.cargo.CargoDao;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.data.DataDao;
import org.sjc.transparencia.funcionario.Funcionario;
import org.sjc.transparencia.funcionario.FuncionarioDao;
import org.sjc.transparencia.salario.Salario;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.*;

public class FuncionarioDaoTest {

    private FuncionarioDao funcionarioDao;
    private UUID funcionaUuid = UUID.randomUUID();
    private UUID data_uuid = UUID.randomUUID();
    private UUID cargo_uuid = UUID.randomUUID();
    private UUID salario_uuid = UUID.randomUUID();
    private Data data = new Data(data_uuid, 1, 2018);
    private Cargo cargo = new Cargo(cargo_uuid, "cargo");
    private Salario salario = new Salario(salario_uuid, new BigDecimal(1.0), new BigDecimal(1.0), new BigDecimal(1.0),
            new BigDecimal(1.0), new BigDecimal(1.0), new BigDecimal(1.0), new BigDecimal(1.0),
            new BigDecimal(1.0), new BigDecimal(1.0), new BigDecimal(1.0),
            new BigDecimal(1.0), new BigDecimal(1.0));
    private Funcionario funcionario;

    @Before
    public void setUp() {
        this.funcionarioDao = new FuncionarioDao();
        new DataDao().insert(this.data);
        new CargoDao().insert(this.cargo);
        this.funcionario = new Funcionario(funcionaUuid, data, cargo, salario, "nome");
        this.funcionarioDao.insert(this.funcionario);
    }

    @After
    public void apagaData() {
        this.funcionarioDao.delete(this.funcionario.getFuncionario_uuid());
    }


    @Test
    public void pagaTodosDados() {
        assertNotNull(this.funcionarioDao.retrieveAll());
    }

    @Test
    public void pegaDadosPorUuid() {
        Funcionario funcionario = this.funcionarioDao.retrieveByUuid(this.funcionario.getFuncionario_uuid());
        assertEquals(this.funcionario.getFuncionario_uuid(), this.funcionarioDao.retrieveByUuid(funcionario.getFuncionario_uuid()).getFuncionario_uuid());
    }

    @Test
    public void naoPegaPorUuidInexistentes() {
        assertNull(this.funcionarioDao.retrieveByUuid(UUID.randomUUID()));
    }

    @Test
    public void pegaData() {
        assertNotNull(this.funcionarioDao.retrieve(funcionario));
    }

}
