package org.sjc.transparencia.dataTest;

import org.junit.Before;
import org.junit.Test;
import org.sjc.transparencia.data.DataModel;

import static junit.framework.TestCase.assertNotNull;

public class DataModelTest {

    private DataModel dataModel;

    @Before
    public void setUp() {
        this.dataModel = new DataModel();
    }

    @Test
    public void getData() {
        assertNotNull(this.dataModel.getdata());
    }

    @Test
    public void setDataPorAno() {
        assertNotNull(this.dataModel.getDataPorAno("2018"));
    }

    @Test
    public void getDataPorAnoEMes() {
        assertNotNull(this.dataModel.getDataPorAnoEMes("01", "2018"));
    }
}
