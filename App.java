import java.util.Scanner;
import src.client.ApiClient;
import src.model.ConversionHistory;
import src.service.CurrencyConverter;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();
        CurrencyConverter currencyConverter = new CurrencyConverter(apiClient);
        ConversionHistory conversionHistory = new ConversionHistory();

        System.out.println("****** CONVERSOR DE MONEDAS ******");

        boolean convertAgain = true;
        while (convertAgain) {
            System.out.print("\nMoneda base (ej: USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Moneda destino (ej: ARS): ");
            String targetCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Cantidad a convertir: $");
            double amountToConvert = Double.parseDouble(scanner.nextLine());

            try {
                double convertedAmount = currencyConverter.convert(baseCurrency, targetCurrency,
                        amountToConvert);
                System.out.println("Cantidad convertida: $" + convertedAmount);

                conversionHistory.addConversion(baseCurrency, amountToConvert, convertedAmount, targetCurrency);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("\n¿Querés ver el historial de conversiones? (s/n): ");
            String seeHistory = scanner.nextLine();
            if (seeHistory.equalsIgnoreCase("s")) {
                conversionHistory.showHistory();
            }

            System.out.print("\n¿Querés realizar otra conversión? (s/n): ");
            String anotherConversion = scanner.nextLine();
            if (!anotherConversion.equalsIgnoreCase("s")) {
                convertAgain = false;
            }
        }

        scanner.close();
    }
}
