package src.service;

import src.client.ApiClient;
import src.model.CurrencyData;

public class CurrencyConverter {
    private final ApiClient apiClient;

    public CurrencyConverter(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public double convert(String baseCurrency, String targetCurrency, double amount) {
        CurrencyData data = apiClient.getRates(baseCurrency);
        Double rate = data.conversion_rates().get(targetCurrency);

        if (rate == null) {
            throw new IllegalArgumentException("Moneda de destino no encontrada.");
        }

        return amount * rate;
    }
}
