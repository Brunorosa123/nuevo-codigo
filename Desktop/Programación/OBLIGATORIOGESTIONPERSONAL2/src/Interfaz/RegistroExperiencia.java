package Interfaz;

import Dominio.Postulante;
import Dominio.Tematica;
import Dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

public class RegistroExperiencia extends javax.swing.JFrame implements PropertyChangeListener {

    private Sistema miModelo;
    private Postulante postu;

    DefaultListModel<String> modelojlistpostnivel = new DefaultListModel<>();
    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 10, 1);

    public RegistroExperiencia(Sistema s) {
        this.miModelo = s;
        initComponents();
        jListconnivel.setModel(modelojlistpostnivel);
        nivelSpinner.setModel(model);

        ComboBoxTematicas.removeAllItems(); // Limpia todos los elementos actuales en el JComboBox.

        for (Tematica tematica : miModelo.listaTematicas) {
            ComboBoxTematicas.addItem(tematica.getNombreTematica());
        }

    }

    private Postulante obtenerPostulanteActual() {
    // Asumiendo que listaPostulantes contiene los postulantes registrados y no está vacía
    if (!miModelo.getListaPostulantes().isEmpty()) {
        return miModelo.getListaPostulantes().get(miModelo.getListaPostulantes().size() - 1);
    } else {
        // Manejo de error o retorno de null según tus necesidades
        return null;
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollBar1 = new javax.swing.JScrollBar();
        jSpinner2 = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        CampoExp = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        list1 = new java.awt.List();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListPost = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        botonRegistrartem = new javax.swing.JButton();
        botonEliminarpostnivel = new javax.swing.JButton();
        agregarNivel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nivelSpinner = new javax.swing.JSpinner();
        ComboBoxTematicas = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListconnivel = new javax.swing.JList<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTextField1.setText("jTextField1");

        jScrollPane2.setViewportView(jTextPane1);

        jScrollPane3.setViewportView(jEditorPane1);

        CampoExp.setColumns(20);
        CampoExp.setRows(5);
        jScrollPane4.setViewportView(CampoExp);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList2);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(jList3);

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(jList4);

        jScrollPane5.setViewportView(jListPost);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonRegistrartem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonRegistrartem.setText("Registrar");
        botonRegistrartem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrartemActionPerformed(evt);
            }
        });

        botonEliminarpostnivel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonEliminarpostnivel.setText("Eliminar");
        botonEliminarpostnivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarpostnivelActionPerformed(evt);
            }
        });

        agregarNivel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        agregarNivel.setText("Agregar");
        agregarNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarNivelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tema:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nivel:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Experiencia:");

        ComboBoxTematicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTematicasActionPerformed(evt);
            }
        });

        jScrollPane9.setViewportView(jListconnivel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ComboBoxTematicas, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nivelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(agregarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonRegistrartem)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(botonEliminarpostnivel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ComboBoxTematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarNivel)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarpostnivel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(botonRegistrartem))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboBoxTematicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxTematicasActionPerformed


    }//GEN-LAST:event_ComboBoxTematicasActionPerformed

    private void botonRegistrartemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrartemActionPerformed
        // Obtén el postulante actual (de alguna manera que tengas implementada en tu código)
    Postulante postulanteActual = obtenerPostulanteActual();

    // Verifica si el postulante actual no es nulo
    if (postulanteActual != null) {
        // Obtiene las temáticas del DefaultListModel
        ArrayList<String> tematicasModelo = new ArrayList<>();
        for (int i = 0; i < modelojlistpostnivel.getSize(); i++) {
            tematicasModelo.add(modelojlistpostnivel.getElementAt(i));
        }

        // Agrega las temáticas al postulante
        for (String tematica : tematicasModelo) {
            postulanteActual.agregarTematicasConNiveles(tematica);
        }
        modelojlistpostnivel.clear();
    }
    }//GEN-LAST:event_botonRegistrartemActionPerformed

    private void agregarNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarNivelActionPerformed
        String nombreTematica = ComboBoxTematicas.getSelectedItem().toString();
        int nivel = (int) nivelSpinner.getValue();

        String tematicaConNivel = nombreTematica + "(" + nivel + ")";

        if (!modelojlistpostnivel.contains(tematicaConNivel)) {
            modelojlistpostnivel.addElement(tematicaConNivel);
        }
    }//GEN-LAST:event_agregarNivelActionPerformed

    private void botonEliminarpostnivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarpostnivelActionPerformed

        if (jListconnivel != null) {

            int indiceSeleccionado = jListconnivel.getSelectedIndex();
            String tematicaEliminar = modelojlistpostnivel.getElementAt(indiceSeleccionado);
            modelojlistpostnivel.remove(indiceSeleccionado);

        }

    }//GEN-LAST:event_botonEliminarpostnivelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CampoExp;
    private javax.swing.JComboBox<String> ComboBoxTematicas;
    private javax.swing.JButton agregarNivel;
    private javax.swing.JButton botonEliminarpostnivel;
    private javax.swing.JButton botonRegistrartem;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jListPost;
    private javax.swing.JList<String> jListconnivel;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private java.awt.List list1;
    private javax.swing.JSpinner nivelSpinner;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("tematicaAgregada".equals(evt.getPropertyName())) {
            // Actualizar el ComboBoxTematicas
            ComboBoxTematicas.removeAllItems();
            for (Tematica tematica : miModelo.getListaTematicas()) {
                ComboBoxTematicas.addItem(tematica.getNombreTematica());
            }
        }
    }
}
