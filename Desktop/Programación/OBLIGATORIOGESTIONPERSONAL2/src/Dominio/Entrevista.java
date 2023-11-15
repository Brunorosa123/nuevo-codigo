/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;


public class Entrevista{
    private Postulante postulante;
    private Evaluador evaluador;
    private String comentario;
    private int puntaje;
    
    
    public Entrevista(Postulante postulante, Evaluador evaluador, String comentario, int puntaje) {
        this.postulante = postulante;
        this.evaluador = evaluador;
        this.comentario = comentario;
        this.puntaje = puntaje;  
}
        
    
    public String getComentario(){
        return comentario;
    }
    
    public int getPuntaje(){
        return puntaje;
    }

}

