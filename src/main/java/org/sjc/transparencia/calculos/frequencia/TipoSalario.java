package org.sjc.transparencia.calculos.frequencia;

public enum TipoSalario {

    SALARIO_BASE("salario_base"),
    PLANO_CARREIRA("plano_carreira"),
    GRATIFICACAO("gratificacao"),
    BENEFICIO("beneficio"),
    ABONO("abono"),
    ADIANTEMENTO("adiantamento"),
    FERIAS("ferias"),
    DECIMO_TERCEIRO("decimo_terceiro"),
    ABATIMENTO("abatimento"),
    DESCONTOS("descontos"),
    SALARIO_BRUTO("salario_bruto"),
    SALARIO_LIQUIDO("salario_liquido");

    private final String text;

    TipoSalario(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
