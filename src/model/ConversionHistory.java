package src.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private List<String> history;
    private static final String FILE_NAME = "conversion_history.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ConversionHistory() {
        this.history = new ArrayList<>();
        loadHistoryFromFile();
    }

    public void addConversion(String baseCurrency, double amountToConvert, double convertedAmount,
            String targetCurrency) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String conversionEntry = String.format("Fecha: %s - %s %.2f -> %.2f %s",
                timestamp, baseCurrency, amountToConvert, convertedAmount, targetCurrency);

        history.add(conversionEntry);
        appendConversionToFile(conversionEntry);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No hay historial de conversiones.");
        } else {
            System.out.println("\nHistorial de conversiones:");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }

    private void appendConversionToFile(String conversionEntry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(conversionEntry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    private void loadHistoryFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el historial desde el archivo: " + e.getMessage());
        }
    }
}
