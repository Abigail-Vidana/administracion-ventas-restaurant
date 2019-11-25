
package mx.com.object;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mx.com.dao.VentaDetalleDAO;
import mx.com.dao.VentasDAO;
import mx.com.model.Venta;
import mx.com.model.VentaDetalle;
import mx.com.model.util.VentaTable;
import mx.com.model.util.MiCellEditor;

/**
 *
 * @author abigail
 */

 //Frame para la ventana de la tabla de todas las ventas
public class VentasFrame extends javax.swing.JFrame{
    //variables de la clase
    List<Venta> ventas = null;
    VentasDAO ventasDao = null;
    VentaDetalleDAO detalleDao = null;
    VentaTable modelo = null;
    
    public VentasFrame() {
        //inicializando variables
        ventasDao = new VentasDAO();
        detalleDao = new VentaDetalleDAO();
        ventas = ventasDao.traerTodasLasVentas();
        modelo = new mx.com.model.util.VentaTable(ventas);
        //dar caracteristicas a la ventana
        setTitle("Ventas");
        ImageIcon icon = new ImageIcon("src/main/resources/comida.jpg"); //icono de la ventana
        Image image = icon.getImage();
        setIconImage(image); 
        initComponents();
        edit();
        setLocationRelativeTo(null);
    }
    
    //columnas que se van a editar de la tabla
    private void edit(){
        tablaVentas.getColumnModel().getColumn(1).setCellEditor(new MiCellEditor());
        tablaVentas.getColumnModel().getColumn(2).setCellEditor(new MiCellEditor());
        tablaVentas.getColumnModel().getColumn(3).setCellEditor(new MiCellEditor());
        tablaVentas.getColumnModel().getColumn(4).setCellEditor(new MiCellEditor());
        tablaVentas.getColumnModel().getColumn(5).setCellEditor(new MiCellEditor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tablaVentas.setBackground(new java.awt.Color(204, 255, 255));
        tablaVentas.setModel(modelo);
        jScrollPane1.setViewportView(tablaVentas);

        titulo.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Todas las ventas");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarRegistros(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarRegistros(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar(evt);
            }
        });

        btnRegresar1.setText("Reporte");
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportePDF(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegresar1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //evento del boton regresar, regresa a la ventana del menu
    private void regresar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresar

    //evento del boton eliminar
    private void eliminarRegistros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarRegistros
        int fila = tablaVentas.getSelectedRow(); //se obtiene la fila seleccionada
        Venta venta = modelo.getVentaByRow(fila); //llama al metodo que creamos, para obtener la venta
        VentaDetalle detalle = modelo.getVentaDetalleByRow(fila); //llama al metodo que creamos, para obtener los detalles
        int filasBorradas =0; //contador de filas borradas
        int filasActualizadas =0; //contador de filas actualizadas
        if(venta.getDetalles().size() == 1){ //si existe un solo detalle de venta
            filasBorradas = ventasDao.eliminar(venta); //se elimina la fila
        }else{ //si no, existen mas de una
            filasBorradas = detalleDao.eliminar(detalle); //eliminamos solo la fila seleccionada
            if(filasBorradas > 0){ //verifica que se haya borrado al menos una fila
                //se remueve el detalle de la venta
                venta.getDetalles().remove(detalle);
                // se actualiza el total de la venta
                // para calcular nuevo valor sin la fila eliminada
                venta.actualizarTotal();
                filasActualizadas = ventasDao.actualizar(venta, false);
            }
        }
        //mensaje de eliminacion exitosa
        JOptionPane.showMessageDialog(null,
                "Se han eliminado: "+filasBorradas+" filas, Se han actualizado: "+filasActualizadas+" filas",
                "Informacion",
                javax.swing.JOptionPane.INFORMATION_MESSAGE); 
        if(filasBorradas > 0 ){ //se actualiza la tabla con los datos restantes
            ventas = ventasDao.traerTodasLasVentas();
            modelo = new mx.com.model.util.VentaTable(ventas);
            tablaVentas.setModel(modelo);
        }
    }//GEN-LAST:event_eliminarRegistros

    //evento para el boton modificar
    private void modificarRegistros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarRegistros
        List<Venta> ventas = modelo.getVentas(); //tenemos una lista con las ventas
        int filas = 0; //contador de filas
        for(Venta venta : ventas){ //recorre la lista
            if(venta.isSeActualizo()){ //si la venta se modifico
               filas += ventasDao.actualizar(venta, true); //actualiza
            }
        }
        //mensaje de modificacion exitosa, dice cuantas filas fueron modificadas
        JOptionPane.showMessageDialog(null,"Se modificaron: "+filas+" filas","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE); 
        if(filas > 0){ //actualiza la tabla
            ventas = ventasDao.traerTodasLasVentas();
            modelo = new mx.com.model.util.VentaTable(ventas);
            tablaVentas.setModel(modelo);
        }
    }//GEN-LAST:event_modificarRegistros

    private void reportePDF(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportePDF
        ReporteFrame reporte = new ReporteFrame();
        reporte.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reportePDF

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    
}
