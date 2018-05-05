package org.sjc.transparencia.data;

public class DataRepository {
    private Integer data_id;
    private String mes;
    private Integer ano;

    public Integer getDataId() {
        return data_id;
    }

    public void setDataId(Integer data_id) {
        this.data_id = data_id;
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
