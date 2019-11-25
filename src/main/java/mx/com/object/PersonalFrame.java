package mx.com.object;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mx.com.dao.PersonalDAO;
import mx.com.model.Personal;
import mx.com.model.util.MiCellEditor;
import mx.com.model.util.PersonalTable;

/**
 *
 * @author abigail
 */
 //Frame para la ventana de la tabla de todo el personal
public class PersonalFrame extends javax.swing.JFrame {
    //variables de la clase
    List<Personal> personal = null;
    PersonalDAO personalDao = null;
    PersonalTable modelo = null;
    
    public PersonalFrame() {
        personalDao= new PersonalDAO();
        personal= personalDao.traerTodosLosRegistros();
        modelo = new mx.com.model.util.PersonalTable(personal);
        setTitle("Personal");
        ImageIcon icon = new ImageIcon("src/main/resources/comida.jpg"); //icono de la ventana
        Image image = icon.getImage();
        setIconImage(image);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //columnas que se van a editar de la tabla
    private void edit(){
        tablaPersonal.getColumnModel().getColumn(1).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(2).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(3).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(4).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(5).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(6).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(7).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(8).setCellEditor(new MiCellEditor());
        tablaPersonal.getColumnModel().getColumn(9).setCellEditor(new MiCellEditor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel panelPersonal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel(); //etiqueta de titulo
        jScrollPane1 = new javax.swing.JScrollPane(); //scroll
        tablaPersonal = new javax.swing.JTable(); //tabla de personal
        btnModificar = new javax.swing.JButton(); //boton modificar
        btnEliminar = new javax.swing.JButton(); //boton eliminar
        btnRegresar = new javax.swing.JButton(); //boton regresar

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPersonal.setBackground(new java.awt.Color(0, 102, 102));// color de fuente del panel
        //fuente, color y texto de la etiqueta de titulo
        titulo.setFont(new java.awt.Font("Calibri Light", 1, 36)); 
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Todo el personal");

        tablaPersonal.setModel(modelo); //se establece en el modelo la tabla
        jScrollPane1.setViewportView(tablaPersonal);

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
                regrsar(evt);
            }
        });
        //Diseño
        javax.swing.GroupLayout panelPersonalLayout = new javax.swing.GroupLayout(panelPersonal);
        panelPersonal.setLayout(panelPersonalLayout);
        panelPersonalLayout.setHorizontalGroup(
            panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalLayout.createSequentialGroup()
                .addGroup(panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelPersonalLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelPersonalLayout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(118, 118, 118)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)))
                    .addGroup(panelPersonalLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(titulo)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelPersonalLayout.setVerticalGroup(
            panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(23, 23, 23)
                .addGroup(panelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPersonal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPersonal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //evento del boton modificar
    private void modificarRegistros(java.awt.event.ActionEvent evt) {
        if(modelo.isCambio()){
        List<Personal> personal = modelo.getPersonal();
        int filas=0;
        for(Personal persona : personal){ //recorre la lista
            if(persona.isSeActualizo()){ //si el personal se modifico
               filas += personalDao.actualizar(persona); //actualiza
            }
        }
        if(filas > 0){ //actualiza la tabla
            //mensaje de modificacion exitosa, dice cuantas filas fueron modificadas
            JOptionPane.showMessageDialog(null,"Se modificaron: "+filas+" filas","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE); 
            personal = personalDao.traerTodosLosRegistros();
            modelo = new mx.com.model.util.PersonalTable(personal);
            tablaPersonal.setModel(modelo);
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
    }

    //evento para el boton eliminar
    private void eliminarRegistros(java.awt.event.ActionEvent evt) {
        int fila = tablaPersonal.getSelectedRow();//se obtiene la fila seleccionada
            if(fila>=0){
            Personal persona = modelo.getPersonalByRow(fila); //se llama al metodo que creamos para obtener al personal
            int filasBorradas =0; //contador de filas borradas
            int filasActualizadas =0; //contador de filas actualizadas
            filasBorradas = personalDao.eliminar(persona); //se elimina la fila
            if(filasBorradas > 0){ //verifica que se haya borrado al menos una fila
                filasActualizadas = personalDao.actualizar(persona); //actualiza datos, ya con esa fila eliminada
                personal = personalDao.traerTodosLosRegistros(); //se actualiza la tabla con los datos restantes
                modelo = new mx.com.model.util.PersonalTable(personal);
                tablaPersonal.setModel(modelo);
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
    }

    //evento para el boton regresar
    private void regrsar(java.awt.event.ActionEvent evt) {
       MenuPrincipal menu = new MenuPrincipal();
       menu.setVisible(true); //abre el emnu
       this.dispose(); //cierra la ventana actual
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPersonal;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
