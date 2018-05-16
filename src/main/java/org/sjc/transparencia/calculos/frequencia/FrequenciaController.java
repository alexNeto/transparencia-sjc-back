package org.sjc.transparencia.calculos.frequencia;

import spark.Spark;

import static spark.Spark.get;

public class FrequenciaController {

    private FrequenciaModel frequenciaModel;

    public FrequenciaController() {
        this.frequenciaModel = new FrequenciaModel();
    }

    public void frequencia() {

        get("/remuneracao", (req, res) ->
                this.frequenciaModel.getFrequencias());

        get("/remuneracao/salario/:salario", (req, res) ->
                this.frequenciaModel.getFrequenciasPorSalario(req.params("salario")));

        get("/remuneracao/salario/:salario/nome/:nome", (req, res) ->
                this.frequenciaModel.getFrequenciasPorSalarioENome(req.params("salario"), req.params("nome")));

        get("/remuneracao/cargo/:cargo", (req, res) ->
                this.frequenciaModel.getFrequenciasPorCargo(req.params("cargo")));

        get("/remuneracao/cargo/:cargo/nome/:nome", (req, res) ->
                this.frequenciaModel.getFrequenciasPorCargoENome(req.params("cargo"), req.params("nome")));

        get("/remuneracao/cargo/:cargo/salario/:salario", (req, res) ->
                this.frequenciaModel.getFrequenciasPorCargoESalario(req.params("cargo"), req.params("salario")));
    }
}
