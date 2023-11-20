
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Postulante extends Persona implements Comparable<Postulante>, Serializable {

    private int telefono;
    private String mail;
    private String linkedin;
    private String tipoTrabajo;
    private ArrayList<String> tematicasConNiveles;

    public Postulante(String nombre, int cedula, String direccion, int telefono, String mail, String linkedin, String tipoTrabajo, ArrayList<String> tematicasConNiveles) {
        super(nombre, cedula, direccion);
        this.telefono = telefono;
        this.mail = mail;
        this.linkedin = linkedin;
        this.tipoTrabajo = tipoTrabajo;
        this.tematicasConNiveles = tematicasConNiveles != null ? tematicasConNiveles : new ArrayList<>();

    }

    public int getTelPostulante() {
        return telefono;
    }

    public String getMailPostulante() {
        return mail;
    }

    public String getLinkedinPostulante() {
        return linkedin;
    }

    public int getNivelPostulante() {
        int nivel = 0;
        return nivel;
    }

    public String getTipoTrabajoPostulante() {
        return tipoTrabajo;
    }

    public void agregarTematicasConNiveles(String tematica) {
        tematicasConNiveles.add(tematica);
    }

    public ArrayList<String> getTematicasConNiveles() {
        return tematicasConNiveles;
    }

    @Override
    public int compareTo(Postulante otro) {
        return Integer.compare(this.cedula, otro.cedula);
    }
    @Override

    public String toString() {
        return this.getNombre() + "(" + this.getCedula() + ")";
    }

    
    public boolean tieneTodasTematicasConNivel(ArrayList<String> tematicas, int nivel) {
        for (String tematica : tematicas) {
            // Verificar si el postulante tiene la temática con el nivel deseado
            if (!tematicasConNiveles.contains(tematica + "(" + nivel + ")")) {
                return false;
            }
        }
        return true;
    }
}
