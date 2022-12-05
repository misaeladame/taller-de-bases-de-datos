
import modelo.Modelo1;

public class ProductosDialog extends javax.swing.JDialog {

    private FramePrincipal frmPrincipal;
    private Modelo1 modelo;
    private String accion;
    
    public ProductosDialog(java.awt.Frame parent, Modelo1 modelo1) {
        super(parent, true);
        initComponents();
        
        frmPrincipal = (FramePrincipal)parent;
        this.modelo = modelo;
        accion = (modelo==null)? FramePrincipal.NUEVO : FramePrincipal.EDITAR;
        setTitle(accion);
        
        this.setLocationRelativeTo(null);
        
        inicializarFormulario();
    }

    private void inicializarFormulario(){
        if(accion.equals(FramePrincipal.NUEVO)){
            jTxtCodigo.requestFocus();
        }else if(accion.equals(FramePrincipal.EDITAR)){
            jTxtCodigo.setText(String.valueOf(modelo.getCodigo()));
            jTxtNombre.setText(modelo.getNombre());
            jTxtCantidad.setText(String.valueOf(modelo.getCantidad()));
            
            jTxtCodigo.requestFocus();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBTipo = new javax.swing.JComboBox<>();
        jTxtCantidad = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBtnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnBuscar.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/correcto.png"))); // NOI18N
        jBtnBuscar.setText("Guardar");
        jBtnBuscar.setToolTipText("Guardar");
        jBtnBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnBuscar.setFocusable(false);
        jBtnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel3.setText("Tipo de Producto");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jLabel4.setText("Cantidad");

        jCBTipo.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Refrescos", "Frituras", "Dulces", "Frutas", "Verduras" }));

        jTxtCantidad.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jTxtNombre.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jTxtCodigo.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Coca.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(jTxtCodigo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 10, Short.MAX_VALUE))
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
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jTxtCantidad;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
