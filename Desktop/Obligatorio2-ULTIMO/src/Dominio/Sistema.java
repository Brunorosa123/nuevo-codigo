
package Dominio;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Sistema implements Serializable{

    private PropertyChangeSupport manejador = new PropertyChangeSupport(this);

    public ArrayList<Postulante> listaPostulantes;
    public ArrayList<Evaluador> listaEvaluadores;
    public ArrayList<Puesto> listaPuestos;
    public ArrayList<Tematica> listaTematicas;
    public ArrayList<Entrevista> listaEntrevistas;
    public ArrayList<Persona> listaPersonas;
    
    public Sistema() {
        listaTematicas = new ArrayList<Tematica>();
        listaPostulantes = new ArrayList<Postulante>();
        listaEvaluadores = new ArrayList<Evaluador>();
        listaPuestos = new ArrayList<Puesto>();
        listaEntrevistas = new ArrayList<Entrevista>();
        listaPersonas = new ArrayList<Persona>();
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

    public void agregarEntrevista(Entrevista entrev) {
        manejador.firePropertyChange("entrevistaagregada", null, entrev);
        listaEntrevistas.add(entrev);
    }

    
    public ArrayList<Persona> getListaPersonas(){
        return listaPersonas;
    }
    
    public ArrayList<Tematica> getListaTematicas() {
        return listaTematicas;
    }

    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }

    public ArrayList<Evaluador> getListaEvaluadores() {
        return listaEvaluadores;
    }

    public ArrayList<Puesto>getListaPuestos() {
        return listaPuestos;
    }

    public ArrayList<Entrevista> getListaEntrevistas() {
        return listaEntrevistas;
    }

    public void setListaPersonas(ArrayList listaPersonas) {
        this.listaPersonas = listaPersonas;
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

    public void setListaEntrevistas(ArrayList listaEntrevistas) {
        this.listaEntrevistas = listaEntrevistas;
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

    public ArrayList<Postulante> obtenerPostulantesConEntrevistas() {
        ArrayList<Postulante> postulantesConEntrevistas = new ArrayList<>();

        for (Entrevista entrevista : listaEntrevistas) {
            postulantesConEntrevistas.add(entrevista.getPostulante());
        }

        return postulantesConEntrevistas;
    }

    public ArrayList<Postulante> obtenerPostulantesConTematicasYNivel(ArrayList<String> tematicas, int nivel) {
        ArrayList<Postulante> postulantesAprobados = new ArrayList<>();

        for (Postulante postulante : listaPostulantes) {
            // Verificar si el postulante tiene todas las temáticas con el nivel deseado
            if (postulante.tieneTodasTematicasConNivel(tematicas, nivel)) {
                postulantesAprobados.add(postulante);
            }
        }

        return postulantesAprobados;
    }

    public ArrayList<Postulante> obtenerPostulantesPorTipoTrabajo(String tipoTrabajo) {
        ArrayList<Postulante> postulantesFiltrados = new ArrayList<>();

        for (Postulante postulante : listaPostulantes) {
            if (postulante.getTipoTrabajoPostulante().equals(tipoTrabajo)) {
                postulantesFiltrados.add(postulante);
            }
        }

        return postulantesFiltrados;
    }

    public ArrayList<Postulante> obtenerPostulantesSinEntrevistas() {
        ArrayList<Postulante> postulantesSinEntrevistas = new ArrayList<>();

        ArrayList<Postulante> todosPostulantes = getListaPostulantes();

        // Verificar si cada postulante tiene entrevistas
        for (Postulante postulante : todosPostulantes) {
            boolean tieneEntrevistas = false;

            for (Entrevista entrevista : listaEntrevistas) {
                if (entrevista.getPostulante().equals(postulante)) {
                    tieneEntrevistas = true;
                    break;  // Una vez que se encuentra una entrevista, podemos salir del bucle interno
                }
            }

            // Si el postulante NO tiene entrevistas, agregar a la lista
            if (!tieneEntrevistas) {
                postulantesSinEntrevistas.add(postulante);
            }
        }

        return postulantesSinEntrevistas;
    }

    public void guardardatosentxt() throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("archivoguardar.txt"));
        out.writeObject(this);
        out.close();
    
        }
    


}


