import java.util.Scanner;

public class CalculadoraDespacho {

    public static void main(String[] args) {
        // Definición de constantes para las reglas de negocio. 
        // Esto hace que el código sea más fácil de leer y modificar en el futuro.
        final int LIMITE_RADIO_KM = 20;
        final int TARIFA_ALTA = 300;
        final int TARIFA_NORMAL = 150;
        final int MONTO_MINIMO_TARIFA_NORMAL = 25000;
        final int MONTO_MINIMO_GRATIS = 50000;

        Scanner scanner = new Scanner(System.in);

        // --- ENTRADA DE DATOS ---
        System.out.println("--- Calculadora de Costo de Despacho ---");

        System.out.print("Por favor, ingrese el monto total de la compra: ");
        double montoCompra = scanner.nextDouble();

        System.out.print("Por favor, ingrese la distancia en kilometros desde el centro X a su casa: ");
        int kilometros = scanner.nextInt();

        // --- PROCESAMIENTO DE DATOS (LÓGICA DE NEGOCIO) ---
        double costoDespacho = 0;

        // 1. Validar si el despacho está dentro del radio de cobertura.
        if (kilometros > LIMITE_RADIO_KM) {
            System.out.println("\nLo sentimos, el despacho no está disponible para su ubicación (" + kilometros + " km).");
            System.out.println("El radio máximo de despacho es de " + LIMITE_RADIO_KM + " km.");
        } else {
            // 2. Calcular el costo del despacho según las reglas.
            if (montoCompra >= MONTO_MINIMO_GRATIS) {
                costoDespacho = 0; // Despacho gratuito
            } else if (montoCompra >= MONTO_MINIMO_TARIFA_NORMAL) {
                costoDespacho = kilometros * TARIFA_NORMAL;
            } else { // Si la compra es menor a MONTO_MINIMO_TARIFA_NORMAL
                costoDespacho = kilometros * TARIFA_ALTA;
            }

            // 3. Calcular el total final.
            double totalPagar = montoCompra + costoDespacho;

            // --- SALIDA DE DATOS ---
            System.out.println("\n--- Resumen del Pedido ---");
            System.out.println("Monto de la Compra: $" + String.format("%.0f", montoCompra));
            System.out.println("Distancia de Despacho: " + kilometros + " km");
            System.out.println("Costo de Despacho: $" + String.format("%.0f", costoDespacho));
            System.out.println("----------------------------------");
            System.out.println("Total a Pagar: $" + String.format("%.0f", totalPagar));
        }

        scanner.close();
    }
}
