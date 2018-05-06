package org.sjc.transparencia.dataTest;

import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.data.DataDao;

import static org.junit.Assert.assertTrue;

public class DataDaoTest {

    private DataDao dataDao;

    @Before
    public void setUp() {
        this.dataDao = new DataDao();
    }

    @Test
    public void pagaTodosDados() {
        assertTrue(this.dataDao.retrieveAllData() != null);
    }

    @Test
    public void pagaTodosDadosPorAno() {
        assertTrue(this.dataDao.retrieveByYear(2018) != null);
    }
}
