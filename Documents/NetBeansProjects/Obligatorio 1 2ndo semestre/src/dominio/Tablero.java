package Dominio;

import java.util.Random;

public class Tablero {

    public String[][] generarMatrizAleatoria(int filas, int columnas) {
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
        for (String[] matriz1 : matriz) {
            bordesCeldas(matriz[0].length);
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print("|" + matriz1[col]);
            }
            System.out.println("|");
        }
        bordesCeldas(matriz[0].length);
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
                celda = matriz[fila][j];
                if (celda.contains(rojo)) {
                    matriz[fila][j] = celda.replace(rojo, azul);
                } else if (celda.contains(azul)) {
                    matriz[fila][j] = celda.replace(azul, rojo);
                }
            }
        }
        if (celda.contains("|")) {
            for (int i = 0; i < matriz.length; i++) {
                celda = matriz[i][columna];
                if (celda.contains(rojo)) {
                    matriz[i][columna] = celda.replace(rojo, azul);
                } else if (celda.contains(azul)) {
                    matriz[i][columna] = celda.replace(azul, rojo);
                }
            }
            // Cambiar el color de la posición seleccionada
            if (celda.contains(rojo)) {
                celda = celda.replace(rojo, azul);
            } else if (celda.contains(azul)) {
                celda = celda.replace(azul, rojo);
            }
        }

        if (celda.contains("\\")) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (i - j == fila - columna) {  // Verifica si la celda está en la diagonal
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

    public String[][] generarMatrizAleatoriaColores(int filas, int columnas) {
        String[][] matriz = new String[filas][columnas];
        Random rand = new Random();
        String[] simbolos = {"|", "/", "\\", "-"};

        // Elige un color aleatorio para toda la matriz
        String color = (rand.nextBoolean()) ? "\u001B[31m" : "\u001B[34m"; // Rojo o azul

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int indice = rand.nextInt(simbolos.length);
                String simbolo = simbolos[indice];
                matriz[fila][col] = String.format(" %s%s\u001B[0m ", color, simbolo); // Espacio a la izquierda y a la derecha
            }
        }

        return matriz;
    }

}
