/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Sistema {

    private PropertyChangeSupport manejador = new PropertyChangeSupport(this);

    public ArrayList<Postulante> listaPostulantes;
    public ArrayList<Evaluador> listaEvaluadores;
    public ArrayList<Puesto> listaPuestos;
    public ArrayList<Tematica> listaTematicas;

    public Sistema() {
        listaTematicas = new ArrayList<Tematica>();
        // Inicializa la lista de temáticas vacía.
        listaPostulantes = new ArrayList<Postulante>();
        listaEvaluadores = new ArrayList<Evaluador>();
        listaPuestos = new ArrayList<Puesto>();

    }

    public void agregarTematica(Tematica tema) {
        manejador.firePropertyChange("tematicaAgregada", null, tema);
        listaTematicas.add(tema);

    }

    public void agregarPuesto(Puesto puest) {
        manejador.firePropertyChange("tematicaAgregada", null, puest);
        listaPuestos.add(puest);

    }

    public void agregarPostulante(Postulante postu) {
        manejador.firePropertyChange("postulanteagregado", null, postu);
        listaPostulantes.add(postu);
    }

    public void agregarEvaluador(Evaluador evalu) {
        manejador.firePropertyChange("evaluadoragregado", null, evalu);
        listaEvaluadores.add(evalu);
    }

    // Obtener la lista de temáticas
    public ArrayList<Tematica> getListaTematicas() {
        return listaTematicas;
    }

    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }

    public ArrayList<Evaluador> getListaEvaluadores() {
        return listaEvaluadores;
    }

    public ArrayList getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPostulantes(ArrayList listaPostulantes) {
        this.listaPostulantes = listaPostulantes;
    }

    public void setListaEvaluadores(ArrayList listaEvaluadores) {
        this.listaEvaluadores = listaEvaluadores;
    }

    public void setListaPuestos(ArrayList listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public void agregarEscuchas(PropertyChangeListener c) {
        manejador.addPropertyChangeListener(c);
    }

      public Puesto obtenerPuestoPorNombre(String nombrePuesto) {
        for (Puesto puesto : listaPuestos) {
            if (puesto.getNombrePuesto().equals(nombrePuesto)) {
                return puesto;
            }
        }
        return null;
    }

    public ArrayList<Postulante> obtenerPostulantesConTematicas(ArrayList<String> tematicas) {
        ArrayList<Postulante> postulantesConTematicas = new ArrayList<>();

        for (Postulante postulante : listaPostulantes) {
            // Verificar si el postulante tiene todas las temáticas requeridas
            if (postulante.getTematicasConNiveles().containsAll(tematicas)) {
                postulantesConTematicas.add(postulante);
            }
        }

        return postulantesConTematicas;
    }
}
