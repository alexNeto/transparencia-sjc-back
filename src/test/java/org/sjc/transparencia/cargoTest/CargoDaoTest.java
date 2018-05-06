package org.sjc.transparencia.cargoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.cargo.CargoDao;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CargoDaoTest {

    private CargoDao cargoDao;
    private UUID cargoUuid = UUID.randomUUID();
    private Cargo cargo;

    @Before
    public void setUp() {
        this.cargoDao = new CargoDao();
        this.cargo = new Cargo(cargoUuid, "Um cargo");
        this.cargoDao.insert(this.cargo);
    }

    @After
    public void apaga() {
        this.cargoDao.delete(this.cargo.getCargo_uuid());
    }


    @Test
    public void insereDatas() {
        this.cargoDao.delete(this.cargo.getCargo_uuid());
        assertTrue(this.cargoDao.insert(this.cargo) != null);
    }

    @Test
    public void pagaTodosDados() {
        assertTrue(this.cargoDao.retrieveAll() != null);
    }

    @Test
    public void pegaDadosPorUuid() {
        Cargo cargo = this.cargoDao.retrieveByUuid(this.cargo.getCargo_uuid());
        assertEquals(this.cargo.getCargo(), cargo.getCargo());
    }

    @Test
    public void naoPegaPorUuidInexistentes() {
        assertTrue(this.cargoDao.retrieveByUuid(UUID.randomUUID()) == null);
    }

    @Test
    public void apagaDatas() {
        assertTrue(this.cargoDao.delete(this.cargo.getCargo_uuid()));
    }
}
