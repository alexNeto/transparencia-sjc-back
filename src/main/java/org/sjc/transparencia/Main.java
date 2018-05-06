package org.sjc.transparencia;

import org.sjc.transparencia.data.DataController;
import spark.Filter;
import spark.Spark;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        apply();
        get("/", (req, res) -> "all good");
        new DataController().data();
    }

    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        String herokuPort = processBuilder.environment().get("PORT");
        Integer port = herokuPort != null ? Integer.parseInt(herokuPort) : 4567;
        return port;
    }


    private static final HashMap<String, String> corsHeaders = new HashMap<>();

    static {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "*");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }

    public static void apply() {
        Filter filter = (request, response) -> {
            response.type("application/json");
            corsHeaders.forEach(response::header);
        };
        Spark.after(filter);
    }
}
