package org.sjc.transparencia.data;

import java.util.UUID;

public class Data {
    private UUID data_uuid;
    private String mes;
    private Integer ano;

    public UUID getData_uuid() {
        return data_uuid;
    }

    public void setData_uuid(UUID data_uuid) {
        this.data_uuid = data_uuid;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
