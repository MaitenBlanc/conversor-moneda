# 💱 Conversor de Moneda - Challenge ONE Java Back-End
    Este es un proyecto realizado como parte del **Challenge Back-End del programa Oracle Next Education + Alura Latam**.
    Consiste en un Conversor de Moneda que permite obtener el valor convertido entre diferentes divisas a través de una API de tipo de cambio en tiempo real.

## ✨ Funcionalidades
    - Conversión entre dos monedas con tasas actualizadas desde una API.
    - Registro de cada conversión con fecha y hora.
    - Visualización del historial de conversiones.
    - Persistencia del historial en un archivo de texto .txt.
    - Interfaz de línea de comandos amigable e interactiva.

## 🛠️ Tecnologías utilizadas
    - Java 17
    - API externa de tipos de cambio (como ExchangeRate-API)
    - Manejo de archivos (java.io)
    - Estándares de programación orientada a objetos (POO)
    - Formato de fecha/hora con java.time

## 📦 Estructura del proyecto
    src/
    ├── client/
    │   └── ApiClient.java              # Se conecta con la API para obtener tasas de cambio
    ├── model/
    │   └── Conversion.java             # Representa una conversión individual
    │   └── ConversionHistory.java      # Manejo y persistencia del historial de conversiones
    │   └── ConversionData.java         # Representa la respuesta de la API de conversión
    ├── service/
    │   └── CurrencyConverter.java      # Lógica principal de conversión de monedas
    └── App.java                        # Punto de entrada del programa (main)

## 🧪 Cómo ejecutar el proyecto
    - Clonar este repositorio:
        git clone https://github.com/MaitenBlanc/conversor-moneda.git

    - Compilar el proyecto desde la raíz:
        javac -d out src/**/*.java

    - Ejecutar el programa:
        java -cp out App

    - Asegurate de tener Java 17 o superior instalado y configurado en tu sistema.
