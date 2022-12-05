
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo1;
import modelo.Modelo2;
import modelo.Modelo3;
import modelo.Modelo4;
import modelo.Modelo5;
import mx.edu.itl.jdbc.ConexionDBFrame;

public class FramePrincipal extends javax.swing.JFrame {

    public static final String Tit_Modulo1 = "Productos";
    public static final String Tit_Modulo2 = "Distribuidores";
    public static final String Tit_Modulo3 = "Ordenes";
    public static final String Tit_Modulo4 = "Clientes";
    public static final String Tit_Modulo5 = "Empleados";
    
    public static final String NUEVO = "Nuevo";
    public static final String EDITAR = "Editar";
    
    public static final String productos_todos_nombre = "productos_todos_nombre";
    public static final String distribuidores_todos_por_nombre = "distribuidores_todos_por_nombre";
    public static final String ordenes_todas_por_fecha = "ordenes_todas_por_fecha";
    public static final String clientes_todos_por_nombre = "clientes_todos_por_nombre";
    public static final String empleados_todos_por_nombre = "empleados_todos_por_nombre";
    
    public static final String productos_todos_sin_orden = "productos_todos_sin_orden";
    public static final String distribuidores_todos_sin_orden = "distribuidores_todos_sin_orden";
    public static final String ordenes_todas_sin_orden = "ordenes_todas_sin_orden";
    public static final String clientes_todos_sin_orden = "clientes_todos_sin_orden";
    public static final String empleados_todos_sin_orden = "empleados_todos_sin_orden";
    
    public static final String productos_eliminar_x_proid = "productos_eliminar_x_proid";
    public static final String distribuidores_eliminar_x_disid = "distribuidores_eliminar_x_disid";
    public static final String ordenes_eliminar_x_ordid = "ordenes_eliminar_x_ordid";
    public static final String clientes_eliminar_x_cliid = "clientes_eliminar_x_cliid";
    public static final String empleados_eliminar_x_empid = "empleados_eliminar_x_empid";
    
    public static final String productos_actualiza_datos = "productos_actualiza_datos";
    public static final String productos_inserta_nuevo = "productos_inserta_nuevo";
    public static final String productos_obt_max_id = "productos_obt_max_id";
    public static final String distribuidores_actualiza_datos = "distribuidores_actualiza_datos";
    public static final String distribuidores_inserta_nuevo = "distribuidores_inserta_nuevo";
    public static final String ordenes_actualiza_datos = "ordenes_actualiza_datos";
    public static final String ordenes_inserta_nuevo = "ordenes_inserta_nuevo";
    public static final String clientes_actualiza_datos = "clientes_actualiza_datos";
    public static final String clientes_inserta_nuevo = "clientes_inserta_nuevo";
    public static final String empleados_actualiza_datos = "empleados_actualiza_datos";
    public static final String empleados_inserta_nuevo = "empleados_inserta_nuevo";
    
    private String moduloActual;
    private DefaultTableModel modelo;
    private Vector <String> vecNombresColumnas;
    private Vector<String> vecNombresColumnasBD;
    private Vector<String> vecTiposColumnas;
    private Properties propConsultasSQL;
    
    public FramePrincipal() {
        initComponents();
        
        jTBAcciones.setVisible(false);
        jLblTitulo2.setVisible(false);
        jPnlTabla.setVisible(false);
        fondo.setVisible(true);
        
        prepararSentenciasSQL();
        
        new ConexionDBFrame(this).setVisible(true);
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
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
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
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
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(ordenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(distribuidores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(empleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        String sql = propConsultasSQL.getProperty(productos_todos_nombre);
        desplegarResgistros(sql, null);
    }//GEN-LAST:event_productosMousePressed

    private void distribuidoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_distribuidoresMousePressed
        resetColor(productos);
        setColor(distribuidores);
        resetColor(clientes);
        resetColor(ordenes);
        resetColor(empleados);
        
        prepararVistaModulo(Tit_Modulo2);
        String sql = propConsultasSQL.getProperty(distribuidores_todos_por_nombre);
        desplegarResgistros(sql, null);
    }//GEN-LAST:event_distribuidoresMousePressed

    private void ordenesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordenesMousePressed
        resetColor(productos);
        resetColor(distribuidores);
        resetColor(clientes);
        setColor(ordenes);
        resetColor(empleados);
        
        prepararVistaModulo(Tit_Modulo3);
        String sql = propConsultasSQL.getProperty(ordenes_todas_por_fecha);
        desplegarResgistros(sql, null);
    }//GEN-LAST:event_ordenesMousePressed

    private void clientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesMousePressed
        resetColor(productos);
        resetColor(distribuidores);
        setColor(clientes);
        resetColor(ordenes);
        resetColor(empleados);
        
        prepararVistaModulo(Tit_Modulo4);
        String sql = propConsultasSQL.getProperty(clientes_todos_por_nombre);
        desplegarResgistros(sql, null);
    }//GEN-LAST:event_clientesMousePressed

