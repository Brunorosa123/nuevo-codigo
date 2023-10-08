
import Dominio.Movimiento;
import Dominio.Tablero;
import java.util.*;

public class Obligatorio2 {

    private static long tiempoInicio; // Variable para registrar el tiempo de inicio

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        int filas = 0; 
        int columnas = 0;
        int nivel = 0;
        ArrayList<Movimiento> movimientosRealizados = new ArrayList<>();

        System.out.println("¡Bienvenido al programa!");

        System.out.println("Por favor, elija una opcion");
        System.out.println("a) Tomar datos del archivo “datos.txt”");
        System.out.println("b) Usar el tablero predefinido");
        System.out.println("c) Usar un tablero al azar");

        String opcion = scanner.nextLine();

        while (!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c") && !opcion.equals("x")) {
            System.out.println("Opcion invalida. Por favor, elija una opcion valida.");
            opcion = scanner.nextLine();
        }

        String[][] letras = null; 

        switch (opcion) {
            case "a" -> {
                
                System.out.println("Ingrese la cantidad de filas (m):");
                filas = scanner.nextInt();
                System.out.println("Ingrese la cantidad de columnas (n):");
                columnas = scanner.nextInt();
                letras = tablero.generarMatrizAleatoria(filas, columnas); 
            }
            case "b" -> {

                letras = tablero.generarMatrizAleatoria(5, 6); 
                
            }
            case "c" -> {
                System.out.println("Ingrese la cantidad de filas");
                String filasInput = scanner.nextLine();
                if (filasInput.equalsIgnoreCase("x")) {
                    System.exit(0);
                }
                filas = Integer.parseInt(filasInput);

                System.out.println("Ingrese la cantidad de columnas");
                String columnasInput = scanner.nextLine();
                if (columnasInput.equalsIgnoreCase("x")) {
                    System.exit(0);
                }
                columnas = Integer.parseInt(columnasInput);

                System.out.println("Ingrese el nivel (1 al 9):");
                String nivelInput = scanner.nextLine();
                if (nivelInput.equalsIgnoreCase("x")) {
                    System.exit(0);
                }
                nivel = Integer.parseInt(nivelInput);

                letras = tablero.generarMatrizAleatoriaColores(filas, columnas, nivel, movimientosRealizados);
            }

            case "x" -> {
                System.out.println("Saliendo del programa...");
                return; 
            }
            default ->
                System.out.println("Opcion invalida, Por favor elija una opcion valida.");
        }

        if (letras != null) {
            tablero.mostrarConBordes(letras);
            while (!tablero.finalMatriz(letras)) {
                
                System.out.println("Ingrese el numero de la fila que desea cambiar:");
                String filasInput = scanner.nextLine();
                if (filasInput.equalsIgnoreCase("x")) {
                    System.exit(0);}
                System.out.println("Ingrese el numero de la columna que desea cambiar:");
                String columnasInput = scanner.nextLine();
                 if (columnasInput.equalsIgnoreCase("x")) {
                    System.exit(0);}
                columnas = Integer.parseInt(columnasInput);
                filas = Integer.parseInt(filasInput);
                tablero.cambiarColorPorSimbolo(letras, filas, columnas);
                tablero.mostrarConBordes(letras);

            }
              System.out.println("Ganaste !"  ); //falta agregar el tiempo (+ tiempo) 

        }

    }
}
