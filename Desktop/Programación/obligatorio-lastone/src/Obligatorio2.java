
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
                letras = Tablero.generarMatrizAleatoria(filas, columnas);
            }
            case "b" -> {

                letras = Tablero.generarMatrizAleatoria(5, 6);

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

                tablero.guardarCopiaMatriz();
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
            Movimiento ultimoMovimiento = null; // Variable para almacenar el último movimiento registrado

            while (!tablero.finalMatriz(letras)) {
                System.out.println("Ingrese el numero de la fila que desea cambiar:");
                String filasInput = scanner.nextLine();
                if (filasInput.equalsIgnoreCase("x")) {
                    System.exit(0);
                }

                // Verificar si el usuario ingresó -1
                if (filasInput.equals("-1")) {
                    System.out.println("Ingrese el numero de la columna que desea cambiar:");
                    String columnasInput = scanner.nextLine();
                    if (columnasInput.equalsIgnoreCase("x")) {
                        System.exit(0);
                    }

                    int columna = Integer.parseInt(columnasInput);

                    if (ultimoMovimiento != null) {
                        // Realizar nuevamente el mismo movimiento (último movimiento registrado)
                        tablero.cambiarColorPorSimbolo(letras, ultimoMovimiento.getFila(), ultimoMovimiento.getColumna());
                        movimientosRealizados.add(new Movimiento(ultimoMovimiento.getFila(), ultimoMovimiento.getColumna()));
                    } else {
                        System.out.println("No hay movimientos para retroceder.");
                    }
                } else {
                    int fila = Integer.parseInt(filasInput);
                    System.out.println("Ingrese el numero de la columna que desea cambiar:");
                    String columnasInput = scanner.nextLine();
                    if (columnasInput.equalsIgnoreCase("x")) {
                        System.exit(0);
                    }
                    int columna = Integer.parseInt(columnasInput);

                    tablero.cambiarColorPorSimbolo(letras, fila, columna);

                    // Registrar el movimiento realizado
                    movimientosRealizados.add(new Movimiento(fila, columna));

                    // Actualizar el último movimiento
                    ultimoMovimiento = new Movimiento(fila, columna);
                }

                // Mostrar la matriz después de cada iteración del bucle (una vez)
                tablero.mostrarConBordes(letras);
            }

            System.out.println("¡Ganaste!");

            // Mostrar los movimientos realizados
            tablero.mostrarMovimientos(movimientosRealizados);
        }

    }
}
