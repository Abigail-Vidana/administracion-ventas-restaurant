
package mx.com.object;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import mx.com.dao.PersonalDAO;
import mx.com.dao.VentasDAO;
import mx.com.model.Personal;
import mx.com.model.Venta;
import mx.com.model.VentaDetalle;

/**
 *
 * @author abigail
 */
 //panel para las ventas
public class VentasPanel extends JPanel {

    //variables de la clase
    PersonalDAO personalDao = new PersonalDAO();
    List<Personal> listaPersonal = personalDao.traerTodosLosRegistros();   
    DefaultComboBoxModel model = new DefaultComboBoxModel(listaPersonal.toArray());
    Venta venta = new Venta();
    VentaDetalle venta_detalle = new VentaDetalle();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
    Date fechaHoy = new Date();
    VentasDAO ventasDao = new VentasDAO();
    List<VentaDetalle> detalleVenta = new ArrayList<>();
    
    public VentasPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        etNoTrabajador = new javax.swing.JLabel();
        etArticulo = new javax.swing.JLabel();
        articulo = new javax.swing.JTextField();
        etCantidad = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        etFecha = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        etTotal = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        etPrecio = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        elegirEmpleado = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 102, 102));
        setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        setName("Ventas"); // NOI18N
        setLayout(null);

        //tipo de letra, color y texto de la etiqueta 2
        etNoTrabajador.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etNoTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        etNoTrabajador.setText("No. de trabajador:");
        add(etNoTrabajador);
        etNoTrabajador.setBounds(40, 40, 119, 18);

        //tipo de letra, color y texto de la etiqueta 3
        etArticulo.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etArticulo.setForeground(new java.awt.Color(255, 255, 255));
        etArticulo.setText("Articulo:");
        add(etArticulo);
        etArticulo.setBounds(40, 100, 57, 18);

        //evento de la caja de texto 3
        add(articulo);
        articulo.setBounds(40, 120, 82, 20);

        //tipo de letra, color y texto de la etiqueta 4
        etCantidad.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etCantidad.setForeground(new java.awt.Color(255, 255, 255));
        etCantidad.setText("Cantidad:");
        add(etCantidad);
        etCantidad.setBounds(170, 100, 64, 18);

        //evento de la caja de texto 4
        add(cantidad);
        cantidad.setBounds(170, 120, 82, 20);

        //tipo de letra, color y texto de la etiqueta 5
        etFecha.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etFecha.setForeground(new java.awt.Color(255, 255, 255));
        etFecha.setText("Fecha:");
        add(etFecha);
        etFecha.setBounds(320, 10, 43, 18);

        //evento de la caja de texto 5
        add(precio);
        precio.setBounds(290, 120, 82, 20);

        //tipo de letra, color y texto de la etiqueta 6
        etTotal.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etTotal.setForeground(new java.awt.Color(255, 255, 255));
        etTotal.setText("Total:");
        add(etTotal);
        etTotal.setBounds(320, 280, 39, 18);

        //tipo de letra, color y texto de etiqueta 7
        total.setFont(new java.awt.Font("Calibri Light", 1, 13)); // NOI18N
        total.setForeground(new java.awt.Color(204, 204, 255));
        total.setText("calculo del total");
        add(total);
        total.setBounds(370, 280, 120, 20);

        //tipo de letra, color y texto de la etiqueta 8
        etPrecio.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etPrecio.setForeground(new java.awt.Color(255, 255, 255));
        etPrecio.setText("Precio:");
        add(etPrecio);
        etPrecio.setBounds(290, 100, 46, 18);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDatos(evt);
            }
        });
        add(btnGuardar);
        btnGuardar.setBounds(60, 310, 110, 23);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCampos(evt);
            }
        });
        add(btnLimpiar);
        btnLimpiar.setBounds(190, 310, 100, 23);

        btnVentas.setText("Ver ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verVentas(evt);
            }
        });
        add(btnVentas);
        btnVentas.setBounds(310, 310, 110, 23);

        fecha.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setText(sdf.format(fechaHoy));
        add(fecha);
        fecha.setBounds(370, 10, 120, 15);

        tablaDetalles.setBackground(new java.awt.Color(204, 255, 255));
        tablaDetalles.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        tablaDetalles.setModel(new mx.com.model.util.VentaDetalleTableModel(detalleVenta));
        jScrollPane2.setViewportView(tablaDetalles);

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 160, 470, 100);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarDetalles(evt);
            }
        });
        add(btnAgregar);
        btnAgregar.setBounds(393, 120, 100, 23);

        elegirEmpleado.setModel(model);
        add(elegirEmpleado);
        elegirEmpleado.setBounds(40, 60, 120, 22);
    }// </editor-fold>//GEN-END:initComponents

    
    //evento para el boton de guardar
    private void guardarDatos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDatos
        Personal seleccionado =  (Personal)elegirEmpleado.getSelectedItem();
        venta.setId_personal(seleccionado.getId());
        venta.setFecha(fechaHoy);
        venta.setTotal(Float.parseFloat(total.getText()));
        ventasDao.guardar(venta, detalleVenta);
        JOptionPane.showMessageDialog(null,"Se han guardado los datos","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE); //mensaje de guardado exitoso
        limpiar();
        
    }//GEN-LAST:event_guardarDatos

    //evento para el boton de agregar detalles de la venta
    private void agregarDetalles(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarDetalles
        venta_detalle = new VentaDetalle();
        venta_detalle.setArticulo(articulo.getText());
        venta_detalle.setCantidad(Integer.parseInt(cantidad.getText()));
        venta_detalle.setPrecio(Float.parseFloat(precio.getText()));
        detalleVenta.add(venta_detalle);
        tablaDetalles.setModel(new mx.com.model.util.VentaDetalleTableModel(detalleVenta));
        float total2 = (float)detalleVenta.stream().mapToDouble(detalle -> detalle.getCantidad()*detalle.getPrecio()).sum();
        total.setText(String.format("%.2f",total2));
        limpiarDetalle();
    }//GEN-LAST:event_agregarDetalles

    //evento para el boton de limpiar
    private void limpiarCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCampos
        limpiar();
    }//GEN-LAST:event_limpiarCampos

    //dividimos el metodo de limpiar, este en particular limpia toda la venta
    private void limpiar(){
        //elegirEmpleado.setText("");
        limpiarDetalle();
        detalleVenta = new ArrayList<>();
        total.setText("");
        tablaDetalles.setModel(new mx.com.model.util.VentaDetalleTableModel(detalleVenta));
    }

    //limpia solo los detalles de la venta
    private void limpiarDetalle(){
        articulo.setText("");
        cantidad.setText("");
        precio.setText("");
    }

    //evento para el boton de ver ventas, abre otra ventana nueva
    private void verVentas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verVentas
        VentasFrame todasLasVentas = new VentasFrame();
        todasLasVentas.setVisible(true);
        MenuPrincipal menu = (MenuPrincipal)SwingUtilities.getWindowAncestor(this);
        menu.dispose();
    }//GEN-LAST:event_verVentas

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField articulo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVentas;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox<String> elegirEmpleado;
    private javax.swing.JLabel etArticulo;
    private javax.swing.JLabel etCantidad;
    private javax.swing.JLabel etFecha;
    private javax.swing.JLabel etNoTrabajador;
    private javax.swing.JLabel etPrecio;
    private javax.swing.JLabel etTotal;
    private javax.swing.JLabel fecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField precio;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
