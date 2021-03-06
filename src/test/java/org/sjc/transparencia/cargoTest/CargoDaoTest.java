package org.sjc.transparencia.cargoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.cargo.CargoDao;

import java.util.UUID;

import static org.junit.Assert.*;

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
        assertNotNull(this.cargoDao.insert(this.cargo));
    }

    @Test
    public void pegaCargo() {
        assertEquals(this.cargo.getCargo(), this.cargoDao.retrieve(this.cargo).getCargo());
    }

    @Test
    public void pagaTodosDados() {
        assertNotNull(this.cargoDao.retrieveAll());
    }

    @Test
    public void pegaDadosPorUuid() {
        Cargo cargo = this.cargoDao.retrieveByUuid(this.cargo.getCargo_uuid());
        assertEquals(this.cargo.getCargo(), cargo.getCargo());
    }

    @Test
    public void naoPegaPorUuidInexistentes() {
        assertNull(this.cargoDao.retrieveByUuid(UUID.randomUUID()));
    }

    @Test
    public void apagaDatas() {
        assertTrue(this.cargoDao.delete(this.cargo.getCargo_uuid()));
    }
}
