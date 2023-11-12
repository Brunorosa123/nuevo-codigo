/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author brumo
 */
public class Postulante extends Persona{
    
    private int telefono;
    private String mail;
    private String linkedin;
    private String tipoTrabajo;

    public Postulante (String nombre, int cedula, String direccion, int telefono, String mail, String linkedin, String tipoTrabajo) {
        super(nombre,cedula,direccion);
        this.telefono = telefono;
        this.mail = mail;
        this.linkedin = linkedin;
        this.tipoTrabajo = tipoTrabajo;
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

}
