package src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private final String fromCurrency;
    private final String toCurrency;
    private final double originalAmount;
    private final double convertedAmount;
    private final String timestamp;

    public Conversion(String fromCurrency, String toCurrency, double originalAmount, double convertedAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + originalAmount + " " + fromCurrency +
                " = " + convertedAmount + " " + toCurrency;
    }
}
