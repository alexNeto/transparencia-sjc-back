package org.sjc.transparencia.remuneracao;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class RecebeDadosRaspados {

    private String url;

    public RecebeDadosRaspados(String url) {
        this.url = url;
    }

    public JSONObject leJsonDaUrl() throws IOException, JSONException {
        try (InputStream input = new URL(this.url).openStream()) {
            BufferedReader read = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            String jsonText = this.leResposta(read);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }

    public String leResposta(BufferedReader reader) throws IOException {
        StringBuilder responseBuilder = new StringBuilder();
        String linhaResposta;
        while (((linhaResposta = reader.readLine())) != null) {
            responseBuilder.append(linhaResposta);
        }
        return responseBuilder.toString();
    }
}
