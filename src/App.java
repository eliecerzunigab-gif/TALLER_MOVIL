import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        // El bucle se ejecuta mientras la opción sea diferente de 3 (Salir)
        while (opcion != 3) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    registrarVehiculo(scanner);
                    break;
                case 2:
                    calcularDespacho(scanner);
                    break;
                case 3:
                    System.out.println("Gracias por utilizar la aplicación. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
            // Pausa para que el usuario pueda leer el resultado antes de volver al menú
            if (opcion != 3) {
                System.out.println("\nPresione Enter para volver al menú principal...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar Información de Vehículo de Despacho");
        System.out.println("2. Calcular Costo de Compra y Despacho");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarVehiculo(Scanner scanner) {
        System.out.println("\n--- Módulo: Registro de Vehículo ---");
        String marca, modelo, tipoCombustible;
        int cilindrada, capacidadPasajeros;

        System.out.print("Por favor, ingrese la marca del vehiculo: ");
        marca = scanner.nextLine();

        System.out.print("Por favor, ingrese el modelo del vehiculo: ");
        modelo = scanner.nextLine();

        System.out.print("Por favor, ingrese la cilindrada del vehiculo (en cc): ");
        cilindrada = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Por favor, ingrese el tipo de combustible: ");
        tipoCombustible = scanner.nextLine();

        System.out.print("Por favor, ingrese la capacidad de pasajeros: ");
        capacidadPasajeros = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.println("\n--- Resumen del Vehículo Registrado ---");
        System.out.println("La marca que ha ingresado es: " + marca);
        System.out.println("El modelo que ha ingresado es: " + modelo);
        System.out.println("La cilindrada que ha ingresado es: " + cilindrada + "cc");
        System.out.println("El tipo de combustible es: " + tipoCombustible);
        System.out.println("Tiene una capacidad de " + capacidadPasajeros + " pasajeros.");
    }

    public static void calcularDespacho(Scanner scanner) {
        System.out.println("\n--- Módulo: Calculadora de Costo de Despacho ---");
        final int LIMITE_RADIO_KM = 20;
        final int TARIFA_ALTA = 300;
        final int TARIFA_NORMAL = 150;
        final int MONTO_MINIMO_TARIFA_NORMAL = 25000;
        final int MONTO_MINIMO_GRATIS = 50000;

        System.out.print("Por favor, ingrese el monto total de la compra: ");
        double montoCompra = scanner.nextDouble();

        System.out.print("Por favor, ingrese la distancia en kilometros: ");
        int kilometros = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        double costoDespacho = 0;

        if (kilometros > LIMITE_RADIO_KM) {
            System.out.println("\nLo sentimos, el despacho no está disponible para su ubicación.");
        } else {
            if (montoCompra >= MONTO_MINIMO_TARIFA_NORMAL) {
                costoDespacho = kilometros * TARIFA_NORMAL;
            } else {
                costoDespacho = kilometros * TARIFA_ALTA;
            }

            double totalPagar = montoCompra + costoDespacho;

            System.out.println("\n--- Resumen del Pedido ---");
            System.out.println("Monto de la Compra: $" + String.format("%.0f", montoCompra));
            System.out.println("Distancia de Despacho: " + kilometros + " km");
            System.out.println("Costo de Despacho: $" + String.format("%.0f", costoDespacho));
            System.out.println("----------------------------------");
            System.out.println("Total a Pagar: $" + String.format("%.0f", totalPagar));
        }
    }
}