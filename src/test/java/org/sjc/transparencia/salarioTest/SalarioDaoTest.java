package org.sjc.transparencia.salarioTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.salario.Salario;
import org.sjc.transparencia.salario.SalarioDao;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SalarioDaoTest {

    private SalarioDao salarioDao;
    private UUID salarioUuid = UUID.randomUUID();
    private Salario salario;

    @Before
    public void setUp() {
        this.salarioDao = new SalarioDao();
        this.salario = new Salario(salarioUuid, new BigDecimal("1.0"), new BigDecimal("1.0"), new BigDecimal("1.0"), new BigDecimal("1.0"),
                new BigDecimal("1.0"), new BigDecimal("1.0"), new BigDecimal("1.0"), new BigDecimal("1.0"),
                new BigDecimal("1.0"), new BigDecimal("1.0"), new BigDecimal("1.0"), new BigDecimal("1.0"));
        this.salarioDao.insert(this.salario);
    }

    @After
    public void apagaData() {
        this.salarioDao.delete(this.salario.getSalario_uuid());
    }

    @Test
    public void insereDatas() {
        this.salarioDao.delete(this.salario.getSalario_uuid());
        assertTrue(this.salarioDao.insert(this.salario) != null);
    }

    @Test
    public void pagaTodosDados() {
        assertTrue(this.salarioDao.retrieveAll() != null);
    }

    @Test
    public void pegaDadosPorUuid() {
        Salario salario = this.salarioDao.retrieveByUuid(this.salario.getSalario_uuid());
        assertEquals(this.salario.getSalario_uuid(), this.salarioDao.retrieveByUuid(salario.getSalario_uuid()).getSalario_uuid());
    }

    @Test
    public void naoPegaPorUuidInexistentes() {
        assertTrue(this.salarioDao.retrieveByUuid(UUID.randomUUID()) == null);
    }

    @Test
    public void pegaData() {
        assertTrue(this.salarioDao.retrieve(salario) != null);
    }

    @Test
    public void apagaDatas() {
        assertTrue(this.salarioDao.delete(this.salario.getSalario_uuid()));
    }
}
