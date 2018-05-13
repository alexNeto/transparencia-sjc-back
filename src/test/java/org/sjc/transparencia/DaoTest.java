package org.sjc.transparencia;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class DaoTest {

    @Test
    public void verificaConexao() {
        assertNotNull(Dao.getConnection());
    }

    @Test
    public void verificaSingleton() {
        assertSame(Dao.getConnection(), Dao.getConnection());

    }
}
