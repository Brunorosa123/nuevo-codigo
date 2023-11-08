/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;


public class Sistema {
    
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
        listaTematicas.add(tema);
    }

    // Obtener la lista de temáticas
    public ArrayList<Tematica> getListaTematicas() {
        return listaTematicas;
    }
    public ArrayList getListaPostulantes() {
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

  

    
    
}