
package Interfaz;


import Dominio.Postulante;
import Dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author maxim
 */
public class BajaPostulantes extends javax.swing.JFrame implements PropertyChangeListener{

    private Sistema miModelo; 

    DefaultListModel<String> modelojlistbaja = new DefaultListModel<>();
    
    
 
    public  BajaPostulantes(Sistema s) {
        initComponents();
        this.miModelo = s;
        jListPost.setModel(modelojlistbaja);
    
        for (Postulante postulante : miModelo.getListaPostulantes()) {
            modelojlistbaja.addElement(postulante.getNombre());
    }
    
 //   public void actualizarJList() {
      //  modelojlist.clear(); // Limpiar el modelo actual
     //   for (Postulante postulante : miModelo.getListaPostulantes()) {
    //        modelojlist.addElement(postulante.getNombre());
    //    }
   // }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPost = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Baja postulante");

        jScrollPane1.setViewportView(jListPost);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Obtener el índice seleccionado en la JList
    int indiceSeleccionado = jListPost.getSelectedIndex();

    // Verificar si se seleccionó un elemento
    if (indiceSeleccionado != -1) {
        // Obtener el nombre del postulante seleccionado
        String postulanteEliminar = modelojlistbaja.getElementAt(indiceSeleccionado);

        // Eliminar el postulante del modelo de lista
        modelojlistbaja.remove(indiceSeleccionado);

        // Eliminar el postulante de la lista original en el sistema
        for (Postulante postulante : miModelo.getListaPostulantes()) {
            if (postulante.getNombre().equals(postulanteEliminar)) {
                miModelo.getListaPostulantes().remove(postulante);
                break; // Importante: salir del bucle después de eliminar el postulante
            }
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListPost;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
