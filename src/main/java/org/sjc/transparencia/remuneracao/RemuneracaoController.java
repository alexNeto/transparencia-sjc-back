package org.sjc.transparencia.remuneracao;

import com.google.gson.Gson;

import static spark.Spark.get;

public class RemuneracaoController {

    public void remuneracao() {
        get("/remuneracao", (req, res) -> new RemuneracaoModel().leJsonDaUrl());
    }
}