    private void empleadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleadosMousePressed
        resetColor(productos);
        resetColor(distribuidores);
        resetColor(clientes);
        resetColor(ordenes);
        setColor(empleados);
        
        prepararVistaModulo(Tit_Modulo5);
        String sql = propConsultasSQL.getProperty(empleados_todos_por_nombre);
        desplegarResgistros(sql, null);
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
        int pos = jTable.getSelectedRow();
        if(pos == -1){
            JOptionPane.showMessageDialog(this, "No hay registro seleccionado","Editar",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(moduloActual.equals(Tit_Modulo1)){
            int pro_id = Integer.parseInt(jTable.getValueAt(pos, 0).toString());
            int pro_codigo = Integer.parseInt(jTable.getValueAt(pos, 1).toString());
            String pro_nombre = jTable.getValueAt(pos, 2).toString();
            String pro_tipo = jTable.getValueAt(pos, 3).toString();
            int pro_cantidad = Integer.parseInt(jTable.getValueAt(pos, 4).toString());
            int pro_precio = Integer.parseInt(jTable.getValueAt(pos, 5).toString());
            
            Modelo1 modelo1 = new Modelo1(pro_id, pro_codigo, pro_nombre, pro_tipo, pro_cantidad, pro_precio);
            
            ProductosDialog dialogpro = new ProductosDialog(this,modelo1);
            dialogpro.setVisible(true);
        }else if(moduloActual.equals(Tit_Modulo2)){
            int dis_id = Integer.parseInt(jTable.getValueAt(pos, 0).toString());
            String dis_direccion = jTable.getValueAt(pos, 1).toString();
            String dis_nombre = jTable.getValueAt(pos, 2).toString();
            
            Modelo2 modelo2 = new Modelo2(dis_id, dis_direccion, dis_nombre);
            
            DistribuidoresDialog dialog = new DistribuidoresDialog(this,modelo2);
            dialog.setVisible(true);
        }else if(moduloActual.equals(Tit_Modulo3)){
            int ord_id = Integer.parseInt(jTable.getValueAt(pos, 0).toString());
            int pro_id = Integer.parseInt(jTable.getValueAt(pos, 1).toString());
            int cli_id = Integer.parseInt(jTable.getValueAt(pos, 2).toString());
            String ord_forden = jTable.getValueAt(pos, 3).toString();
            int total = Integer.parseInt(jTable.getValueAt(pos, 4).toString());
            
            Modelo3 modelo3 = new Modelo3(ord_id, pro_id, cli_id, ord_forden, total);
            
            OrdenesDialog dialog = new OrdenesDialog(this,modelo3);
            dialog.setVisible(true);
        }else if(moduloActual.equals(Tit_Modulo4)){
            int cli_id = Integer.parseInt(jTable.getValueAt(pos, 0).toString());
            String cli_nombre = jTable.getValueAt(pos, 1).toString();
            String cli_direccion = jTable.getValueAt(pos, 2).toString();
            int ven_id = Integer.parseInt(jTable.getValueAt(pos, 3).toString());
            
            Modelo4 modelo4 = new Modelo4(cli_id, cli_nombre, cli_direccion, ven_id);
            
            ClientesDialog dialog = new ClientesDialog(this,modelo4);
            dialog.setVisible(true);
        } else if(moduloActual.equals(Tit_Modulo5)){
            int ven_id = Integer.parseInt(jTable.getValueAt(pos, 0).toString());
            String ven_nombre = jTable.getValueAt(pos, 1).toString();
            String ven_direccion = jTable.getValueAt(pos, 2).toString();
            String ven_rfc = jTable.getValueAt(pos, 3).toString();
            String ven_curp = jTable.getValueAt(pos, 4).toString();
            int ven_ncontrol = Integer.parseInt(jTable.getValueAt(pos, 5).toString());
            int ven_supervisor = Integer.parseInt(jTable.getValueAt(pos, 6).toString());
            
            Modelo5 modelo5 = new Modelo5(ven_id, ven_direccion, ven_nombre, ven_rfc, ven_curp, ven_ncontrol, ven_supervisor);
            
            EmpleadosDialog dialog = new EmpleadosDialog(this,modelo5);
            dialog.setVisible(true);
        }
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

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        int pos = jTable.getSelectedRow();
        if(pos == -1){
            JOptionPane.showMessageDialog(this, "No hay registro seleccionado","Eliminar",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirma = JOptionPane.showConfirmDialog(this, "Eliminar el registro seleccionado?", "ELiminar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirma == JOptionPane.NO_OPTION){
            return;
        }
        
        String valorLlavePrim = jTable.getValueAt(pos, 0).toString();
        String tipoLlavePrim = vecTiposColumnas.elementAt(0);
        String sql = "";
        JLabel jlblModulo =  null;
        
        if(moduloActual == Tit_Modulo1){
            sql = propConsultasSQL.getProperty(productos_eliminar_x_proid);
            jlblModulo = productos;
        }else if(moduloActual == Tit_Modulo2){
            sql = propConsultasSQL.getProperty(distribuidores_eliminar_x_disid);
            jlblModulo = distribuidores;
        }else if(moduloActual == Tit_Modulo3){
            sql = propConsultasSQL.getProperty(ordenes_eliminar_x_ordid);
            jlblModulo = ordenes;
        }else if(moduloActual == Tit_Modulo4){
            sql = propConsultasSQL.getProperty(clientes_eliminar_x_cliid);
            jlblModulo = clientes;
        }else if(moduloActual == Tit_Modulo5){
            sql = propConsultasSQL.getProperty(empleados_eliminar_x_empid);
            jlblModulo = empleados;
        }
        
        Object[][] args = {{tipoLlavePrim, valorLlavePrim}};
        try {
            int regs = EjecutorSQL.sqlEjecutar(sql, args);
            if(regs == 1){
                JOptionPane.showMessageDialog(this, "El registro ha sido eliminado", "ELiminar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        FiltrarDialog filtrarDialog = new FiltrarDialog(this,true);
        filtrarDialog.setVisible(true);
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated
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
        determinarNombreColumnas(modulo);
        
        modelo = new DefaultTableModel(vecNombresColumnas,0);
        jTable.setModel(modelo);
    }
    
    private void determinarNombreColumnas(String modulo){
        vecNombresColumnas = new Vector<String>();
        vecNombresColumnasBD = new Vector<String>();
        vecTiposColumnas = new Vector<String>();
        if(modulo.equals(Tit_Modulo1)){
            vecNombresColumnas.add("Producto ID");
            vecNombresColumnas.add("Codigo");
            vecNombresColumnas.add("Nombre");
            vecNombresColumnas.add("Tipo");
            vecNombresColumnas.add("Cantidad");
            vecNombresColumnas.add("Precio");
            
            vecNombresColumnasBD.add("pro_id");
            vecNombresColumnasBD.add("pro_codigo");
            vecNombresColumnasBD.add("pro_nombre");
            vecNombresColumnasBD.add("pro_tipo");
            vecNombresColumnasBD.add("pro_cantidad");
            vecNombresColumnasBD.add("pro_precio");
            
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.INT);
        }else if(modulo.equals(Tit_Modulo2)){
            vecNombresColumnas.add("Distribuidor ID");
            vecNombresColumnas.add("Direccion");
            vecNombresColumnas.add("Nombre");
            
            vecNombresColumnasBD.add("dis_id");
            vecNombresColumnasBD.add("dis_direccion");
            vecNombresColumnasBD.add("dis_nombre");
            
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.STRING);
        }else if(modulo.equals(Tit_Modulo3)){
            vecNombresColumnas.add("Orden ID");
            vecNombresColumnas.add("Producto ID");
            vecNombresColumnas.add("Cliente ID");
            vecNombresColumnas.add("Fecha de Orden");
            vecNombresColumnas.add("Total");
            
            vecNombresColumnasBD.add("ord_id");
            vecNombresColumnasBD.add("pro_id");
            vecNombresColumnasBD.add("cli_id");
            vecNombresColumnasBD.add("ord_pro_forden");
            vecNombresColumnasBD.add("ord_pro_precio_total");
            
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.INT);
        } else if(modulo.equals(Tit_Modulo4)){
            vecNombresColumnas.add("Cliente ID");
            vecNombresColumnas.add("Nombre");
            vecNombresColumnas.add("Direccion");
            vecNombresColumnas.add("Vendedor");
            
            vecNombresColumnasBD.add("cli_id");
            vecNombresColumnasBD.add("cli_nombre");
            vecNombresColumnasBD.add("cli_direccion");
            vecNombresColumnasBD.add("ven_id");
            
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.INT);
        } else if(modulo.equals(Tit_Modulo5)){
            vecNombresColumnas.add("Empleado ID");
            vecNombresColumnas.add("Direccion");
            vecNombresColumnas.add("Nombre");
            vecNombresColumnas.add("RFC");
            vecNombresColumnas.add("CURP");
            vecNombresColumnas.add("N° Control");
            vecNombresColumnas.add("Supervisor");
            
            vecNombresColumnasBD.add("ven_id");
            vecNombresColumnasBD.add("ven_direccion");
            vecNombresColumnasBD.add("ven_nombre");
            vecNombresColumnasBD.add("ven_rfc");
            vecNombresColumnasBD.add("ven_curp");
            vecNombresColumnasBD.add("ven_ncontrol");
            vecNombresColumnasBD.add("ven_supervisor");
            
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.STRING);
            vecTiposColumnas.add(EjecutorSQL.INT);
            vecTiposColumnas.add(EjecutorSQL.INT);
        }
    }
    
    private void prepararSentenciasSQL(){
        propConsultasSQL = new Properties();
        propConsultasSQL.put(productos_todos_nombre,"select * from productos order by pro_nombre");
        propConsultasSQL.put(distribuidores_todos_por_nombre, "select dis_id, dis_direccion, dis_nombre from distribuidores order by dis_nombre");
        propConsultasSQL.put(ordenes_todas_por_fecha,"select ord.ord_id, ordpro.pro_id, ord.cli_id, ordpro.ord_pro_forden from ordenes AS ord INNER JOIN ordenes_productos AS ordpro ON (ord.ord_id = ordpro.ord_id) WHERE (ord.ord_id = ordpro.ord_id) order by ord_id");           
        propConsultasSQL.put(clientes_todos_por_nombre,"select * from clientes order by cli_nombre");
        propConsultasSQL.put(empleados_todos_por_nombre,"select * from vendedores order by ven_nombre");
        
        propConsultasSQL.put(productos_todos_sin_orden, "select * from productos");
        propConsultasSQL.put(distribuidores_todos_sin_orden,"select * from distribuidores");
        propConsultasSQL.put(ordenes_todas_sin_orden, "select ord.ord_id, ordpro.pro_id, ord.cli_id, ordpro.ord_pro_forden from ordenes AS ord INNER JOIN ordenes_productos AS ordpro ON (ord.ord_id = ordpro.ord_id) ");
        propConsultasSQL.put(clientes_todos_sin_orden,"select * from clientes");
        propConsultasSQL.put(empleados_todos_sin_orden, "select * from vendedores");
        
        propConsultasSQL.put(productos_eliminar_x_proid, "delete from productos where pro_id = ?");
        propConsultasSQL.put(distribuidores_eliminar_x_disid, "delete from distribuidores where dis_id = ?");
        propConsultasSQL.put(ordenes_eliminar_x_ordid, "delete from ordenes where ord_id = ?");
        propConsultasSQL.put(clientes_eliminar_x_cliid, "delete from clientes where cli_id = ?");
        propConsultasSQL.put(empleados_eliminar_x_empid, "delete from vendedores where ven_id = ?");
        
        propConsultasSQL.put(productos_actualiza_datos, "update productos set pro_codigo = ?, pro_nombre = ?, pro_tipo = ?, pro_cantidad = ?, pro_precio = ? where pro_id = ?");
        propConsultasSQL.put(distribuidores_actualiza_datos, "update distribuidores set dis_direccion = ?, dis_nombre = ? where dis_id = ?");
        propConsultasSQL.put(ordenes_actualiza_datos, "update ordenes set cli_id = ? where ord_id = ?");
                                                    //+ "update ordenes_productos set pro_id = ?, ord_pro_forden = ? where ord_id = ?");
        propConsultasSQL.put(clientes_actualiza_datos, "update clientes set cli_direccion = ?, cli_nombre = ?, ven_id = ? where cli_id = ?");
        propConsultasSQL.put(empleados_actualiza_datos, "update vendedores set ven_direccion = ?, ven_nombre = ?, ven_rfc = ?, ven_curp = ?, ven_ncontrol = ?, ven_supervisor = ? where ven_id = ?");
        
        propConsultasSQL.put(productos_inserta_nuevo, "insert into productos (pro_id, pro_codigo, pro_nombre, pro_tipo, pro_cantidad, pro_precio) values (?, ? , ? , ? , ?, ? )");
        propConsultasSQL.put(distribuidores_inserta_nuevo, "insert into distribuidores (dis_id, dis_direccion, dis_nombre) values (?, ? , ? )");
        propConsultasSQL.put(ordenes_inserta_nuevo, "insert into ordenes (ord_id, cli_id) VALUES ( ?, ? )");
                                                  //+ "insert into ordenes_productos (ord_id, pro_id, ord_pro_forden) VALUES (?, ?, ?");
        propConsultasSQL.put(clientes_inserta_nuevo, "insert into clientes (cli_id, cli_direccion, cli_nombre, ven_id) values (?, ? , ?, ?)");
        propConsultasSQL.put(empleados_inserta_nuevo, "insert into vendedores (ven_id, ven_direccion, ven_nombre, ven_rfc, ven_curp, ven_ncontrol, ven_supervisor) values (?, ? , ?, ?, ?, ? , ?)");
    }
    
    private Object[] crearFila(ResultSet rs) throws SQLException{
        if(moduloActual.equals(Tit_Modulo1)){
            int id = rs.getInt("pro_id");
            int codigo = rs.getInt("pro_codigo");
            String nombre = rs.getString("pro_nombre");
            String tipo = rs.getString("pro_tipo");
            int cantidad = rs.getInt("pro_cantidad");
            int precio  = rs.getInt("pro_precio");
            
            //Agregar la fila a la tabla
            Object []fila = {id, codigo, nombre, tipo, cantidad, precio};
            return fila;
        }else if(moduloActual.equals(Tit_Modulo2)){
            int id = rs.getInt("dis_id");
            String nombre = rs.getString("dis_direccion");
            String direccion = rs.getString("dis_nombre");
            //Agregar la fila a la tabla
            Object []fila = {id, direccion, nombre};
            return fila;
        }else if(moduloActual.equals(Tit_Modulo3)){
            int id = rs.getInt("ord_id");
            int proid = rs.getInt("pro_id");
            int cli_id = rs.getInt("cli_id");
            String fecha = rs.getString("ord_pro_forden");
            int total = rs.getInt("ord_pro_precio_total");
            //Agregar la fila a la tabla
            Object []fila = {id, proid, cli_id, fecha, total};
            return fila;
        }else if(moduloActual.equals(Tit_Modulo4)){
            int id = rs.getInt("cli_id");
            String nombre = rs.getString("cli_nombre");
            String direccion = rs.getString("cli_direccion");
            int ven = rs.getInt("ven_id");
            //Agregar la fila a la tabla
            Object []fila = {id, nombre, direccion, ven};
            return fila;
        }else if(moduloActual.equals(Tit_Modulo5)){
            int id = rs.getInt("ven_id");
            String nombre = rs.getString("ven_direccion");
            String direccion = rs.getString("ven_nombre");
            String rfc = rs.getString("ven_rfc");
            String curp = rs.getString("ven_curp");
            int ncontrol = rs.getInt("ven_ncontrol");
            int sup = rs.getInt("ven_supervisor");
            //Agregar la fila a la tabla
            Object []fila = {id, direccion, nombre, rfc, curp, ncontrol, sup};
            return fila;
        }
        return null;
    }
    public void desplegarResgistros(String sql, Object[][] args){
        ResultSet rs;
        try{
            rs = EjecutorSQL.sqlQuery(sql,args);
            
            modelo = new DefaultTableModel(vecNombresColumnas,0);
            while(rs.next()){
                Object []fila = crearFila(rs);
                modelo.addRow(fila);
            }
            rs.close();
            jTable.setModel(modelo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
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

    public Vector<String> getVecNombresColumnas() {
        return vecNombresColumnas;
    }

    public void setVecNombresColumnas(Vector<String> vecNombresColumnas) {
        this.vecNombresColumnas = vecNombresColumnas;
    }

    public Vector<String> getVecNombresColumnasBD() {
        return vecNombresColumnasBD;
    }

    public void setVecNombresColumnasBD(Vector<String> vecNombresColumnasBD) {
        this.vecNombresColumnasBD = vecNombresColumnasBD;
    }

    public Vector<String> getVecTiposColumnas() {
        return vecTiposColumnas;
    }

    public void setVecTiposColumnas(Vector<String> vecTiposColumnas) {
        this.vecTiposColumnas = vecTiposColumnas;
    }

    public Properties getPropConsultasSQL() {
        return propConsultasSQL;
    }

    public void setPropConsultasSQL(Properties propConsultasSQL) {
        this.propConsultasSQL = propConsultasSQL;
    }

    public String getModuloActual() {
        return moduloActual;
    }

    public void setModuloActual(String moduloActual) {
        this.moduloActual = moduloActual;
    }
    
    
}
