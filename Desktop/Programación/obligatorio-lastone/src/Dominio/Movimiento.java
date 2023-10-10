/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author brumo
 */


public class Movimiento {

    private int fila;
    private int columna;

    public Movimiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // Agrega getters si deseas acceder a la fila y columna desde fuera de la clase
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
