package org.sjc.transparencia;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class DaoTest {

    private Dao dao;

    @Before
    public void setUp(){
        dao = new Dao();
    }
    @Test
    public void testa_se_sql2o_foi_instanciado(){
        assertTrue(this.dao.getDao() != null);
    }

    @Test
    public void testa_se_sql2o_nao_cria_mais_de_uma_instancia(){
        Dao dao2 = new Dao();
        assertSame(this.dao.getDao(), dao2.getDao());

    }
}
