/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;


public class Sistema {
    
private ArrayList<Postulante> listaPostulantes;
private ArrayList<Evaluador> listaEvaluadores;
private ArrayList<Puesto> listaPuestos;
private ArrayList<Tematica> listaTematicas;

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

    public void setListaTematicas(ArrayList listaTematicas) {
        this.listaTematicas = listaTematicas;
    }

    public ArrayList getListaTematicas() {
        return listaTematicas;
    }
    
    
}