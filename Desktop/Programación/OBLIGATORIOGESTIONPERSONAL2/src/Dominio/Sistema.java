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

   public void agregarPostulante(Postulante postu){
               manejador.firePropertyChange("postulanteagregado", null, postu);
               listaPostulantes.add(postu);
   }

    
    
    // Obtener la lista de temáticas
    public ArrayList<Tematica> getListaTematicas() {
        return listaTematicas;
    }
    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }

    public ArrayList getListaEvaluadores() {
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
    
    
    public void agregarEscuchas (PropertyChangeListener c){
      manejador.addPropertyChangeListener(c);
  }

    
    
}