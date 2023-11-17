/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

public class Entrevista implements Serializable {

    private Postulante postulante;
    private Evaluador evaluador;
    private String comentario;
    private int puntaje;
    private int numeroEntrevista;

    public int getNumeroEntrevista() {
        return numeroEntrevista;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setNumeroEntrevista(int numeroEntrevista) {
        this.numeroEntrevista = numeroEntrevista;
    }

    public Entrevista(Postulante postulante, Evaluador evaluador, String comentario, int puntaje, int numeroEntrevista) {
        this.postulante = postulante;
        this.evaluador = evaluador;
        this.comentario = comentario;
        this.puntaje = puntaje;
        this.numeroEntrevista = numeroEntrevista;
    }

    public String getComentario() {
        return comentario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getNumEntrevista() {
        return numeroEntrevista;
    }

    public Postulante getPostulante() {
        return this.postulante;
    }

    public Evaluador getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }
}
