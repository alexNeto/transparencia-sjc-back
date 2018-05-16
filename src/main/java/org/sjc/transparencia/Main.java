package org.sjc.transparencia;

import org.sjc.transparencia.calculos.frequencia.FrequenciaController;
import org.sjc.transparencia.cargo.CargoController;
import org.sjc.transparencia.data.Data;
import org.sjc.transparencia.data.DataController;
import org.sjc.transparencia.data.DataDao;
import org.sjc.transparencia.funcionario.FuncionarioController;
import org.sjc.transparencia.remuneracao.InsereDadosRaspados;
import org.sjc.transparencia.salario.SalarioController;
import spark.Filter;
import spark.Spark;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {

    private static final HashMap<String, String> corsHeaders = new HashMap<>();
    private static String[] argumentos;

    static {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "*");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }

    public static void main(String[] args) {
        argumentos = args;
        port(getHerokuAssignedPort());
        apply();
        get("/", (req, res) -> "{\"content\": \"all good\"}");

        new DataController().data();
        new CargoController().cargo();
        new SalarioController().salario();
        new FuncionarioController().funcionario();
        new FrequenciaController().frequencia();

        if (haNovosDadosDisponiveis()) {
            atualizaDados();
        }
    }

    private static boolean haNovosDadosDisponiveis() {
        Boolean result = true;
        List<Data> dataList = new DataDao().retrieveAll();
        Calendar dataDoMesPassado = Calendar.getInstance();
        dataDoMesPassado.add(Calendar.MONTH, -1);
        for (Data data : dataList) {
            if (data.getMes() == dataDoMesPassado.get(Calendar.MONTH) + 1) {
                if (data.getAno() == dataDoMesPassado.get(Calendar.YEAR)) {
                    result = false;
                }
            }
        }
        return result;
    }

    private static void atualizaDados() {
        InsereDadosRaspados insereDadosRaspados = new InsereDadosRaspados("http://localhost:5000/salario_camara_municipal");
        insereDadosRaspados.insere();
    }

    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        String herokuPort = processBuilder.environment().get("PORT");
        Integer port = herokuPort != null ? Integer.parseInt(herokuPort) : 4567;
        return port;
    }

    public static void apply() {
        Filter filter = (request, response) -> {
            response.type("application/json");
            corsHeaders.forEach(response::header);
        };
        Spark.after(filter);
    }
}
