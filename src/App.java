import java.util.Scanner;

public class App {

    // Variables estáticas para "recordar" los datos del vehículo en toda la aplicación.
    // Se inicializan con un valor por defecto.
    private static String vehiculoMarca = "No registrado";
    private static String vehiculoModelo;
    private static int vehiculoCilindrada;
    private static String vehiculoCombustible;
    private static int vehiculoCapacidadPasajeros;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            mostrarMenu();
            // Validar que el usuario ingrese un número
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                opcion = 0; // Asignar una opción inválida si no es un número
            }
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
                    System.out.println("\nOpción no válida. Por favor, intente de nuevo.");
                    break;
            }
            
            if (opcion != 3) {
                System.out.println("\nPresione Enter para volver al menú principal...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n================ MENÚ PRINCIPAL ================");
        System.out.println("1. Registrar Vehículo de Despacho");
        System.out.println("2. Calcular Costo de Compra y Despacho");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarVehiculo(Scanner scanner) {
        System.out.println("\n--- Módulo: Registro de Vehículo ---");
        
        System.out.print("Por favor, ingrese la marca del vehiculo: ");
        vehiculoMarca = scanner.nextLine();

        System.out.print("Por favor, ingrese el modelo del vehiculo: ");
        vehiculoModelo = scanner.nextLine();

        System.out.print("Por favor, ingrese la cilindrada del vehiculo (en cc): ");
        vehiculoCilindrada = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Por favor, ingrese el tipo de combustible: ");
        vehiculoCombustible = scanner.nextLine();

        System.out.print("Por favor, ingrese la capacidad de pasajeros: ");
        vehiculoCapacidadPasajeros = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.println("\n¡Vehículo registrado con éxito!");
    }

    public static void calcularDespacho(Scanner scanner) {
        System.out.println("\n--- Módulo: Calculadora de Costo de Despacho ---");

        // Primero, verificar si un vehículo ha sido registrado.
        if (vehiculoMarca.equals("No registrado")) {
            System.out.println("\nERROR: No se ha registrado ningún vehículo.");
            System.out.println("Por favor, registre un vehículo usando la Opción 1 del menú.");
            return; // Salir del método si no hay vehículo
        }

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
            if (montoCompra >= MONTO_MINIMO_GRATIS) {
                costoDespacho = 0;
            } else if (montoCompra >= MONTO_MINIMO_TARIFA_NORMAL) {
                costoDespacho = kilometros * TARIFA_NORMAL;
            } else {
                costoDespacho = kilometros * TARIFA_ALTA;
            }

            double totalPagar = montoCompra + costoDespacho;

            System.out.println("\n========= RESUMEN FINAL DE ENTREGA =========");
            // Sección de la Compra
            System.out.println("--- Resumen del Pedido ---");
            System.out.println("Monto de la Compra: $" + String.format("%.0f", montoCompra));
            System.out.println("Distancia de Despacho: " + kilometros + " km");
            System.out.println("Costo de Despacho: $" + String.format("%.0f", costoDespacho));
            System.out.println("----------------------------------");
            System.out.println("Total a Pagar: $" + String.format("%.0f", totalPagar));

            // Sección del Transporte
            System.out.println("\n--- Datos del Vehículo de Despacho ---");
            System.out.println("Marca: " + vehiculoMarca);
            System.out.println("Modelo: " + vehiculoModelo);
            System.out.println("Cilindrada: " + vehiculoCilindrada + "cc");
            System.out.println("Combustible: " + vehiculoCombustible);
            System.out.println("Capacidad: " + vehiculoCapacidadPasajeros + " pasajeros.");
            System.out.println("==========================================");
        }
    }
}