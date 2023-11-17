/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;


public class Evaluador extends Persona implements Serializable{
 
    private int añoIngreso;

    public Evaluador(String nombre, int cedula, String direccion, int añoingresoEv) {
        super(nombre, cedula, direccion);
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }
    
    
}
