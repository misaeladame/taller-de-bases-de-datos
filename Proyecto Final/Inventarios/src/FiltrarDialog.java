import java.util.Vector;
import javax.swing.JOptionPane;

public class FiltrarDialog extends javax.swing.JDialog {

    private FramePrincipal frmPrincipal;
    private Vector<String> vecColumnas;
    private Vector<String> vecColumnasBD;
    private Vector<String> vecTipos;
    private boolean inicializando = true;
    
    public FiltrarDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        frmPrincipal = (FramePrincipal)parent;
        vecColumnas = frmPrincipal.getVecNombresColumnas();
        vecColumnasBD = frmPrincipal.getVecNombresColumnasBD();
        vecTipos = frmPrincipal.getVecTiposColumnas();
        
        jcboColumna.removeAllItems();
        for(int i = 0; i < vecColumnas.size(); i++){
            jcboColumna.addItem(vecColumnas.elementAt(i));
        }
        
        cargarComparadores(0);
        jcboColumna.setSelectedIndex(0);
        jcboColumna.requestFocus();
        inicializando = false;
    }

    private void cargarComparadores(int pos){
        jcboComparador.removeAllItems();
        if(vecTipos.elementAt(pos).equals(EjecutorSQL.STRING)){
            jtxtValor.setEnabled(true);
            jcboComparador.addItem("Sea igual a...");
            jcboComparador.addItem("Empiece con...");
            jcboComparador.addItem("Termine con...");
            jcboComparador.addItem("Contenga...");
            jcboComparador.addItem("Sea diferente");
        }else if(vecTipos.elementAt(pos).equals(EjecutorSQL.INT)){
            jtxtValor.setEnabled(true);
            jcboComparador.addItem("=");
            jcboComparador.addItem("<>");
            jcboComparador.addItem(">");
            jcboComparador.addItem("<");
            jcboComparador.addItem(">=");
            jcboComparador.addItem("<=");
        }
        jcboComparador.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcboColumna = new javax.swing.JComboBox<>();
        jcboComparador = new javax.swing.JComboBox<>();
        jtxtValor = new javax.swing.JTextField();
        jbtnAceptar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtrar");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N
        jLabel1.setText("Columna");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N
        jLabel2.setText("Comparador");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N
        jLabel3.setText("Valor");

        jcboColumna.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N
        jcboColumna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcboColumna.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcboColumnaItemStateChanged(evt);
            }
        });

        jcboComparador.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N
        jcboComparador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jtxtValor.setFont(new java.awt.Font("Lucida Grande", 0, 17)); // NOI18N

        jbtnAceptar.setText("Aceptar");
        jbtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAceptarActionPerformed(evt);
            }
        });

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jbtnAceptar)
                .addGap(93, 93, 93)
                .addComponent(jbtnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcboColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcboComparador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(55, 55, 55)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcboColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcboComparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnAceptar)
                    .addComponent(jbtnCancelar))
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

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAceptarActionPerformed
        String sql = "";
        String orderby = "";
        String valor = null;
        
        if(jtxtValor.isEnabled() && jtxtValor.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this,"Proporcione un valor","Filtrar",JOptionPane.ERROR_MESSAGE);
            jtxtValor.requestFocus();
            return;
        }
        
        if(frmPrincipal.getModuloActual().equals(FramePrincipal.Tit_Modulo1)){
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.productos_todos_sin_orden);
            orderby = " order by pro_nombre";
        }else if(frmPrincipal.getModuloActual().equals(FramePrincipal.Tit_Modulo2)){
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.distribuidores_todos_sin_orden);
            orderby = " order by dis_nombre";
        }else if(frmPrincipal.getModuloActual().equals(FramePrincipal.Tit_Modulo3)){
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.ordenes_todas_sin_orden);
            orderby = " order by ord_id";
        }else if(frmPrincipal.getModuloActual().equals(FramePrincipal.Tit_Modulo4)){
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.clientes_todos_sin_orden);
            orderby = " order by cli_nombre";
        }else if(frmPrincipal.getModuloActual().equals(FramePrincipal.Tit_Modulo5)){
            sql = frmPrincipal.getPropConsultasSQL().getProperty(FramePrincipal.empleados_todos_sin_orden);
            orderby = " order by ven_nombre";
        }
        
        sql += " WHERE " + vecColumnasBD.elementAt(jcboColumna.getSelectedIndex());
        
        String tipo = vecTipos.elementAt(jcboColumna.getSelectedIndex());
        if(jtxtValor.isEnabled()){
            valor = jtxtValor.getText();
        }
        
        if(jcboComparador.getSelectedItem().toString().equals("Sea igual a..."))
            sql += " = ? ";
        else if(jcboComparador.getSelectedItem().toString().equals("Empiece con...")){
            sql += " like ? ";
            valor += "%";
        }else if(jcboComparador.getSelectedItem().toString().equals("Termine con...")){
            sql += " like ? ";
            valor = "%" + valor;
        }else if(jcboComparador.getSelectedItem().toString().equals("Contenga...")){
            sql += " like ? ";
            valor = "%" + valor + "%";
        }else if(jcboComparador.getSelectedItem().toString().equals("Sea diferente")){
            sql += " <> ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals("=")){
            sql += " = ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals("<>")){
            sql += " <> ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals(">")){
            sql += " > ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals("<")){
            sql += " < ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals(">=")){
            sql += " >= ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals("<=")){
            sql += " <= ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals("=")){
            sql += " = ? ";
        }else if(jcboComparador.getSelectedItem().toString().equals("true")){
            sql += " = true";
        }else if(jcboComparador.getSelectedItem().toString().equals("false")){
            sql += " = false";
        }
        
        
        sql += orderby;
        
        Object[][] args = {{tipo,valor}};
        frmPrincipal.desplegarResgistros(sql, args);
        dispose();
    }//GEN-LAST:event_jbtnAceptarActionPerformed

    private void jcboColumnaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcboColumnaItemStateChanged
        if(!inicializando){
            cargarComparadores(jcboColumna.getSelectedIndex());
        }
    }//GEN-LAST:event_jcboColumnaItemStateChanged

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FiltrarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FiltrarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FiltrarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FiltrarDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FiltrarDialog dialog = new FiltrarDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnAceptar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JComboBox<String> jcboColumna;
    private javax.swing.JComboBox<String> jcboComparador;
    private javax.swing.JTextField jtxtValor;
    // End of variables declaration//GEN-END:variables
}
