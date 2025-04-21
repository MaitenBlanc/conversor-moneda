package src.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import src.model.CurrencyData;

public class ApiClient {
    private final String API_KEY = "24bf1233a129d03ec084a386";
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public CurrencyData getRates(String baseCurrency) {
        try {
            URI url = URI.create(BASE_URL + API_KEY + "/latest/" + baseCurrency);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("No se pudieron obtener los tipos de cambio.");
            }

            return new Gson().fromJson(response.body(), CurrencyData.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los tipos de cambio: " + e.getMessage(), e);
        }

    }
}
