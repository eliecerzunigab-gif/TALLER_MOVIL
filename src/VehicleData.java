// package src; // Opcional: Define el paquete donde se encuentra la clase. Útil para organización.

// import: Es una palabra clave que se utiliza para incluir clases de otros paquetes.
// java.util.Scanner: Es la ruta completa a la clase 'Scanner', que nos permite leer la entrada del usuario.
import java.util.Scanner;

// public: Es un modificador de acceso. Significa que la clase 'VehicleData' es accesible desde cualquier otra clase.
// class: Es la palabra clave para declarar una clase en Java.
// VehicleData: Es el nombre que le damos a nuestra clase. Por convención, los nombres de las clases empiezan con mayúscula.
public class VehicleData {

    // public: Modificador de acceso que hace que el método 'main' sea accesible desde fuera de la clase.
    // static: Palabra clave que indica que el método pertenece a la clase en sí, no a una instancia de la misma. Se puede llamar sin crear un objeto.
    // void: Palabra clave que indica que este método no devuelve ningún valor.
    // main: Es el nombre especial del método que la Máquina Virtual de Java (JVM) busca para iniciar la ejecución del programa.
    // (String[] args): Son los parámetros del método. 'String[]' declara un array de 'String', y 'args' es el nombre de la variable que almacena los argumentos pasados por línea de comandos.
    public static void main(String[] args) {

        // Scanner: Es el tipo de objeto que vamos a crear.
        // scanner: Es el nombre de nuestra variable, que contendrá la referencia al objeto Scanner.
        // =: Es el operador de asignación.
        // new: Es la palabra clave que se usa para crear una nueva instancia (un nuevo objeto) de una clase.
        // Scanner(System.in): Llama al constructor de la clase Scanner, pasándole 'System.in' (el flujo de entrada estándar, usualmente el teclado) como argumento.
        Scanner scanner = new Scanner(System.in);

        // String: Es el tipo de dato para cadenas de texto.
        // marca, modelo, tipoCombustible: Son los nombres de las variables que almacenarán los datos ingresados. Se declaran varias en una línea, separadas por comas.
        String marca, modelo, tipoCombustible;
        
        // int: Es el tipo de dato para números enteros.
        // cilindrada, capacidadPasajeros: Son los nombres de las variables que almacenarán los datos numéricos.
        int cilindrada, capacidadPasajeros;

        // System: Es una clase final en el paquete java.lang.
        // out: Es un miembro estático de la clase System, una instancia de PrintStream, que representa la salida estándar (la consola).
        // println: Es un método de la clase PrintStream que imprime el texto que se le pasa como argumento y luego salta a la siguiente línea.
        // ("..."): Es el argumento de tipo String que se le pasa al método println.
        System.out.println("Por favor, ingrese la marca del vehiculo:");
        // marca: La variable donde se guardará el resultado.
        // =: Operador de asignación.
        // scanner: Nuestro objeto Scanner.
        // nextLine(): Es un método del objeto Scanner que lee toda la línea de texto ingresada por el usuario hasta que presiona Enter.
        marca = scanner.nextLine();

        System.out.println("Por favor, ingrese el modelo del vehiculo:");
        modelo = scanner.nextLine();

        System.out.println("Por favor, ingrese la cilindrada del vehiculo (en cc):");
        // cilindrada: La variable donde se guardará el resultado.
        // scanner.nextInt(): Método del Scanner que lee el próximo token de la entrada como un entero (int).
        cilindrada = scanner.nextInt();
        
        // scanner.nextLine(): Se consume el carácter de nueva línea que queda en el búfer después de leer un número con nextInt().
        // Esto es crucial para evitar que la siguiente lectura de texto (nextLine) se salte, ya que leería esta nueva línea vacía.
        scanner.nextLine(); 

        System.out.println("Por favor, ingrese el tipo de combustible:");
        tipoCombustible = scanner.nextLine();

        System.out.println("Por favor, ingrese la capacidad de pasajeros:");
        capacidadPasajeros = scanner.nextInt();

        // Se imprime una línea en blanco para separar la entrada de la salida.
        System.out.println("\n--- Resumen de los Datos Ingresados ---");

        // System.out.println("..."): Imprime el texto concatenado.
        // +: Es el operador de concatenación de cadenas. Une el texto literal con el valor de la variable.
        System.out.println("La marca que ha ingresado es: " + marca);
        System.out.println("El modelo que ha ingresado es: " + modelo);
        System.out.println("La cilindrada que ha ingresado es: " + cilindrada + "cc");
        System.out.println("El tipo de combustible es: " + tipoCombustible);
        System.out.println("Tiene una capacidad de " + capacidadPasajeros + " pasajeros.");

        // scanner: Nuestro objeto Scanner.
        // close(): Es un método que cierra el scanner y libera los recursos del sistema que estaba utilizando. Es una buena práctica cerrar los recursos que abrimos.
        scanner.close();
    }
}
