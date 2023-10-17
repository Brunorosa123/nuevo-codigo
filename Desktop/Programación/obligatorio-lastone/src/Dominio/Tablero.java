//Bruno Rosa(318321), Maximo Reyna().
package Dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tablero {

    private String[][] matriz;

    private int nivel;
    private String colorRojo;
    private String colorAzul;
    private ArrayList<Movimiento> movimientos;
    private ArrayList<Movimiento> movimientosAleatorios;

    // Constructor por defecto
    public Tablero() {
        // Inicializa las variables con valores predeterminados
        matriz = null;
        nivel = 0;
        movimientos = new ArrayList<>();
        colorRojo = "\u001B[31m";
        colorAzul = "\u001B[34m";
        movimientosAleatorios = new ArrayList<>(); // Inicializa la lista de movimientos aleatorios

    }

    // Constructor con parámetros
    public Tablero(int filas, int columnas, int nivel) {
        this.matriz = generarMatrizAleatoria(filas, columnas);
        this.nivel = nivel;
        this.movimientos = new ArrayList<>();
        matriz = new String[filas][columnas];

    }

    // Métodos getter y setter
    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

public static String[][] generarMatrizAleatoria(int filas, int columnas) {
    String[][] matriz = new String[filas][columnas];
    Random rand = new Random();
    String[] simbolos = {"|", "/", "\\", "-"};
    String color = (rand.nextBoolean()) ? "\u001B[31m" : "\u001B[34m"; // Rojo o azul

    // Llena la matriz con símbolos aleatorios
    for (int fila = 0; fila < filas; fila++) {
        for (int col = 0; col < columnas; col++) {
            int indiceSimbolo = rand.nextInt(simbolos.length);
            String simbolo = simbolos[indiceSimbolo];
            matriz[fila][col] = String.format(" %s%s\u001B[0m ", color, simbolo);
        }
    }

    // Realiza 3 movimientos aleatorios
    for (int i = 0; i < 3; i++) {
        int filaAleatoria = rand.nextInt(filas) + 1; // Coordenada de fila aleatoria en el rango 1 a filas
        int columnaAleatoria = rand.nextInt(columnas) + 1; // Coordenada de columna aleatoria en el rango 1 a columnas
        cambiarColorPorSimbolo(matriz, filaAleatoria, columnaAleatoria);
        Movimiento.historialSolucion.add(new Movimiento(filaAleatoria, columnaAleatoria));

    }

    return matriz;
}


    public void mostrarConBordes(String[][] matriz) {
        int numRows = matriz.length;
        int numCols = matriz[0].length;

        // Imprimir números de columna empezando desde 1
        System.out.print(" "); // Espacio en blanco para alinear los números de fila
        for (int col = 0; col < numCols; col++) {
            System.out.print("  " + (col + 1) + " ");
        }
        System.out.println();

        for (int fila = 0; fila < numRows; fila++) {
            // Imprimir la línea superior de la celda
            System.out.print(" ");
            bordesCeldas(numCols);

            // Imprimir el número de fila y el contenido de la celda
            System.out.print(fila + 1 + "|"); // Sumar 1 para que los números de fila empiecen desde 1
            for (int col = 0; col < numCols; col++) {
                System.out.print("" + matriz[fila][col] + "|");

                // Imprimir un espacio en lugar de un borde en la última columna
                if (col == numCols - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            if (fila == numRows - 1) {
                // Imprimir la línea inferior de la matriz después de la última fila
                System.out.print(" ");
                bordesCeldas(numCols);
            }
        }
    }

    public static void cambiarColorPorSimbolo(String[][] matriz, int fila, int columna) {
        fila--;
        columna--;

        if (fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length) {
            String rojo = "\u001B[31m";
            String azul = "\u001B[34m";

            String celda = matriz[fila][columna];
            if (celda.contains("-")) {
                for (int j = 0; j < matriz[fila].length; j++) {
                    if (matriz[fila][j].contains(rojo)) {
                        matriz[fila][j] = matriz[fila][j].replace(rojo, azul);
                    } else if (matriz[fila][j].contains(azul)) {
                        matriz[fila][j] = matriz[fila][j].replace(azul, rojo);
                    }
                }
            }
            if (celda.contains("|")) {
                for (String[] matriz1 : matriz) {
                    if (matriz1[columna].contains(rojo)) {
                        matriz1[columna] = matriz1[columna].replace(rojo, azul);
                    } else if (matriz1[columna].contains(azul)) {
                        matriz1[columna] = matriz1[columna].replace(azul, rojo);
                    }
                }
                if (celda.contains(rojo)) {
                    matriz[fila][columna] = matriz[fila][columna].replace(rojo, azul);
                } else if (celda.contains(azul)) {
                    matriz[fila][columna] = matriz[fila][columna].replace(azul, rojo);
                }
            }

            if (celda.contains("\\")) {

                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (i - j == fila - columna) {  // Verifica si la celda está en la diagonal
                            if (matriz[i][j].contains(rojo)) {
                                matriz[i][j] = matriz[i][j].replace(rojo, azul);
                            } else if (matriz[i][j].contains(azul)) {
                                matriz[i][j] = matriz[i][j].replace(azul, rojo);
                            }
                        }
                    }
                }
            }

            if (celda.contains("/")) {
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        if (i + j == fila + columna) {  // Verifica si la celda está en la diagonal
                            celda = matriz[i][j];
                            if (celda.contains(rojo)) {
                                matriz[i][j] = celda.replace(rojo, azul);
                            }
                            if (celda.contains(azul)) {
                                matriz[i][j] = celda.replace(azul, rojo);
                            }
                        }
                    }
                }

            }
        }
    }

    public String[][] generarMatrizAleatoriaColores(int filas, int columnas, int nivel, ArrayList<Movimiento> movimientos) {
        String[][] matrizGenerar = new String[filas][columnas];
        Random rand = new Random();
        String[] colores = {"\u001B[31m", "\u001B[34m"}; // Rojo y azul
        String[] simbolos = {"|", "/", "\\", "-"};

        // Inicializar matriz con un solo color
        String colorInicial = colores[rand.nextInt(2)]; // Aleatoriamente rojo o azul
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                matrizGenerar[fila][col] = colorInicial + " " + simbolos[rand.nextInt(simbolos.length)] + " " + "\u001B[0m";
            }
        }

        // Realizar movimientos estratégicos para alcanzar el nivel
        for (int i = 0; i < nivel; i++) {
            int filaAleatoria = rand.nextInt(filas);
            int columnaAleatoria = rand.nextInt(columnas);

            // Ajusta las coordenadas para evitar el borde superior e izquierdo
            if (filaAleatoria == 0 && columnaAleatoria == 0) {
                filaAleatoria = 1;
                columnaAleatoria = 1;
            } else if (filaAleatoria == 0) {
                filaAleatoria = 1;
            } else if (columnaAleatoria == 0) {
                columnaAleatoria = 1;
            }

            cambiarColorPorSimbolo(matrizGenerar, filaAleatoria, columnaAleatoria);
            Movimiento.historialSolucion.add(new Movimiento(filaAleatoria, columnaAleatoria));
        }

        return matrizGenerar;
    }

    public Boolean matriztodacompleta(String[][] matriz) {
        Boolean fin = false;
        int ok = 0;
        if (matriz[0][0].contains(colorRojo)) {
            for (int i = 1; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (!matriz[i][j].contains(colorRojo)) {
                        ok++;
                    }
                }
            }
        } else if (matriz[0][0].contains(colorAzul)) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 1; j < matriz[0].length; j++) {
                    if (!matriz[i][j].contains(colorAzul)) {
                        ok++;
                    }
                }
            }
        }
        if (ok == 0) {
            fin = true;
        }

        return fin;
    }

    public String[][] copiarMatriz(String[][] source) {
        if (source == null) {
            return null; // Devuelve null si source es null
        }

        String[][] copy = new String[source.length][];
        for (int i = 0; i < source.length; i++) {
            copy[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return copy;
    }

    private String[][] matrizOriginal = null; // Inicializa matrizOriginal como null

    private List<String[][]> estadosAnteriores = new ArrayList<>(); // Lista para mantener estados anteriores

    public void guardarCopiaMatriz() {
        String[][] copia = copiarMatriz(matriz);
        estadosAnteriores.add(copia); // Agregar copia al final de la lista
    }

    public void mostrarMatricesConflechastxt(String[][] matrizAntes, String[][] matrizDespues) {
        int numRows = matrizAntes.length;
        int numCols = matrizAntes[0].length;
        int columnWidth = 5; // Ancho de las columnas

        // Espacios iniciales para alinear los números de columna
        System.out.print(" ");
        for (int col = 0; col < numCols; col++) {
            System.out.printf("  %d ", col + 1);
        }
        System.out.print("         ");

        for (int col = 0; col < numCols; col++) {
            System.out.printf("  %d ", col + 1);
        }
        System.out.println();

        // Separador horizontal
        String horizontalSeparator = " +";
        for (int i = 0; i < numCols; i++) {
            horizontalSeparator += "---+"; // Aumentar el ancho de las celdas
        }

        // Espacio en blanco para centrar las columnas
        String padding = "  ";

        // Separador vertical
        String separator = "  ==>  ";

        // Imprimir el borde superior de la tabla
        System.out.println(horizontalSeparator + separator + horizontalSeparator);

        // Imprimir las filas de ambas matrices
        for (int fila = 0; fila < numRows; fila++) {
            // Imprimir los elementos de la fila para la matriz antes
            System.out.print((fila + 1));
            for (int col = 0; col < numCols; col++) {
                System.out.printf("| %" + (columnWidth - 2) + "s ", matrizAntes[fila][col]); // Ajustar el ancho de la celda
            }
            System.out.print("|");

            System.out.print(separator);

            System.out.print((fila + 1));
            for (int col = 0; col < numCols; col++) {
                System.out.printf("| %" + (columnWidth - 2) + "s ", matrizDespues[fila][col]); // Ajustar el ancho de la celda
                if (col == numCols - 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            System.out.println(horizontalSeparator + separator + horizontalSeparator);
        }
    }

    public void mostrarMatricesConflechas(String[][] matrizAntes, String[][] matrizDespues) {
        int numRows = matrizAntes.length;
        int numCols = matrizAntes[0].length;
        int columnWidth = 5; // Ancho de las columnas

        // Espacios iniciales para alinear los números de columna
        System.out.print(" ");
        for (int col = 0; col < numCols; col++) {
            System.out.printf("  %d ", col + 1);
        }
        System.out.print("         ");

        for (int col = 0; col < numCols; col++) {
            System.out.printf("  %d ", col + 1);
        }
        System.out.println();

        // Separador horizontal
        String horizontalSeparator = " +";
        for (int i = 0; i < numCols; i++) {
            horizontalSeparator += "---+";
        }

        // Espacio en blanco para centrar las columnas
        String padding = "  ";

        // Separador vertical
        String separator = "  ==>  ";

        // Imprimir el borde superior de la tabla
        System.out.println(horizontalSeparator + separator + horizontalSeparator);

        // Imprimir las filas de ambas matrices
        for (int fila = 0; fila < numRows; fila++) {
            // Imprimir los elementos de la fila para la matriz antes
            System.out.print((fila + 1));
            for (int col = 0; col < numCols; col++) {
                System.out.printf("|%" + columnWidth + "s", matrizAntes[fila][col]);
            }
            System.out.print("|");

            System.out.print(separator);

            System.out.print((fila + 1));
            for (int col = 0; col < numCols; col++) {
                System.out.printf("|%-" + columnWidth + "s", matrizDespues[fila][col]);
                if (col == numCols - 1) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            System.out.println(horizontalSeparator + separator + horizontalSeparator);
        }
    }

    public void bordesCeldas(int numCeldas) {
        for (int c = 0; c < numCeldas; c++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public String[][] mostrarConBordesTxt(String[][] matriz) {
        int numRows = matriz.length;
        int numCols = matriz[0].length;

        // Imprimir los números de columna
        System.out.print("  "); // Espacios iniciales para alinear los números de columna
        for (int col = 0; col < numCols; col++) {
            System.out.printf("  %d ", col + 1);
        }
        System.out.println();

        // Imprimir la línea superior de la matriz
        System.out.print("  ");
        bordesCeldas(numCols);

        for (int fila = 0; fila < numRows; fila++) {
            // Imprimir el número de fila y el contenido de la celda
            System.out.printf("%d |", fila + 1); // Sumar 1 para que los números de fila empiecen desde 1
            for (int col = 0; col < numCols; col++) {
                System.out.printf(" %-3s |", matriz[fila][col]);
            }
            System.out.println();

            // Imprimir la línea inferior de la celda
            System.out.print("  ");
            bordesCeldas(numCols);
        }
        return matriz;
    }

    public void resolverDesdePuntoActual() {
        if (!movimientos.isEmpty()) {
            int nivelOriginal = nivel;
            ArrayList<Movimiento> movimientosOriginales = new ArrayList<>(movimientos);

            // Detener los movimientos aleatorios
            nivel = 0;
            movimientos.clear();

            // Invertir y aplicar los movimientos del usuario
            for (int i = movimientosOriginales.size() - 1; i >= 0; i--) {
                Movimiento movimiento = movimientosOriginales.get(i);
                int fila = movimiento.getFila();
                int columna = movimiento.getColumna();
                cambiarColorPorSimbolo(matriz, fila, columna);
            }

            // Mostrar la matriz resultante
            mostrarConBordes(matriz);

            // Restaurar el nivel y los movimientos originales
            nivel = nivelOriginal;
            movimientos = new ArrayList<>(movimientosOriginales);
        } else {
            System.out.println("No se pueden resolver desde el punto actual ya que no hay movimientos registrados.");
        }
    }
}
