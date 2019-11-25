
package mx.com.object;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import mx.com.dao.InventarioDAO;
import mx.com.model.Inventario;

/**
 *
 * @author abigail
 */
 //panel para el inventario
public class InventarioPanel extends javax.swing.JPanel {
    //variables de la clase
    Inventario inventario;
    InventarioDAO inventarioDao = new InventarioDAO();
    
    public InventarioPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    //componentes
    private void initComponents() {

        titulo = new javax.swing.JLabel(); //etiqueta para el titulo
        etProducto = new javax.swing.JLabel(); //etiqueta para el producto
        producto = new javax.swing.JTextField(); //campo de texto para el producto
        etCantidad = new javax.swing.JLabel(); //etiqueta para la cantidad
        cantidad = new javax.swing.JTextField(); //campo de texto para la cantidad
        etPrecio = new javax.swing.JLabel(); //etiqueta para el precio
        precio = new javax.swing.JTextField(); //campo de texto para el precio
        btnLimpiar = new javax.swing.JButton(); //boton limpiar
        btnGuardar = new javax.swing.JButton(); //boton guardar
        btnVer = new javax.swing.JButton(); //boton ver

        setBackground(new java.awt.Color(0, 102, 102)); //color de fondo
        //caracteristicas para el titulo
        titulo.setFont(new java.awt.Font("Calibri Light", 1, 24)); //fuente
        titulo.setForeground(new java.awt.Color(255, 255, 255)); //color
        titulo.setText("Registro de productos");//texto
        //caracteristicas de la etiqueta de producto
        etProducto.setFont(new java.awt.Font("Calibri Light", 1, 14)); //fuente
        etProducto.setForeground(new java.awt.Color(255, 255, 255));//color
        etProducto.setText("Producto:"); //texto
        //caracteristicas para la etiqueta de cantidad
        etCantidad.setFont(new java.awt.Font("Calibri Light", 1, 14)); //fuente
        etCantidad.setForeground(new java.awt.Color(255, 255, 255));//color
        etCantidad.setText("Cantidad:"); //texto
        //caracteristicas para la etiqueta de precio
        etPrecio.setFont(new java.awt.Font("Calibri Light", 1, 14)); //fuente
        etPrecio.setForeground(new java.awt.Color(255, 255, 255)); //color
        etPrecio.setText("Precio:"); //texto

        btnLimpiar.setText("Limpiar");//texto del boton limpiar
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {//accion de escucha para el boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCampos(evt);
            }
        });

        btnGuardar.setText("Guardar"); //texto del boton guardar
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {//accion de escucha para el boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarRegistros(evt);
            }
        });

        btnVer.setText("Ver inventario"); //texto del boton ver
        btnVer.addActionListener(new java.awt.event.ActionListener() { //accion de escucha para el boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInventario(evt);
            }
        });

        //Diseño
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(etPrecio)
                                .addComponent(etProducto)
                                .addComponent(producto)
                                .addComponent(etCantidad)
                                .addComponent(cantidad)
                                .addComponent(precio, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(etProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(etCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(etPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnVer)
                    .addComponent(btnGuardar))
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //metodo para limpiar los campos de texto
    private void limpiar(){
        cantidad.setText("");
        producto.setText("");
        precio.setText("");
    }

    //evento para el boton limpiar
    private void limpiarCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCampos
        limpiar();
    }//GEN-LAST:event_limpiarCampos

    //evento para el boton ver
    private void verInventario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInventario
        InventarioFrame todoElInventario = new InventarioFrame();
        todoElInventario.setVisible(true);
        MenuPrincipal menu = (MenuPrincipal)SwingUtilities.getWindowAncestor(this);
        menu.dispose();
    }//GEN-LAST:event_verInventario
    
    //evento para el boton guardar
    private void guardarRegistros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarRegistros
        inventario = new Inventario();
        inventario.setCantidad(Integer.parseInt(cantidad.getText()));
        inventario.setPrecio(Float.parseFloat(precio.getText()));
        inventario.setArticulo(producto.getText());
        if(inventarioDao.guardar(inventario)){
            limpiar();
           JOptionPane.showMessageDialog(null,"Se han guardado los datos","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE); //mensaje de guardado exitoso       }
        }else{
           JOptionPane.showMessageDialog(null,"Hubo un error al guardar los datos","Alerta",javax.swing.JOptionPane.WARNING_MESSAGE); //mensaje de guardado exitoso
        }
    }//GEN-LAST:event_guardarRegistros


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVer;
    private javax.swing.JTextField cantidad;
    private javax.swing.JLabel etCantidad;
    private javax.swing.JLabel etPrecio;
    private javax.swing.JLabel etProducto;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField producto;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
