package org.sjc.transparencia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testa_se_nao_acha_instancia_de_port_para_heroku() {
        assertEquals(4567, Main.getHerokuAssignedPort());
    }
}
