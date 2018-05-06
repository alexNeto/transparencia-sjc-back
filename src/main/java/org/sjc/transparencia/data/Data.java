package org.sjc.transparencia.data;

import java.util.UUID;

public class Data {

    private UUID data_uuid;
    private Integer mes;
    private Integer ano;

    public Data(UUID data_uuid, Integer mes, Integer ano) {
        this.data_uuid = data_uuid;
        this.mes = mes;
        this.ano = ano;
    }

    public UUID getData_uuid() {
        return data_uuid;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAno() {
        return ano;
    }
}
