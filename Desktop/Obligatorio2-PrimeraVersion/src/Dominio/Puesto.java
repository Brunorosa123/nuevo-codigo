/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;


public class Puesto {

   private String nombrePuesto; 
   private String tipoPuesto;
   private Tematica tematica;

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public String getTipoPuesto() {
        return tipoPuesto;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public void setTipoPuesto(String tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }
   
}
