import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.Modelo1;

public class ProductosDialog extends javax.swing.JDialog {

    private FramePrincipal frmPrincipal;
    private Modelo1 modelo;
    private String accion;
    private Vector<String> vecTiposColumnas;
    private String sql;
    
    public ProductosDialog(java.awt.Frame parent, Modelo1 modelo1) {
        super(parent, true);
        initComponents();
        
        frmPrincipal = (FramePrincipal)parent;
        this.modelo = modelo1;
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
            jTxtCodigo.setText(String.valueOf(modelo.getCodigo()));
            jTxtNombre.setText(modelo.getNombre());
            jTxtTipo.setText(modelo.getTipo());
            jTxtCantidad.setText(String.valueOf(modelo.getCantidad()));
            jTxtPrecio.setText(String.valueOf(modelo.getPrecio()));
            
            jTxtID.setEnabled(false);
            jTxtCodigo.requestFocus();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtCantidad = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtTipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBtnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnGuardar.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/correcto.png"))); // NOI18N
        jBtnGuardar.setText("Guardar");
        jBtnGuardar.setToolTipText("Guardar");
        jBtnGuardar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnGuardar.setFocusable(false);
        jBtnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnGuardar);

        jBtnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        jBtnCerrar.setText("Cerrar");
        jBtnCerrar.setToolTipText("Cerrar");
        jBtnCerrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnCerrar.setFocusable(false);
        jBtnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCerrarActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnCerrar);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel3.setText("Tipo de Producto");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel4.setText("Cantidad");

        jTxtCantidad.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jTxtNombre.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jTxtCodigo.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Coca.png"))); // NOI18N

        jTxtTipo.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel6.setText("ID");

        jTxtID.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel7.setText("Precio");

        jTxtPrecio.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jTxtNombre))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTxtTipo)
                                    .addComponent(jTxtPrecio))))
                        .addGap(9, 9, 9)))
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
        Object[][] args = null;
        String mensaje = "";
        
        if(validarDatos()==false){
            return;
        }
        
        if(accion.equals(FramePrincipal.NUEVO)){
            mensaje = "El registro ha sido agregado";
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.productos_inserta_nuevo);
            args = new Object[][]{
                {vecTiposColumnas.elementAt(0), modelo.getId()},
                {vecTiposColumnas.elementAt(1), modelo.getCodigo()},
                {vecTiposColumnas.elementAt(2), modelo.getNombre()},
                {vecTiposColumnas.elementAt(3), modelo.getTipo()},
                {vecTiposColumnas.elementAt(4), modelo.getCantidad()},
                {vecTiposColumnas.elementAt(5), modelo.getPrecio()}
            };
        }else if(accion.equals(FramePrincipal.EDITAR)){
            mensaje = "El registro ha sido modificado";
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.productos_actualiza_datos);
            args = new Object[][]{
                {vecTiposColumnas.elementAt(1), modelo.getCodigo()},
                {vecTiposColumnas.elementAt(2), modelo.getNombre()},
                {vecTiposColumnas.elementAt(3), modelo.getTipo()},
                {vecTiposColumnas.elementAt(4), modelo.getCantidad()},
                {vecTiposColumnas.elementAt(5), modelo.getPrecio()},
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
    }//GEN-LAST:event_jBtnGuardarActionPerformed
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
        
        String tipo = jTxtTipo.getText();
        if(tipo.trim().equals("")){
            dialogoMensaje("No se permite un valor en blanco");
            jTxtTipo.requestFocus();
            return false;
        }
        
        int cantidad = 0;
        try{
            cantidad = Integer.parseInt(jTxtCantidad.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtCantidad.requestFocus();
            return false;
        }

        int codigo = 0;
        try{
            codigo = Integer.parseInt(jTxtCodigo.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtCodigo.requestFocus();
            return false;
        }
        
        int precio = 0;
        try{
            precio = Integer.parseInt(jTxtPrecio.getText());
        } catch(NumberFormatException ex){
            dialogoMensaje("Debe capturar un valor numerico valido");
            jTxtPrecio.requestFocus();
            return false;
        }
        
        modelo = new Modelo1(id, codigo, nombre, tipo, cantidad, precio);
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
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTxtCantidad;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtID;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtPrecio;
    private javax.swing.JTextField jTxtTipo;
    // End of variables declaration//GEN-END:variables
}
