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
    public void testa_se_pega_dados_do_banco() {
        assertTrue(this.dataDao.retrieveAllData() == null);
    }
}
