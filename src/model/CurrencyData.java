package src.model;

import java.util.Map;

public record CurrencyData(
                String base_code,
                Map<String, Double> conversion_rates) {
}
