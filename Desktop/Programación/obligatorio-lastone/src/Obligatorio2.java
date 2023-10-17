//Bruno Rosa(318321), Maximo Reyna().

import Dominio.Movimiento;
import Dominio.Tablero;
import java.io.File;
import java.io.FileNotFoundException;
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
        ArrayList<Movimiento> movimientosSolucion = new ArrayList<>();

        while (true) {
            System.out.println("Bienvenido a Soliflips, si desea jugar ingrese 1, de lo contrario ingrese 2");
            String res = scanner.nextLine();

            if (res.equals("2")) {
                System.out.println("Saliendo del programa...");
                System.exit(0);
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
                        try {
                            String rojo = "\u001B[31m";
                            String azul = "\u001B[34m";
                            String resetColor = "\u001B[0m";

                            Scanner input = new Scanner(new File(".\\Test\\datos.txt"));

                            int filasIn = input.nextInt();
                            int columnasIn = input.nextInt();
                            input.nextLine();

                            String[][] matriz = new String[filasIn][columnasIn];

                            for (int i = 0; i < filasIn; i++) {
                                String linea = input.nextLine();
                                String[] elementos = linea.split(" ");
                                for (int j = 0; j < columnasIn; j++) {
                                    String simbolo = elementos[j].substring(0, 1);
                                    String color = elementos[j].substring(1);
                                    if (color.equals("R")) {
                                        matriz[i][j] = rojo + simbolo + resetColor;
                                    } else if (color.equals("A")) {
                                        matriz[i][j] = azul + simbolo + resetColor;
                                    } else {
                                        matriz[i][j] = simbolo;
                                    }
                                }
                            }
                            tablero.mostrarConBordesTxt(matriz);
                            int numPasos = input.nextInt();

                            while (input.hasNextInt()) {
                                int filaMovimiento = input.nextInt();
                                int columnaMovimiento = input.nextInt();
                                movimientosSolucion.add(new Movimiento(filaMovimiento, columnaMovimiento));
                            }

                            while (!tablero.matriztodacompleta(matriz)) {

                                System.out.println("Ingresenumero el  de la fila que desea cambiar (-1 para retroceder, 'x' para salir):");
                                String filasInput = scanner.nextLine();
                                if (filasInput.equalsIgnoreCase("x")) {
                                    System.exit(0);
                                } else if (filasInput.equalsIgnoreCase("h")) {
                                    Movimiento.mostrarHistorialMovimientos();
                                    continue;

                                } else if (filasInput.equalsIgnoreCase("s")) {
                                    Movimiento.mostrarSolucion();
                                    continue;
                                } else if (filasInput.equals("-1")) {
                                    System.out.println("Ingrese el numero de la columna que desea cambiar (-1 para retroceder, 'x' para salir):");
                                    String columnasInput = scanner.nextLine();
                                    if (columnasInput.equalsIgnoreCase("x")) {
                                        System.exit(0);
                                    } else if (columnasInput.equalsIgnoreCase("h")) {
                                        Movimiento.mostrarHistorialMovimientos();
                                        continue;
                                    } else if (columnasInput.equalsIgnoreCase("s")) {
                                        Movimiento.mostrarSolucion();
                                        continue;
                                    } else if (columnasInput.equals("-1")) {
                                        if (!movimientosRealizados.isEmpty()) {
                                            // Retroceder un paso
                                            Movimiento movimientoRetroceder = movimientosRealizados.remove(movimientosRealizados.size() - 1);
                                            int filaRetroceder = movimientoRetroceder.getFila();
                                            int columnaRetroceder = movimientoRetroceder.getColumna();
                                            tablero.cambiarColorPorSimbolo(matriz, filaRetroceder, columnaRetroceder);
                                            tablero.mostrarConBordes(matriz);
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
                                    String[][] matrizAntes = tablero.copiarMatriz(matriz);

                                    tablero.cambiarColorPorSimbolo(matriz, fila, columna);

                                    // Registrar el movimiento realizado
                                    movimientosRealizados.add(new Movimiento(fila, columna));
                                    // Actualizar el último movimiento
                                    ultimoMovimiento = new Movimiento(fila, columna);

                                    tablero.mostrarConBordesTxt(matriz);

                                }
                            }

                        } catch (FileNotFoundException ex) {
                            System.err.println("El archivo no se encontró o no se puede acceder.");
                        }
                    }
                    
                    case "b" -> {
                        letras = Tablero.generarMatrizAleatoria(5, 6);

                    }
                    case "c" -> {

                        while (true) {
                            System.out.println("Ingrese la cantidad de filas (3 a 9):");
                            String filasInput = scanner.nextLine();
                            if (filasInput.equalsIgnoreCase("x")) {
                                System.exit(0);
                            }
                            filas = Integer.parseInt(filasInput);

                            if (filas >= 3 && filas <= 9) {
                                break; // Salir del bucle si las filas son válidas
                            } else {
                                System.out.println("El número de filas debe estar entre 3 y 9. Por favor, ingrese un valor válido.");
                            }
                        }

                        while (true) {
                            System.out.println("Ingrese la cantidad de columnas (3 a 9):");
                            String columnasInput = scanner.nextLine();
                            if (columnasInput.equalsIgnoreCase("x")) {
                                System.exit(0);
                            }
                            columnas = Integer.parseInt(columnasInput);

                            if (columnas >= 3 && columnas <= 9) {
                                break; // Salir del bucle si las columnas son válidas
                            } else {
                                System.out.println("El número de columnas debe estar entre 3 y 9. Por favor, ingrese un valor válido.");
                            }
                        }

                        while (true) {
                            System.out.println("Ingrese el nivel (1 a 8):");
                            String nivelInput = scanner.nextLine();
                            if (nivelInput.equalsIgnoreCase("x")) {
                                System.exit(0);
                            }
                            nivel = Integer.parseInt(nivelInput);

                            if (nivel >= 1 && nivel <= 8) {
                                break; // Salir del bucle si el nivel es válido
                            } else {
                                System.out.println("El nivel debe estar en el rango de 1 a 8. Por favor, ingrese un nivel válido.");
                            }
                        }

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

                        System.out.println("Ingresenumero el  de la fila que desea cambiar (-1 para retroceder, 'x' para salir):");
                        String filasInput = scanner.nextLine();
                        if (filasInput.equalsIgnoreCase("x")) {
                            System.exit(0);
                        } else if (filasInput.equalsIgnoreCase("h")) {
                            Movimiento.mostrarHistorialMovimientos();
                            continue;
                        } else if (filasInput.equalsIgnoreCase("s")) {
                            Movimiento.mostrarSolucion();
                            continue;
                        }

                        if (filasInput.equals("-1")) {
                            System.out.println("Ingrese el numero de la columna que desea cambiar (-1 para retroceder, 'x' para salir):");
                            String columnasInput = scanner.nextLine();
                            if (columnasInput.equalsIgnoreCase("x")) {
                                System.exit(0);
                            } else if (columnasInput.equalsIgnoreCase("h")) {
                                Movimiento.mostrarHistorialMovimientos();
                                continue;
                            } else if (columnasInput.equalsIgnoreCase("s")) {
                                Movimiento.mostrarSolucion();
                                continue;
                                
                            } else if (columnasInput.equals("-1")) {
                                if (!movimientosRealizados.isEmpty()) {
                                    // Retroceder un paso
                                    Movimiento movimientoRetroceder = movimientosRealizados.remove(movimientosRealizados.size() - 1);
                                    int filaRetroceder = movimientoRetroceder.getFila();
                                    int columnaRetroceder = movimientoRetroceder.getColumna();
                                    tablero.cambiarColorPorSimbolo(letras, filaRetroceder, columnaRetroceder);
                                    tablero.mostrarConBordes(letras);
                                    movimientosRealizados.add(new Movimiento(-1, -1));
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
                            tablero.mostrarMatricesConflechas(matrizAntes, letras);
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

               
                }
            }
        }

    }
}
