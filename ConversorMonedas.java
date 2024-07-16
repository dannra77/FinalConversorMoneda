package principal;

import calculos.ConversorDivisas;
import modelo.Conversion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMonedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ejecutarConversion(Conversion.TipoConversion.DOLAR_A_PESO_ARGENTINO, scanner);
                    break;
                case 2:
                    ejecutarConversion(Conversion.TipoConversion.PESO_ARGENTINO_A_DOLAR, scanner);
                    break;
                case 3:
                    ejecutarConversion(Conversion.TipoConversion.DOLAR_A_REAL_BRASILERO, scanner);
                    break;
                case 4:
                    ejecutarConversion(Conversion.TipoConversion.REAL_BRASILERO_A_DOLAR, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción del 1 al 5.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n======= Conversor de Monedas =======");
        System.out.println("1) Dolar a Peso Argentino");
        System.out.println("2) Peso Argentino a Dolar");
        System.out.println("3) Dolar a Real Brasileño");
        System.out.println("4) Real Brasileño a Dolar");
        System.out.println("5) Salir");
        System.out.print("Elige una opción: ");
    }

    private static void ejecutarConversion(Conversion.TipoConversion tipo, Scanner scanner) {
        System.out.print("Ingrese la cantidad a convertir: ");

        try {
            double cantidad = scanner.nextDouble();
            double resultado = ConversorDivisas.convertir(tipo, cantidad);
            System.out.println("Resultado de la conversión: " + resultado);
        } catch (InputMismatchException e) {
            System.err.println("Error: Ingrese un número válido para la cantidad.");
            scanner.nextLine();
        } catch (Exception e) {
            System.err.println("Error en la conversión: " + e.getMessage());
        }
    }
}

