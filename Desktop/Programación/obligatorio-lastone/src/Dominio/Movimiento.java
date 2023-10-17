//Bruno Rosa(318321), Maximo Reyna().

package Dominio;

import java.util.ArrayList;

public class Movimiento {

    private int fila;
    private int columna;
    private static ArrayList<Movimiento> historialMovimientos = new ArrayList<>();
    static ArrayList<Movimiento> historialSolucion = new ArrayList<>();

    
    public Movimiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        // Agregar el movimiento al historial solo si no está duplicado
        if (!historialMovimientos.contains(this)) {
            historialMovimientos.add(this);
        }
       
    }

    // Agrega getters si deseas acceder a la fila y columna desde fuera de la clase
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public static void mostrarHistorialMovimientos() {
        if (historialMovimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados en el historial.");
            return;
        }

        System.out.println("Historial de Movimientos:");
        for (int i = 0; i < historialMovimientos.size(); i++) {
            Movimiento movimiento = historialMovimientos.get(i);
            String formato = "(" + movimiento.getFila() + ", " + movimiento.getColumna() + ")";
            System.out.print(formato);

            if (i < historialMovimientos.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void mostrarSolucion() {
        if (historialMovimientos.isEmpty()) {
            System.out.println("No hay movimientos registrados en el historial.");
            return;
        }

        for (int i = historialMovimientos.size() - 1; i >= 0; i--) {
            Movimiento movimiento = historialMovimientos.get(i);
            String formato = "(" + movimiento.getFila() + "." + movimiento.getColumna() + ")";
            System.out.print(formato);

            if (i > 0) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < historialSolucion.size(); i++) {
            Movimiento movimiento = historialSolucion.get(i);
            String formato = "(" + movimiento.getFila() + "." + movimiento.getColumna() + ")";
            System.out.print(formato);

            if (i < historialSolucion.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Movimiento movimiento = (Movimiento) obj;
        return fila == movimiento.fila && columna == movimiento.columna;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.fila;
        hash = 17 * hash + this.columna;
        return hash;
    }
}