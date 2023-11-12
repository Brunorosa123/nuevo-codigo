/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Dominio.Postulante;
import Dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 *
 * @author brumo
 */
public class AltaPostulante extends javax.swing.JFrame implements PropertyChangeListener {

    private Sistema miModelo;
    private Sistema modelojlist;

    private ArrayList<Integer> cedulasRegistradas = new ArrayList<>();

    public AltaPostulante(Sistema s) {
        initComponents();
        this.miModelo = s;

        grupoDeBotones.add(remoto);
        grupoDeBotones.add(presencial);
        grupoDeBotones.add(mixto);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDeBotones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        presencial = new javax.swing.JRadioButton();
        remoto = new javax.swing.JRadioButton();
        mixto = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        nombrePostu = new javax.swing.JTextField();
        linkedin = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        direccionPostulante = new javax.swing.JTextField();
        telPostulante = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Cédula:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Dirección:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Mail:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Linkedin:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Formato:");

        presencial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        presencial.setText("Presencial");
        presencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presencialActionPerformed(evt);
            }
        });

        remoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        remoto.setText("Remoto");
        remoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remotoActionPerformed(evt);
            }
        });

        mixto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mixto.setText("Mixto");
        mixto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mixtoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Alta Postulante");

        cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaActionPerformed(evt);
            }
        });

        nombrePostu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrePostuActionPerformed(evt);
            }
        });

        linkedin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkedinActionPerformed(evt);
            }
        });

        telPostulante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telPostulanteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cancelar");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Siguiente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(139, 139, 139)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mail, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                                .addComponent(telPostulante)
                                .addComponent(direccionPostulante)
                                .addComponent(cedula)
                                .addComponent(nombrePostu)
                                .addComponent(linkedin))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(remoto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(presencial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(mixto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombrePostu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(direccionPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telPostulante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(linkedin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(remoto)
                    .addComponent(presencial)
                    .addComponent(mixto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaActionPerformed

    private void linkedinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkedinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linkedinActionPerformed

    private void remotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remotoActionPerformed

    private void presencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_presencialActionPerformed

    private void mixtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mixtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mixtoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String nombrePost = nombrePostu.getText();
            int cedulaPost = Integer.parseInt(cedula.getText());

            // Verificar si la cédula ya está registrada
            if (cedulasRegistradas.contains(cedulaPost)) {
                throw new Exception("La cédula ya está registrada.");
            }

            String direccion = direccionPostulante.getText();
            int tel = Integer.parseInt(telPostulante.getText());
            String mailPost = mail.getText();
            String linkedinPostu = linkedin.getText();

            String opcionSeleccionada = "";
            if (remoto.isSelected()) {
                opcionSeleccionada = "remoto";
            } else if (presencial.isSelected()) {
                opcionSeleccionada = "presencial";
            } else if (mixto.isSelected()) {
                opcionSeleccionada = "mixto";
            }

            // Realiza acciones basadas en la opción seleccionada
            if ("remoto".equals(opcionSeleccionada) || "presencial".equals(opcionSeleccionada) || "mixto".equals(opcionSeleccionada)) {
                Postulante postu = new Postulante(nombrePost, cedulaPost, direccion, tel, mailPost, linkedinPostu, opcionSeleccionada);
                miModelo.agregarPostulante(postu);

                // Si se agrega el postulante con éxito, agregar la cédula al array
                cedulasRegistradas.add(cedulaPost);
            }

            // Limpiar los campos después de agregar el Postulante
            nombrePostu.setText("");
            cedula.setText("");
            direccionPostulante.setText("");
            telPostulante.setText("");
            mail.setText("");
            linkedin.setText("");

        } catch (Exception e) {
            // Manejar la excepción, puedes mostrar un mensaje de error o realizar alguna acción específica.
            System.out.println("Error: " + e.getMessage());
        }
        RegistroExperiencia ventanaExp = new RegistroExperiencia(miModelo);

        ventanaExp.setVisible(true);    }//GEN-LAST:event_jButton2ActionPerformed

    private void nombrePostuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrePostuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrePostuActionPerformed

    private void telPostulanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telPostulanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telPostulanteActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField direccionPostulante;
    private javax.swing.ButtonGroup grupoDeBotones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField linkedin;
    private javax.swing.JTextField mail;
    private javax.swing.JRadioButton mixto;
    private javax.swing.JTextField nombrePostu;
    private javax.swing.JRadioButton presencial;
    private javax.swing.JRadioButton remoto;
    private javax.swing.JTextField telPostulante;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
