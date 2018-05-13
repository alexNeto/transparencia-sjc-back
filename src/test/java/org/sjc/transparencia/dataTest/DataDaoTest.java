package org.sjc.transparencia.dataTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.data.DataDao;

import java.util.UUID;

import static org.junit.Assert.*;

public class DataDaoTest {

    private DataDao dataDao;
    private UUID dataUuid = UUID.randomUUID();
    private Data data;

    @Before
    public void setUp() {
        this.dataDao = new DataDao();
        this.data = new Data(dataUuid, 1, 2018);
        this.dataDao.insert(this.data);
    }

    @After
    public void apagaData() {
        this.dataDao.delete(this.data.getData_uuid());
    }

    @Test
    public void insereDatas() {
        this.dataDao.delete(this.data.getData_uuid());
        assertNotNull(this.dataDao.insert(this.data));
    }

    @Test
    public void pagaTodosDados() {
        assertNotNull(this.dataDao.retrieveAll());
    }

    @Test
    public void pagaTodosDadosPorAno() {
        assertNotNull(this.dataDao.retrieveByYear(2018));
    }

    @Test
    public void pegaDadosPorUuid() {
        Data data = this.dataDao.retrieveByUuid(this.data.getData_uuid());
        assertEquals(this.data.getMes(), data.getMes());
        assertEquals(this.data.getAno(), data.getAno());
    }

    @Test
    public void naoPegaPorUuidInexistentes() {
        assertNull(this.dataDao.retrieveByUuid(UUID.randomUUID()));
    }

    @Test
    public void pegaData() {
        assertNotNull(this.dataDao.retrieve(data));
    }

    @Test
    public void apagaDatas() {
        assertTrue(this.dataDao.delete(this.data.getData_uuid()));
    }
}
