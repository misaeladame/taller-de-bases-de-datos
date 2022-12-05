import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.Modelo3;

public class OrdenesDialog extends javax.swing.JDialog {

    private FramePrincipal frmPrincipal;
    private Modelo3 modelo;
    private String accion;
    private Vector<String> vecTiposColumnas;
    private String sql;
    
    public OrdenesDialog(java.awt.Frame parent, Modelo3 modelo3) {
        super(parent, true);
        initComponents();
        
        frmPrincipal = (FramePrincipal)parent;
        this.modelo = modelo3;
        vecTiposColumnas = frmPrincipal.getVecTiposColumnas();
        accion = (modelo==null)? FramePrincipal.NUEVO : FramePrincipal.EDITAR;
        setTitle(accion);
        
        this.setLocationRelativeTo(null);
        
        inicializarFormulario();
    }

    private void inicializarFormulario(){
        if(accion.equals(FramePrincipal.NUEVO)){
            jTxtIDOrden.requestFocus();
        }else if(accion.equals(FramePrincipal.EDITAR)){
            jTxtIDOrden.setText(String.valueOf(modelo.getId()));
            jTxtIDProducto.setText(String.valueOf(modelo.getIdpro()));
            jTxtIDCliente.setText(String.valueOf(modelo.getCli_id()));
            jTxtFecha.setText(String.valueOf(modelo.getForden()));
            jTxtTotal.setText(String.valueOf(modelo.getTotal()));
            
            jTxtIDOrden.requestFocus();
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
        jTxtFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtIDOrden = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtIDProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtIDCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtTotal = new javax.swing.JTextField();

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
        jLabel1.setText("Fecha de Orden");

        jTxtFecha.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/orden new.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel2.setText("ID Orden");

        jTxtIDOrden.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel3.setText("ID Producto");

        jTxtIDProducto.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel4.setText("ID Cliente");

        jTxtIDCliente.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel7.setText("Total");

        jTxtTotal.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jTxtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtIDOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(jTxtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtIDOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.ordenes_inserta_nuevo);
            args = new Object[][]{
                {vecTiposColumnas.elementAt(0), modelo.getId()},
                {vecTiposColumnas.elementAt(2), modelo.getCli_id()},
                {vecTiposColumnas.elementAt(0), modelo.getId()},
                {vecTiposColumnas.elementAt(1), modelo.getIdpro()},
                {vecTiposColumnas.elementAt(3), modelo.getForden()},
                {vecTiposColumnas.elementAt(4), modelo.getTotal()}
            };
        }else if(accion.equals(FramePrincipal.EDITAR)){
            mensaje = "El registro ha sido modificado";
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.ordenes_actualiza_datos);
            args = new Object[][]{
                {vecTiposColumnas.elementAt(2), modelo.getCli_id()},
                {vecTiposColumnas.elementAt(0), modelo.getId()},
                {vecTiposColumnas.elementAt(1), modelo.getIdpro()},
                {vecTiposColumnas.elementAt(3), modelo.getForden()},
                {vecTiposColumnas.elementAt(0), modelo.getId()},
                {vecTiposColumnas.elementAt(4), modelo.getTotal()}
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
        int pro_id = 0;
        try{
            pro_id = Integer.parseInt(jTxtIDProducto.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtIDProducto.requestFocus();
            return false;
        }
        
        String forden = jTxtFecha.getText();
        if(forden.trim().equals("")){
            dialogoMensaje("No se permite un valor en blanco");
            jTxtFecha.requestFocus();
            return false;
        }
        
        int ord_id = 0;
        try{
            ord_id = Integer.parseInt(jTxtIDOrden.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtIDOrden.requestFocus();
            return false;
        }
        
        int cli_id = 0;
        try{
            cli_id = Integer.parseInt(jTxtIDCliente.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtIDCliente.requestFocus();
            return false;
        }

        int total = 0;
        try{
            total = Integer.parseInt(jTxtTotal.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtTotal.requestFocus();
            return false;
        }
        
        modelo = new Modelo3(ord_id, pro_id, cli_id, forden, total);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTxtFecha;
    private javax.swing.JTextField jTxtIDCliente;
    private javax.swing.JTextField jTxtIDOrden;
    private javax.swing.JTextField jTxtIDProducto;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
