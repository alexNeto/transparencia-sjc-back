CREATE TABLE data (
    data_id         SERIAL  PRIMARY KEY,
    mes             TEXT    NOT NULL,
    ano             INTEGER NOT NULL
);

CREATE TABLE funcionario (
    funcionario_id  SERIAL  PRIMARY KEY,
    data_id         INTEGER  REFERENCES data (data_id),
    nome            TEXT    NOT NULL,
    cargo           TEXT    NOT NULL,
    salario_base    NUMERIC NOT NULL,
    plano_carreira  NUMERIC NOT NULL,
    gratificacao    NUMERIC NOT NULL,
    beneficio       NUMERIC NOT NULL,
    abono           NUMERIC NOT NULL,
    adiantamento    NUMERIC NOT NULL,
    ferias          NUMERIC NOT NULL,
    decimo_terceiro NUMERIC NOT NULL,
    abatimento      NUMERIC NOT NULL,
    descontos       NUMERIC NOT NULL,
    salario_bruto   NUMERIC NOT NULL,
    salario_liquido NUMERIC NOT NULL
);