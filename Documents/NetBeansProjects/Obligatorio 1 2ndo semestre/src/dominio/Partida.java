/*

 */
/*package dominio;

import java.util.Random;
import java.util.Scanner;


public class Partida {
    
}

package Interfaz;

import dominio.Tablero;
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
    String[][] letras = null; // Declarar la variable aquí

    System.out.println("¡Bienvenido al programa!");
    System.out.println("Por favor, elija una opción:");
    System.out.println("a) Tomar datos del archivo “datos.txt”");
    System.out.println("b) Usar el tablero predefinido");
    System.out.println("c) Usar un tablero al azar");

    String opcion = scanner.nextLine();

    while (!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c")) {
        System.out.println("Opción inválida. Por favor, elija una opción válida.");
        opcion = scanner.nextLine();
    }

    switch (opcion) {
       case "a" -> {
    System.out.println("Ingrese la cantidad de filas (m):");
    int filas = scanner.nextInt();
    System.out.println("Ingrese la cantidad de columnas (n):");
    int columnas = scanner.nextInt();
    // Corrige la llamada al método a generarMatrizInicial
    letras = tablero.generarMatrizInicial(filas, columnas, new Random().nextBoolean());
}
        case "b" -> {
        letras = tablero.generarMatrizAleatoria(5, 6);
        }
    case "c" -> {
    System.out.println("Ingrese la cantidad de filas (m):");
    int filas = scanner.nextInt();
    System.out.println("Ingrese la cantidad de columnas (n):");
    int columnas = scanner.nextInt();
    System.out.println("Ingrese el nivel (1 a 8):");
    int nivel = scanner.nextInt();
    
    boolean esRoja = new Random().nextBoolean(); // Genera un valor aleatorio para esRoja
    letras = tablero.jugarNivel(filas, columnas, nivel, esRoja); // Asigna la matriz resultante
}
default -> System.out.println("Opción inválida. Por favor, elija una opción válida.");

    }

    if (letras != null) {
        tiempoInicio = System.currentTimeMillis();

        // Lógica para jugar el juego, como cambiar el color, aquí
        
        long tiempoTotal = System.currentTimeMillis() - tiempoInicio;
        System.out.println("Tiempo total: " + (tiempoTotal / 1000) + " segundos");
        
        // Más lógica del juego y visualización del tablero
        
    }
}

}   