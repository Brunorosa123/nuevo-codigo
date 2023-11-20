package Interfaz;

import Dominio.Sistema;
import java.io.IOException;


public class Prueba {
    
    public static void main(String[] args) throws IOException {
           
        Sistema sist = new Sistema();

        Comienzo ventanaPrincipal= new Comienzo(sist );
        ventanaPrincipal.setVisible(true);
        
    
    }
    }
   