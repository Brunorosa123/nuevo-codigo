package Dominio;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {

    private String[][] matriz;
    private int nivel;
    private ArrayList<Movimiento> movimientos;
    private String colorRojo;
    private String colorAzul;

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

    public Boolean finalMatriz(String[][] matriz) {
        Boolean fin= false;
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
            if(ok==0){
            fin= true;
            }
        
       
        return fin;
    }
}
