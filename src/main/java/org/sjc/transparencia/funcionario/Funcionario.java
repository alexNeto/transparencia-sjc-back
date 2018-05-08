package org.sjc.transparencia.funcionario;

import org.sjc.transparencia.cargo.Cargo;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.salario.Salario;

import java.util.UUID;

public class Funcionario {

    private UUID funcionario_uuid;
    private Data data;
    private Cargo cargo;
    private Salario salario;
    private String nome;

    public Funcionario() {

    }

    public Funcionario(UUID funcionario_uuid, Data data, Cargo cargo, Salario salario, String nome) {
        this.funcionario_uuid = funcionario_uuid;
        this.data = data;
        this.cargo = cargo;
        this.salario = salario;
        this.nome = nome;
    }


    public UUID getFuncionario_uuid() {
        return funcionario_uuid;
    }

    public void setFuncionario_uuid(UUID funcionario_uuid) {
        this.funcionario_uuid = funcionario_uuid;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
