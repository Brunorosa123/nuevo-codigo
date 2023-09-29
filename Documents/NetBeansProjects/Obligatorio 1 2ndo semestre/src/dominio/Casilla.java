
/*package dominio;

import java.util.Random;

public class Casilla {
    
}
/*


 */
package dominio;

import java.util.Random;


public class Tablero {

    /**
     *
     * @param filas
     * @param columnas
     * @return
     */
   
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
         
    public String[][] generarMatrizInicial(int filas, int columnas, boolean esRoja) {
    String[][] matriz = new String[filas][columnas];
    String color = (esRoja) ? "\u001B[31m" : "\u001B[34m"; // Rojo o azul

    for (int fila = 0; fila < filas; fila++) {
        for (int col = 0; col < columnas; col++) {
            matriz[fila][col] = String.format(" %s%s\u001B[0m ", color, "-"); // Espacio a la izquierda y a la derecha
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
    if (celda.contains("|")){
        for (String[] matriz1 : matriz) {
            celda = matriz1[columna];
            if (celda.contains(rojo)) {
                matriz1[columna] = celda.replace(rojo, azul);
            } else if (celda.contains(azul)) {
                matriz1[columna] = celda.replace(azul, rojo);
            }
        }
    }
    if(celda.contains("/")){
    int i = fila;
        int j = columna;
        while (i < matriz.length && j < matriz[i].length) {
            celda = matriz[i][j];
            if (celda.contains(rojo)) {
                matriz[i][j] = celda.replace(rojo, azul);
            } else if (celda.contains(azul)) {
                matriz[i][j] = celda.replace(azul, rojo);
            }
            i++;
            j++;
        }
    }
    if (celda.contains("\\")) {
        int i = fila;
        int j = columna;
        while (i < matriz.length && j >= 0) {
            celda = matriz[i][j];
            if (celda.contains(rojo)) {
                matriz[i][j] = celda.replace(rojo, azul);
            } else if (celda.contains(azul)) {
                matriz[i][j] = celda.replace(azul, rojo);
            }
            i++;
            j--;
        }
    }
    }  
    
    
    public String[][] jugarNivel(int filas, int columnas, int nivel, boolean esRoja) {
    // Crear una matriz completamente roja o azul al azar
    String[][] matriz = generarMatrizInicial(filas, columnas, esRoja);
    mostrarConBordes(matriz);

    Random rand = new Random();
    for (int i = 0; i < nivel; i++) {
        int fila = rand.nextInt(filas);
        int columna = rand.nextInt(columnas);
        cambiarColorPorSimbolo(matriz, fila, columna);
        mostrarConBordes(matriz);
    }

    return matriz; // Devolvemos la matriz después de los movimientos
}

  

  
   
}