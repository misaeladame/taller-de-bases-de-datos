import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.Modelo5;

public class EmpleadosDialog extends javax.swing.JDialog {

    private FramePrincipal frmPrincipal;
    private Modelo5 modelo;
    private String accion;
    private Vector<String> vecTiposColumnas;
    private String sql;
    
    public EmpleadosDialog(java.awt.Frame parent, Modelo5 modelo5) {
        super(parent, true);
        initComponents();
        
        frmPrincipal = (FramePrincipal)parent;
        this.modelo = modelo5;
        vecTiposColumnas = frmPrincipal.getVecTiposColumnas();
        accion = (modelo==null)? FramePrincipal.NUEVO : FramePrincipal.EDITAR;
        setTitle(accion);
        
        this.setLocationRelativeTo(null);
        
        inicializarFormulario();
    }

    private void inicializarFormulario(){
        if(accion.equals(FramePrincipal.NUEVO)){
            jTxtID.requestFocus();
        }else if(accion.equals(FramePrincipal.EDITAR)){
            jTxtID.setText(String.valueOf(modelo.getId()));
            jTxtDireccion.setText(modelo.getDireccion());
            jTxtNombre.setText(modelo.getNombre());
            jTxtRFC.setText(modelo.getRfc());
            jTxtCURP.setText(modelo.getCurp());
            jTxtControl.setText(String.valueOf(modelo.getNcontrol()));
            jTxtSupervisor.setText(String.valueOf(modelo.getSupervisor()));
            
            jTxtID.requestFocus();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBtnBuscar = new javax.swing.JButton();
        jBtnBuscar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jTxtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtRFC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtCURP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtControl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtSupervisor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBtnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/correcto.png"))); // NOI18N
        jBtnBuscar.setText("Guardar");
        jBtnBuscar.setToolTipText("Guardar");
        jBtnBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnBuscar.setFocusable(false);
        jBtnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnBuscar);

        jBtnBuscar1.setBackground(new java.awt.Color(255, 255, 255));
        jBtnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        jBtnBuscar1.setText("Cerrar");
        jBtnBuscar1.setToolTipText("Cerrar");
        jBtnBuscar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnBuscar1.setFocusable(false);
        jBtnBuscar1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscar1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnBuscar1);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel1.setText("Dirección");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel2.setText("Nombre");

        jTxtNombre.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jTxtDireccion.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/katy.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel3.setText("RFC");

        jTxtRFC.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel4.setText("CURP");

        jTxtCURP.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel6.setText("Nº Control");

        jTxtControl.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel8.setText("Supervisor");

        jTxtSupervisor.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel9.setText("ID");

        jTxtID.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(jTxtID)
                                    .addComponent(jTxtNombre)
                                    .addComponent(jTxtRFC, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(jTxtCURP)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtControl, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnBuscar1ActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        Object[][] args = null;
        String mensaje = "";
        
        if(validarDatos()==false){
            return;
        }
        
        if(accion.equals(FramePrincipal.NUEVO)){
            mensaje = "El registro ha sido agregado";
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.empleados_inserta_nuevo);
            args = new Object[][]{
                {vecTiposColumnas.elementAt(0), modelo.getId()},
                {vecTiposColumnas.elementAt(1), modelo.getDireccion()},
                {vecTiposColumnas.elementAt(2), modelo.getNombre()},
                {vecTiposColumnas.elementAt(3), modelo.getRfc()},
                {vecTiposColumnas.elementAt(4), modelo.getCurp()},
                {vecTiposColumnas.elementAt(5), modelo.getNcontrol()},
                {vecTiposColumnas.elementAt(6), modelo.getSupervisor()}
            };
        }else if(accion.equals(FramePrincipal.EDITAR)){
            mensaje = "El registro ha sido modificado";
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.empleados_actualiza_datos);
            args = new Object[][]{
                {vecTiposColumnas.elementAt(1), modelo.getDireccion()},
                {vecTiposColumnas.elementAt(2), modelo.getNombre()},
                {vecTiposColumnas.elementAt(3), modelo.getRfc()},
                {vecTiposColumnas.elementAt(4), modelo.getCurp()},
                {vecTiposColumnas.elementAt(5), modelo.getNcontrol()},
                {vecTiposColumnas.elementAt(6), modelo.getSupervisor()},
                {vecTiposColumnas.elementAt(0), modelo.getId()}
            };
        }
        
        try {
            int regs = EjecutorSQL.sqlEjecutar(sql, args);
            if(regs==1){
                JOptionPane.showMessageDialog(this, mensaje,accion,JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            dialogoMensaje(ex.toString());
        }
        dispose();
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void dialogoMensaje(String Mensaje){
        JOptionPane.showMessageDialog(this, Mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    private boolean validarDatos(){
        int id = 0;
        try{
            id = Integer.parseInt(jTxtID.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtID.requestFocus();
            return false;
        }
        
        String nombre = jTxtNombre.getText();
        if(nombre.trim().equals("")){
            dialogoMensaje("No se permite un valor en blanco");
            jTxtNombre.requestFocus();
            return false;
        }
        
        String direccion = jTxtDireccion.getText();
        if(direccion.trim().equals("")){
            dialogoMensaje("No se permite un valor en blanco");
            jTxtDireccion.requestFocus();
            return false;
        }
        
        String rfc = jTxtRFC.getText();
        if(rfc.trim().equals("")){
            dialogoMensaje("No se permite un valor en blanco");
            jTxtRFC.requestFocus();
            return false;
        }

        String curp = jTxtCURP.getText();
        if(curp.trim().equals("")){
            dialogoMensaje("No se permite un valor en blanco");
            jTxtCURP.requestFocus();
            return false;
        }
        
        int ncontrol = 0;
        try{
            ncontrol = Integer.parseInt(jTxtControl.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtControl.requestFocus();
            return false;
        }
        
        int supervisor = 0;
        try{
            supervisor = Integer.parseInt(jTxtSupervisor.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtSupervisor.requestFocus();
            return false;
        }
        
        modelo = new Modelo5(id, direccion, nombre, rfc, curp, ncontrol, supervisor);
        return true;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductosDialog dialog = new ProductosDialog(new javax.swing.JFrame(), null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnBuscar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTxtCURP;
    private javax.swing.JTextField jTxtControl;
    private javax.swing.JTextField jTxtDireccion;
    private javax.swing.JTextField jTxtID;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtRFC;
    private javax.swing.JTextField jTxtSupervisor;
    // End of variables declaration//GEN-END:variables
}
