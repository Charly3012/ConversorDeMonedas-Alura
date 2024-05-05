package src.controlador;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.source.tree.ReturnTree;
import src.modelo.Moneda;
import src.modelo.MonedaRecord;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    public MonedaRecord consultarMoneda(int monedaEntrada){
        String codigoMoneda = generarMoneda(monedaEntrada);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/0a61c98eefa7f967ba72a130/latest/" + codigoMoneda);

        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            MonedaRecord monedaRecord = gson.fromJson(response.body(), MonedaRecord.class);

            System.out.println(monedaRecord);

            FileWriter escritura = new FileWriter("prueba"+".json");
            escritura.write(gson.toJson(monedaRecord));
            escritura.close();


            return monedaRecord;

            //return new Moneda(monedaRecord);

        } catch (Exception e) {
            throw new RuntimeException("No encontre la moneda");
        }
    }

    private String generarMoneda(int moneda){
        if(moneda == 1){
            return "MXN";
        } else if (moneda == 2) {
            return "USD";
        } else if (moneda == 3) {
            return "EUR";
        } else if (moneda == 4) {
            return "ARS";
        } else if (moneda == 5) {
            return "BRL";
        }else {
            return "JPY";
        }
    }
}
