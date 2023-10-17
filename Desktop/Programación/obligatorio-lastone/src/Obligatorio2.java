//Bruno Rosa(318321), Maximo Reyna().

import Dominio.Movimiento;
import Dominio.Tablero;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        Movimiento ultimoMovimiento = null; // Variable para almacenar el último movimiento registrado

        while (true) {
            System.out.println("Bienvenido a Soliflips, si desea jugar ingrese 1, de lo contrario ingrese 2");
            String res = scanner.nextLine();

            if (res.equals("2")) {
                System.out.println("Saliendo del programa...");
                return;
            }

            if (!res.equals("1")) {
                System.out.println("Opcion invalida. Por favor, elija una opcion valida.");
                continue;
            }

            if (res.equals("2")) {
                return;
            }

            while (res.equals("1")) {

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
                    tiempoInicio = System.nanoTime();
                    
                    while (!tablero.matriztodacompleta(letras)) {
                        System.out.println("Ingrese el numero de la fila que desea cambiar (-1 para retroceder, 'x' para salir):");
                        String filasInput = scanner.nextLine();
                        if (filasInput.equalsIgnoreCase("x")) {
                            System.exit(0);
                        }

                        if (filasInput.equals("-1")) {
                            System.out.println("Ingrese el numero de la columna que desea cambiar (-1 para retroceder, 'x' para salir):");
                            String columnasInput = scanner.nextLine();
                            if (columnasInput.equalsIgnoreCase("x")) {
                                System.exit(0);
                            } else if (columnasInput.equals("-1")) {
                                if (!movimientosRealizados.isEmpty()) {
                                    // Retroceder un paso
                                    Movimiento movimientoRetroceder = movimientosRealizados.remove(movimientosRealizados.size() - 1);
                                    int filaRetroceder = movimientoRetroceder.getFila();
                                    int columnaRetroceder = movimientoRetroceder.getColumna();
                                    tablero.cambiarColorPorSimbolo(letras, filaRetroceder, columnaRetroceder);
                                    tablero.mostrarConBordes(letras);
                                } else {
                                    System.out.println("No hay movimientos para retroceder.");
                                }
                            } else {
                                System.out.println("Movimiento invalido...");
                            }
                        } else {
                            int fila = Integer.parseInt(filasInput);
                            System.out.println("Ingrese el numero de la columna que desea cambiar:");
                            String columnasInput = scanner.nextLine();
                            if (columnasInput.equalsIgnoreCase("x")) {
                                System.exit(0);
                            }
                            int columna = Integer.parseInt(columnasInput);

                            // Guarda la matriz antes del movimiento
                            String[][] matrizAntes = tablero.copiarMatriz(letras);

                            tablero.cambiarColorPorSimbolo(letras, fila, columna);

                            // Registrar el movimiento realizado
                            movimientosRealizados.add(new Movimiento(fila, columna));

                            // Actualizar el último movimiento
                            ultimoMovimiento = new Movimiento(fila, columna);

                            // Llama al método para mostrar ambas matrices antes y después del movimiento
                            tablero.mostrarMatricesConMovimiento(matrizAntes, letras);
                        }
                    }
                }

                long tiempoFin = System.nanoTime();

                long duracionEnNano = tiempoFin - tiempoInicio;
                long segundos = TimeUnit.NANOSECONDS.toSeconds(duracionEnNano);

                System.out.println("¡Usted ha ganado! El juego duro " + segundos + " segundos.");
                System.out.println("Si desea jugar nuevamente ingrese 1, de lo contrario ingrese 2 para salir.");

                String respuesta = scanner.nextLine();
                if (respuesta.equals("1")) {

                    Menu();

                } else if (respuesta.equals("2")) {
                    return;

                } else {
                    tablero.mostrarMovimientos(movimientosRealizados);
                }
            }
        }

    }
}
