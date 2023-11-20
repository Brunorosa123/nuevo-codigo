
package Interfaz;

import Dominio.Sistema;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Comienzo extends javax.swing.JFrame {

    private Sistema miModelo;

    public Comienzo(Sistema s) {
        initComponents();
        this.miModelo = s;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        botonDatosAnteriores = new javax.swing.JButton();
        botonNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonDatosAnteriores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonDatosAnteriores.setText("Tomar datos guardados anteriormente");
        botonDatosAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDatosAnterioresActionPerformed(evt);
            }
        });

        botonNuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonNuevo.setText("Partir desde un sistema vacío");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO AL SISTEMA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDatosAnteriores)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(botonDatosAnteriores)
                .addGap(53, 53, 53)
                .addComponent(botonNuevo)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonDatosAnterioresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDatosAnterioresActionPerformed

        try {
            ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("archivoguardar.txt")));
            Sistema modelo = (Sistema)in.readObject();
            miModelo= modelo;
            Inicio ventanaPrincipal = new Inicio(miModelo);
            ventanaPrincipal.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Comienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_botonDatosAnterioresActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        Inicio ventanaPrincipal = new Inicio(miModelo);
        ventanaPrincipal.setVisible(true);
        dispose();
        }//GEN-LAST:event_botonNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDatosAnteriores;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
