/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Interfaz;

import Dominio.Sistema;

/**
 *
 * @author brumo
 */
public class Prueba {
    
    public static void main(String[] args) {
            Sistema sist = new Sistema();

    
        Inicio ventanaPrincipal= new Inicio(sist );
        ventanaPrincipal.setVisible(true);
    
    
    }
    
    }