/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;

public class Puesto {

    private Sistema miModelo;
    public Puesto(String nombrePuesto, String tipoPuesto, ArrayList<String> listaTemas) {
        this.nombrePuesto = nombrePuesto;
        this.tipoPuesto = tipoPuesto;
        this.listaTemas= listaTemas;
    }
    private String nombrePuesto;
    private String tipoPuesto;
    private ArrayList<String> listaTemas;

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public String getTipoPuesto() {
        return tipoPuesto;
    }

    public ArrayList<String> getTematicaList() {
        return listaTemas;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public void setTipoPuesto(String tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    public void setTematicaList(ArrayList<String> listaTemas) {
        this.listaTemas = listaTemas;
    }
}

