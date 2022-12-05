
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal extends javax.swing.JFrame {

    public static final String Tit_Modulo1 = "Productos";
    public static final String Tit_Modulo2 = "Distribuidores";
    public static final String Tit_Modulo3 = "Ordenes";
    public static final String Tit_Modulo4 = "Clientes";
    public static final String Tit_Modulo5 = "Empleados";
    
    public static final String NUEVO = "Nuevo";
    public static final String EDITAR = "Editar";
    
    private String moduloActual;
    private DefaultTableModel modelo;
    
    public FramePrincipal() {
        initComponents();
        
        jTBAcciones.setVisible(false);
        jLblTitulo2.setVisible(false);
        jPnlTabla.setVisible(false);
        fondo.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTBAcciones = new javax.swing.JToolBar();
        jBtnNuevo = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnHome = new javax.swing.JButton();
        jBtnBuscar = new javax.swing.JButton();
        jPnlTitulo = new javax.swing.JPanel();
        jLlblHome = new javax.swing.JLabel();
        jLblTitulo2 = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        productos = new javax.swing.JLabel();
        distribuidores = new javax.swing.JLabel();
        ordenes = new javax.swing.JLabel();
        clientes = new javax.swing.JLabel();
        empleados = new javax.swing.JLabel();
        jPnlTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTBAcciones.setBackground(new java.awt.Color(255, 255, 255));
        jTBAcciones.setFloatable(false);
        jTBAcciones.setRollover(true);
        jTBAcciones.setAlignmentX(2.0F);

        jBtnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        jBtnNuevo.setToolTipText("Añadir");
        jBtnNuevo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnNuevo.setFocusable(false);
        jBtnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });
        jTBAcciones.add(jBtnNuevo);

        jBtnEditar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jBtnEditar.setToolTipText("Editar");
        jBtnEditar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnEditar.setFocusable(false);
        jBtnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });
        jTBAcciones.add(jBtnEditar);

        jBtnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jBtnEliminar.setToolTipText("Eiminar");
        jBtnEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnEliminar.setFocusable(false);
        jBtnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jTBAcciones.add(jBtnEliminar);

        jBtnHome.setBackground(new java.awt.Color(255, 255, 255));
        jBtnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home.png"))); // NOI18N
        jBtnHome.setToolTipText("Home");
        jBtnHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnHome.setFocusable(false);
        jBtnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHomeActionPerformed(evt);
            }
        });
        jTBAcciones.add(jBtnHome);

        jBtnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jBtnBuscar.setToolTipText("Buscar");
        jBtnBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jBtnBuscar.setFocusable(false);
        jBtnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jTBAcciones.add(jBtnBuscar);

        getContentPane().add(jTBAcciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, 50));

        jPnlTitulo.setBackground(new java.awt.Color(255, 255, 255));

        jLlblHome.setFont(new java.awt.Font("Lucida Grande", 0, 30)); // NOI18N
        jLlblHome.setForeground(new java.awt.Color(56, 79, 107));
        jLlblHome.setText("Home");

        jLblTitulo2.setFont(new java.awt.Font("Lucida Grande", 0, 30)); // NOI18N
        jLblTitulo2.setForeground(new java.awt.Color(56, 79, 107));
        jLblTitulo2.setText("Home");

        javax.swing.GroupLayout jPnlTituloLayout = new javax.swing.GroupLayout(jPnlTitulo);
        jPnlTitulo.setLayout(jPnlTituloLayout);
        jPnlTituloLayout.setHorizontalGroup(
            jPnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLlblHome)
                .addGap(172, 172, 172)
                .addComponent(jLblTitulo2)
                .addContainerGap(692, Short.MAX_VALUE))
        );
        jPnlTituloLayout.setVerticalGroup(
            jPnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLlblHome)
                    .addComponent(jLblTitulo2))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(jPnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1040, 50));

        menu.setBackground(new java.awt.Color(0, 134, 132));

        productos.setBackground(new java.awt.Color(0, 134, 132));
        productos.setForeground(new java.awt.Color(255, 255, 255));
        productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/producto.png"))); // NOI18N
        productos.setText("    Productos");
        productos.setToolTipText("");
        productos.setOpaque(true);
        productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productosMousePressed(evt);
            }
        });

        distribuidores.setBackground(new java.awt.Color(0, 134, 132));
        distribuidores.setForeground(new java.awt.Color(255, 255, 255));
        distribuidores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/distribuidor.png"))); // NOI18N
        distribuidores.setText("Distribuidores");
        distribuidores.setToolTipText("");
        distribuidores.setOpaque(true);
        distribuidores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                distribuidoresMousePressed(evt);
            }
        });

        ordenes.setBackground(new java.awt.Color(0, 134, 132));
        ordenes.setForeground(new java.awt.Color(255, 255, 255));
        ordenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Orden.png"))); // NOI18N
        ordenes.setText("     Ordenes");
        ordenes.setToolTipText("");
        ordenes.setOpaque(true);
        ordenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ordenesMousePressed(evt);
            }
        });

        clientes.setBackground(new java.awt.Color(0, 134, 132));
        clientes.setForeground(new java.awt.Color(255, 255, 255));
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cliente.png"))); // NOI18N
        clientes.setText("    Clientes");
        clientes.setToolTipText("");
        clientes.setOpaque(true);
        clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clientesMousePressed(evt);
            }
        });

        empleados.setBackground(new java.awt.Color(0, 134, 132));
        empleados.setForeground(new java.awt.Color(255, 255, 255));
        empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Empleado.png"))); // NOI18N
        empleados.setText("    Empleados");
        empleados.setToolTipText("");
        empleados.setOpaque(true);
        empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                empleadosMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ordenes, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(distribuidores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clientes, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(empleados, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(distribuidores, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ordenes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 610));

        jPnlTabla.setBackground(new java.awt.Color(255, 255, 255));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPnlTablaLayout = new javax.swing.GroupLayout(jPnlTabla);
        jPnlTabla.setLayout(jPnlTablaLayout);
        jPnlTablaLayout.setHorizontalGroup(
            jPnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPnlTablaLayout.setVerticalGroup(
            jPnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlTablaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPnlTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1040, 610));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Background.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosMousePressed
        setColor(productos);
        resetColor(distribuidores);
        resetColor(clientes);
        resetColor(ordenes);
        resetColor(empleados);
        
        prepararVistaModulo(Tit_Modulo1);
    }//GEN-LAST:event_productosMousePressed

    private void distribuidoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_distribuidoresMousePressed
        resetColor(productos);
        setColor(distribuidores);
        resetColor(clientes);
        resetColor(ordenes);
        resetColor(empleados);
        
        prepararVistaModulo(Tit_Modulo2);
    }//GEN-LAST:event_distribuidoresMousePressed

    private void ordenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordenesMousePressed
        resetColor(productos);
        resetColor(distribuidores);
        resetColor(clientes);
        setColor(ordenes);
        resetColor(empleados);
        
        prepararVistaModulo(Tit_Modulo3);
    }//GEN-LAST:event_ordenesMousePressed

    private void clientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesMousePressed
        resetColor(productos);
        resetColor(distribuidores);
        setColor(clientes);
        resetColor(ordenes);
        resetColor(empleados);
        
        prepararVistaModulo(Tit_Modulo4);
    }//GEN-LAST:event_clientesMousePressed

    private void empleadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleadosMousePressed
        resetColor(productos);
        resetColor(distribuidores);
        resetColor(clientes);
        resetColor(ordenes);
        setColor(empleados);
        
        prepararVistaModulo(Tit_Modulo5);
    }//GEN-LAST:event_empleadosMousePressed

    private void jBtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHomeActionPerformed
        jTBAcciones.setVisible(false);
        jLblTitulo2.setVisible(false);
        jPnlTabla.setVisible(false);
        fondo.setVisible(true);
        
        resetColor(productos);
        resetColor(distribuidores);
        resetColor(clientes);
        resetColor(ordenes);
        resetColor(empleados);
    }//GEN-LAST:event_jBtnHomeActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        if(moduloActual.equals(Tit_Modulo1)){
            ProductosDialog dialog = new ProductosDialog(this,null);
            dialog.setVisible(true);
        } else if(moduloActual.equals(Tit_Modulo2)){
            DistribuidoresDialog dialog2 = new DistribuidoresDialog(this,null);
            dialog2.setVisible(true);
        } else if(moduloActual.equals(Tit_Modulo3)){
            OrdenesDialog dialog3 = new OrdenesDialog(this,null);
            dialog3.setVisible(true);
        } else if(moduloActual.equals(Tit_Modulo4)){
            ClientesDialog dialog4 = new ClientesDialog(this,null);
            dialog4.setVisible(true);
        } else if(moduloActual.equals(Tit_Modulo5)){
            EmpleadosDialog dialog5 = new EmpleadosDialog(this,null);
            dialog5.setVisible(true);
        }
    }//GEN-LAST:event_jBtnNuevoActionPerformed
    public void setColor(JLabel label){
        label.setBackground(new Color (119,173,170));
    }
    
    public void resetColor(JLabel label){
        label.setBackground(new Color (0,134,132));
    }
    
    private void prepararVistaModulo(String modulo){
        moduloActual = modulo;
        jTBAcciones.setVisible(true);
        fondo.setVisible(false);
        jPnlTabla.setVisible(true);
        
        jLblTitulo2.setVisible(true);
        jLblTitulo2.setText(modulo);
        //determinarNombreColumnas(modulo);
        
        //modelo = new DefaultTableModel(vecNombresColumnas,0);
        //jTable.setModel(modelo);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("MacOS".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clientes;
    private javax.swing.JLabel distribuidores;
    private javax.swing.JLabel empleados;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnHome;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JLabel jLblTitulo2;
    private javax.swing.JLabel jLlblHome;
    private javax.swing.JPanel jPnlTabla;
    private javax.swing.JPanel jPnlTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jTBAcciones;
    private javax.swing.JTable jTable;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel ordenes;
    private javax.swing.JLabel productos;
    // End of variables declaration//GEN-END:variables
}
