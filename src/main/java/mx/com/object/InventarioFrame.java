
package mx.com.object;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mx.com.dao.InventarioDAO;
import mx.com.model.Inventario;
import mx.com.model.util.InventarioTable;
import mx.com.model.util.MiCellEditor;

/**
 *
 * @author abigail
 */
 //Frame para la ventana de la tabla de todo el inventario 
public class InventarioFrame extends javax.swing.JFrame {
    //variables de la clase
    List<Inventario> inventario = null;
    InventarioTable modelo = null;
    InventarioDAO inventarioDao = null;
    
    public InventarioFrame() {    
        inventarioDao = new InventarioDAO();
        inventario = inventarioDao.traerTodosLosRegistros();
        modelo = new mx.com.model.util.InventarioTable(inventario);   
        setTitle("Invenatario");
        ImageIcon icon = new ImageIcon("src/main/resources/comida.jpg"); //icono de la ventana
        Image image = icon.getImage();
        setIconImage(image);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //columnas que se van a editar de la tabla
    private void edit(){
        tablaInventario.getColumnModel().getColumn(1).setCellEditor(new MiCellEditor());
        tablaInventario.getColumnModel().getColumn(2).setCellEditor(new MiCellEditor());
        tablaInventario.getColumnModel().getColumn(3).setCellEditor(new MiCellEditor());
        tablaInventario.getColumnModel().getColumn(4).setCellEditor(new MiCellEditor());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInventario = new javax.swing.JPanel(); //panel
        titulo = new javax.swing.JLabel(); //etiqueta de titulo
        jScrollPane1 = new javax.swing.JScrollPane(); 
        tablaInventario = new javax.swing.JTable(); //tabla
        btnModificar = new javax.swing.JButton(); //boton modificar
        javax.swing.JButton btnEliminar = new javax.swing.JButton(); //boton eliminar
        javax.swing.JButton btnRegresar = new javax.swing.JButton(); //boton regresar

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelInventario.setBackground(new java.awt.Color(0, 102, 102)); //color de fondo del panel
        //fuente, color y texto de la etiqueta de titulo
        titulo.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Todo el inventario");

        tablaInventario.setModel(modelo);
        jScrollPane1.setViewportView(tablaInventario);

        btnModificar.setText("Modificar"); //boton modificar
        btnModificar.addActionListener(new java.awt.event.ActionListener() { //oyente de accion del boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarRegistros(evt);
            }
        });

        btnEliminar.setText("Eliminar"); //boton eliminar
        btnEliminar.addActionListener(new java.awt.event.ActionListener() { //oyente de accion del boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarRegistros(evt);
            }
        });

        btnRegresar.setText("Regresar"); //boton regresar
        btnRegresar.addActionListener(new java.awt.event.ActionListener() { //oyente de accion del boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar(evt);
            }
        });
        //Diseño
        javax.swing.GroupLayout panelInventarioLayout = new javax.swing.GroupLayout(panelInventario);
        panelInventario.setLayout(panelInventarioLayout);
        panelInventarioLayout.setHorizontalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInventarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(123, 123, 123))
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        panelInventarioLayout.setVerticalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //evento del boton modificar
    private void modificarRegistros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarRegistros
        if(modelo.isCambio()){
            List<Inventario> inventarios = modelo.getInventario();
            int filas=0;
            for(Inventario inventario : inventarios){ //recorre la lista
                if(inventario.isSeActualizo()){ //si el inventario se modifico
                   filas += inventarioDao.actualizar(inventario); //actualiza
                }
            }
            if(filas > 0){ //actualiza la tabla
                //mensaje de modificacion exitosa, dice cuantas filas fueron modificadas
                JOptionPane.showMessageDialog(null,"Se modificaron: "+filas+" filas","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE); 
                inventarios = inventarioDao.traerTodosLosRegistros();
                modelo = new mx.com.model.util.InventarioTable(inventarios);
                tablaInventario.setModel(modelo);
            }else{
                //mensaje de alerta, no se modificaron datos
                JOptionPane.showMessageDialog(null,
                    "No se han modificado filas, ocurrió un error","Alerta",javax.swing.JOptionPane.WARNING_MESSAGE);  
            }
        }else{
            //mensaje de informacion
            JOptionPane.showMessageDialog(null,
                "No hizo cambios en ninguna fila","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_modificarRegistros

    //evento del boton eliminar
    private void eliminarRegistros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarRegistros
        int fila = tablaInventario.getSelectedRow();//se obtiene la fila seleccionada
            if(fila>=0){
            Inventario inventarios = modelo.getInventarioByRow(fila); //se llama al metodo que creamos para obtener el inventario
            int filasBorradas =0; //contador de filas borradas
            int filasActualizadas =0; //contador de filas actualizadas
            filasBorradas = inventarioDao.eliminar(inventarios); //se elimina la fila
            if(filasBorradas > 0){ //verifica que se haya borrado al menos una fila
                filasActualizadas = inventarioDao.actualizar(inventarios); //actualiza datos, ya con esa fila eliminada
                inventario = inventarioDao.traerTodosLosRegistros(); //se actualiza la tabla con los datos restantes
                modelo = new mx.com.model.util.InventarioTable(inventario);
                tablaInventario.setModel(modelo);
                //mensaje de eliminacion exitosa
                JOptionPane.showMessageDialog(null,
                    "Se han eliminado: "+filasBorradas+" filas, Se han actualizado: "+filasActualizadas+" filas",
                    "Informacion",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }else{
                //mensaje de alerta, no se eliminaron datos
                JOptionPane.showMessageDialog(null,
                "No se han eliminado filas, ocurrió un error","Alerta",javax.swing.JOptionPane.WARNING_MESSAGE); 
            }
        }else{
             //mensaje de alerta
                JOptionPane.showMessageDialog(null,
                "No seleccionó ninguna fila","Información",javax.swing.JOptionPane.INFORMATION_MESSAGE);   
            }
    }//GEN-LAST:event_eliminarRegistros

    //evento del boton regresar
    private void regresar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar
       MenuPrincipal menu = new MenuPrincipal();
       menu.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_regresar

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelInventario;
    private javax.swing.JTable tablaInventario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
