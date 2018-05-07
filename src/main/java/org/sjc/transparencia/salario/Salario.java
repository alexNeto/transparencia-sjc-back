package org.sjc.transparencia.salario;

import java.math.BigDecimal;
import java.util.UUID;

public class Salario {

    private UUID salario_uuid;
    private BigDecimal salario_base;
    private BigDecimal plano_carreira;
    private BigDecimal gratificacao;
    private BigDecimal beneficio;
    private BigDecimal abono;
    private BigDecimal adiantamento;
    private BigDecimal ferias;
    private BigDecimal decimo_terceiro;
    private BigDecimal abatimento;
    private BigDecimal descontos;
    private BigDecimal salario_bruto;
    private BigDecimal salario_liquido;

    public Salario(UUID salario_uuid, BigDecimal salario_base, BigDecimal plano_carreira, BigDecimal gratificacao,
                   BigDecimal beneficio, BigDecimal abono, BigDecimal adiantamento, BigDecimal ferias,
                   BigDecimal decimo_terceiro, BigDecimal abatimento, BigDecimal descontos,
                   BigDecimal salario_bruto, BigDecimal salario_liquido) {
        this.salario_uuid = salario_uuid;
        this.salario_base = salario_base;
        this.plano_carreira = plano_carreira;
        this.gratificacao = gratificacao;
        this.beneficio = beneficio;
        this.abono = abono;
        this.adiantamento = adiantamento;
        this.ferias = ferias;
        this.decimo_terceiro = decimo_terceiro;
        this.abatimento = abatimento;
        this.descontos = descontos;
        this.salario_bruto = salario_bruto;
        this.salario_liquido = salario_liquido;
    }

    public UUID getSalario_uuid() {
        return salario_uuid;
    }

    public BigDecimal getSalario_base() {
        return salario_base;
    }

    public BigDecimal getPlano_carreira() {
        return plano_carreira;
    }

    public BigDecimal getGratificacao() {
        return gratificacao;
    }

    public BigDecimal getBeneficio() {
        return beneficio;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public BigDecimal getAdiantamento() {
        return adiantamento;
    }

    public BigDecimal getFerias() {
        return ferias;
    }

    public BigDecimal getDecimo_terceiro() {
        return decimo_terceiro;
    }

    public BigDecimal getAbatimento() {
        return abatimento;
    }

    public BigDecimal getDescontos() {
        return descontos;
    }

    public BigDecimal getSalario_bruto() {
        return salario_bruto;
    }

    public BigDecimal getSalario_liquido() {
        return salario_liquido;
    }
}
