package Interfaz;

import Dominio.Tablero;
import java.util.*;

public class Obligatorio2 {

    private static long tiempoInicio; // Variable para registrar el tiempo de inicio

    public static void main(String[] args) {
        Menu();
        Tablero tablero = new Tablero(); // Crear una instancia de la clase Tablero si es necesario
    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();

        System.out.println("¡Bienvenido al programa!");

        
            System.out.println("Por favor, elija una opción:");
            System.out.println("a) Tomar datos del archivo “datos.txt”");
            System.out.println("b) Usar el tablero predefinido");
            System.out.println("c) Usar un tablero al azar");

            String opcion = scanner.nextLine();

            while (!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c") && !opcion.equals("x")) {
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
                opcion = scanner.nextLine();
            }

            String[][] letras = null; // Declarar la variable fuera del switch

            switch (opcion) {

                case "a" -> {
                    // Llama al método generarMatrizAleatoria y muestra el tablero
                    System.out.println("Ingrese la cantidad de filas (m):");
                    int filas = scanner.nextInt();
                    System.out.println("Ingrese la cantidad de columnas (n):");
                    int columnas = scanner.nextInt();
                    letras = tablero.generarMatrizAleatoria(filas, columnas); // Asignar valor en este caso
                }
                case "b" -> {
                    // Llama al método generarMatrizAleatoria y muestra el tablero
                    letras = tablero.generarMatrizAleatoria(5, 6); // Asignar valor en este caso
                }
                case "c" -> {
                    
                    System.out.println("Ingrese la cantidad de filas (m):");
                    String filasInput = scanner.nextLine();
                    if (filasInput.equalsIgnoreCase("x")) {
                        System.exit(0);
                    }
                    int filas = Integer.parseInt(filasInput);

                    System.out.println("Ingrese la cantidad de columnas (n):");
                    String columnasInput = scanner.nextLine();
                    if (columnasInput.equalsIgnoreCase("x")) {
                        System.exit(0);
                    }
                    int columnas = Integer.parseInt(columnasInput);
                    
                    letras = tablero.generarMatrizAleatoriaColores(filas, columnas);
                }
                
                case "x" -> {
                    System.out.println("Saliendo del programa...");
                    return; // Terminar el programa
                }
                default ->
                    System.out.println("Opcion invalida. Por favor, elija una opcion valida.");
            }

            if (letras != null) {
                tiempoInicio = System.currentTimeMillis(); // Registra el tiempo de inicio
                // Llama al método mostrarConBordes solo si letras no es nulo
                tablero.mostrarConBordes(letras);
                // Calcula y muestra el tiempo total al final del juego
                long tiempoTotal = System.currentTimeMillis() - tiempoInicio;
                System.out.println("Tiempo total: " + (tiempoTotal / 1000) + " segundos");
                while(true){
                System.out.println("Ingrese el numero de la fila que desea cambiar:");
                int fila = scanner.nextInt();
                System.out.println("Ingrese el numero de la columna que desea cambiar:");
                int columna = scanner.nextInt();
                tablero.cambiarColorPorSimbolo(letras, fila, columna);
                // Vuelve a mostrar el tablero después de cambiar el color
                tablero.mostrarConBordes(letras);
            }
        }
    }
}
