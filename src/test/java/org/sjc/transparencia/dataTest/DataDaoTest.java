package org.sjc.transparencia.dataTest;

public class DataDaoTest {

    private DataDao dataDao;

    @Before
    public void setUp() {
        this.dataDao = new DataDao();
    }

    @Test
    public void testa_se_pega_dados_do_banco() {
        assertTrue(this.dataDao.retrievelAllData() != null);
    }
}
