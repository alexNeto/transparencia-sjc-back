package org.sjc.transparencia.funcionario;

import java.util.UUID;

public class FuncionarioRepository {

    private UUID funcionario_uuid;
    private UUID data_uuid;
    private UUID cargo_uuid;
    private UUID salario_uuid;
    private String nome;

    public FuncionarioRepository(UUID funcionario_uuid, UUID data_uuid, UUID cargo_uuid, UUID salario_uuid, String nome) {
        this.funcionario_uuid = funcionario_uuid;
        this.data_uuid = data_uuid;
        this.cargo_uuid = cargo_uuid;
        this.salario_uuid = salario_uuid;
        this.nome = nome;
    }

    public UUID getFuncionario_uuid() {
        return funcionario_uuid;
    }

    public UUID getData_uuid() {
        return data_uuid;
    }

    public UUID getCargo_uuid() {
        return cargo_uuid;
    }

    public UUID getSalario_uuid() {
        return salario_uuid;
    }

    public String getNome() {
        return nome;
    }
}
