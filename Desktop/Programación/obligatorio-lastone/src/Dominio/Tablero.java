package Dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tablero {

    private String[][] matriz;
    private String[][] copiaMatriz;

    private int nivel;
    private String colorRojo;
    private String colorAzul;
    private ArrayList<Movimiento> movimientos;

    // Constructor por defecto
    public Tablero() {
        // Inicializa las variables con valores predeterminados
        matriz = null;
        nivel = 0;
        movimientos = new ArrayList<>();
        colorRojo = "\u001B[31m";
        colorAzul = "\u001B[34m";
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

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int indice = rand.nextInt(simbolos.length);
                String simbolo = simbolos[indice];
                String color = (rand.nextBoolean()) ? "\u001B[31m" : "\u001B[34m"; // Rojo o azul
                matriz[fila][col] = String.format(" %s%s\u001B[0m ", color, simbolo); // Espacio a la izquierda y a la derecha
            }
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

    public void bordesCeldas(int numCeldas) {
        for (int c = 0; c < numCeldas; c++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public void cambiarColorPorSimbolo(String[][] matriz, int fila, int columna) {
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

    public String[][] generarMatrizAleatoriaColores(int filas, int columnas, int nivel, ArrayList<Movimiento> movimientos) {
        String[][] matrizGenerar = new String[filas][columnas];
        Random rand = new Random();
        String[] simbolos = {"|", "/", "\\", "-"};

        String colorInicial = (rand.nextBoolean()) ? "\u001B[31m" : "\u001B[34m"; // Rojo o azul

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int indice = rand.nextInt(simbolos.length);
                String simbolo = simbolos[indice];
                matrizGenerar[fila][col] = String.format(" %s%s\u001B[0m ", colorInicial, simbolo); // Espacio a la izquierda y a la derecha
            }
        }

        for (int i = 0; i < nivel; i++) {
            int filaAleatoria = rand.nextInt(filas);
            int columnaAleatoria = rand.nextInt(columnas);
            cambiarColorPorSimbolo(matrizGenerar, filaAleatoria, columnaAleatoria);

            movimientos.add(new Movimiento(filaAleatoria, columnaAleatoria)); // Agrega el movimiento a la lista
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

    public void mostrarMovimientos(ArrayList<Movimiento> movimientos) {
        System.out.println("Movimientos realizados:");
        for (Movimiento movimiento : movimientos) {
            System.out.println("Fila: " + movimiento.getFila() + ", Columna: " + movimiento.getColumna());
        }

    }

    private String[][] copiarMatriz(String[][] source) {
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

  public void mostrardosmatrices(){
      String flecha= "==>";
      
  }
}
