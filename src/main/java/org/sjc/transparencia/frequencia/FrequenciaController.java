package org.sjc.transparencia.frequencia;

import static spark.Spark.get;

public class FrequenciaController {

    private FrequenciaModel frequenciaModel;

    public FrequenciaController() {
        this.frequenciaModel = new FrequenciaModel();
    }

    public void frequencia() {

        get("/frequencia", (req, res) ->
                this.frequenciaModel.getFrequencias());

        get("/frequencia/salario/:salario", (req, res) ->
                this.frequenciaModel.getFrequenciasPorSalario(req.params("salario")));

        get("/frequencia/salario/:salario/nome/:nome", (req, res) ->
                this.frequenciaModel.getFrequenciasPorSalarioENome(req.params("salario"), req.params("nome")));

        get("/frequencia/cargo/:cargo", (req, res) ->
                this.frequenciaModel.getFrequenciasPorCargo(req.params("cargo")));

        get("/frequencia/cargo/:cargo/nome/:nome", (req, res) ->
                this.frequenciaModel.getFrequenciasPorCargoENome(req.params("cargo"), req.params("nome")));

        get("/frequencia/cargo/:cargo/salario/:salario", (req, res) ->
                this.frequenciaModel.getFrequenciasPorCargoESalario(req.params("cargo"), req.params("salario")));
    }
}
