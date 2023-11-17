


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;


public class Tematica implements Serializable{

    
    public Tematica(String nombreTematica, String descripcion) {
        this.nombreTematica = nombreTematica;
        this.descripcionTematica = descripcion;
    }
    
    private String nombreTematica;
    private String descripcionTematica;

    public void setNombreTematica(String nombreTematica) {
        this.nombreTematica = nombreTematica;
    }

    public void setDescripcionTematica(String descripcionTematica) {
        this.descripcionTematica = descripcionTematica;
    }

    public String getNombreTematica() {
        return nombreTematica;
    }

    public String getDescripcionTematica() {
        return descripcionTematica;
    }
    
    @Override
public String toString() {
    return this.nombreTematica;
}


}
