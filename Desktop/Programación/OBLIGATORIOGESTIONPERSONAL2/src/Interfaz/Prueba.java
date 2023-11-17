/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Interfaz;

import Dominio.Sistema;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author brumo
 */
public class Prueba {
    
    public static void main(String[] args) throws IOException {
           
       // try{
         //   ObjectOutputStream in = new ObjectOutputStream(Files.newOutputStream(Paths.get("archivoguardar.txt")));
           // out.write
       // }
       // catch(IOException e){
        Sistema sist = new Sistema();

    
        Comienzo ventanaPrincipal= new Comienzo(sist );
        ventanaPrincipal.setVisible(true);
        
    
    }
    }
   // }