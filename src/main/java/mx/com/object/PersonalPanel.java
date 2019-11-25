
package mx.com.object;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import mx.com.dao.PersonalDAO;
import mx.com.model.Personal;

/**
 *
 * @author abigail
 */
  //panel para el personal
public class PersonalPanel extends javax.swing.JPanel {
    //variables de la clase
    Personal personal;
    PersonalDAO personalDao = new PersonalDAO();
    public PersonalPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        //componentes
        btnLimpiar1 = new javax.swing.JButton();
        etTitulo = new javax.swing.JLabel();
        etNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        etApellidoP = new javax.swing.JLabel();
        apellidoP = new javax.swing.JTextField();
        etApellidoM = new javax.swing.JLabel();
        apellidoM = new javax.swing.JTextField();
        etSucursal = new javax.swing.JLabel();
        sucursal = new javax.swing.JTextField();
        etPuesto = new javax.swing.JLabel();
        puesto = new javax.swing.JTextField();
        etDireccion = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        etTelefono = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        etSexo = new javax.swing.JLabel();
        sexo = new javax.swing.JTextField();
        etSueldo = new javax.swing.JLabel();
        sueldo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();

        btnLimpiar1.setText("Limpiar"); //boton limpiar
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() { //oyente de accion para el boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(0, 102, 102)); //color de fondo
        //fuente, color y texto de la etiqueta de titulo
        etTitulo.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        etTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etTitulo.setText("Registro de personal");
        //fuente, color y texto de la etiqueta de nombre
        etNombre.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etNombre.setForeground(new java.awt.Color(255, 255, 255));
        etNombre.setText("Nombre:");
        //fuente, color y texto de la etiqueta de apellido paterno
        etApellidoP.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etApellidoP.setForeground(new java.awt.Color(255, 255, 255));
        etApellidoP.setText("Apellido paterno:");
        //fuente, color y texto de la etiqueta de apellido materno
        etApellidoM.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etApellidoM.setForeground(new java.awt.Color(255, 255, 255));
        etApellidoM.setText("Apellido materno:");
        //fuente, color y texto de la etiqueta de sucursal
        etSucursal.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etSucursal.setForeground(new java.awt.Color(255, 255, 255));
        etSucursal.setText("Sucursal:");
        //fuente, color y texto de la etiqueta de puesto
        etPuesto.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etPuesto.setForeground(new java.awt.Color(255, 255, 255));
        etPuesto.setText("Puesto:");
        //fuente, color y texto de la etiqueta de direccion
        etDireccion.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etDireccion.setForeground(new java.awt.Color(255, 255, 255));
        etDireccion.setText("Direccion:");
        //fuente, color y texto de la etiqueta de telefono
        etTelefono.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etTelefono.setForeground(new java.awt.Color(255, 255, 255));
        etTelefono.setText("Telefono:");
        //fuente, color y texto de la etiqueta de sexo
        etSexo.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etSexo.setForeground(new java.awt.Color(255, 255, 255));
        etSexo.setText("Sexo:");
        //fuente, color y texto de la etiqueta de sueldo
        etSueldo.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etSueldo.setForeground(new java.awt.Color(255, 255, 255));
        etSueldo.setText("Sueldo:");
        //boton guardar
        btnGuardar.setText("Guardar"); //texto
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {//accion de escucha del boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDatos(evt);
            }
        });
        //boton limpiar
        btnLimpiar.setText("Limpiar"); //texto
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {//accion de escucha del boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCampos(evt);
            }
        });
        //boton ver
        btnVer.setText("Ver personal"); //texto
        btnVer.addActionListener(new java.awt.event.ActionListener() {//accion de escucha del boton
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPersonal(evt);
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
                        .addGap(141, 141, 141)
                        .addComponent(etTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etPuesto)
                            .addComponent(etSucursal)
                            .addComponent(etApellidoM)
                            .addComponent(etNombre)
                            .addComponent(nombre)
                            .addComponent(etApellidoP)
                            .addComponent(apellidoP)
                            .addComponent(apellidoM)
                            .addComponent(sucursal)
                            .addComponent(puesto, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etDireccion)
                            .addComponent(etSueldo)
                            .addComponent(etSexo)
                            .addComponent(etTelefono)
                            .addComponent(telefono)
                            .addComponent(sexo)
                            .addComponent(sueldo)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(etTitulo)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(etNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etApellidoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etApellidoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etSucursal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etPuesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etSueldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnVer))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    //evento para el boton de guardar
    private void guardarDatos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDatos
        personal = new Personal(); //inicializa un objeto de la clase Personal
        //se obtienen los datos escritos en las cajas de texto y se guardan en las variables correspondientes
        personal.setNombre(nombre.getText());
        personal.setApellidoP(apellidoP.getText());
        personal.setApellidoM(apellidoM.getText());
        personal.setIdSucursal(Integer.parseInt(sucursal.getText()));
        personal.setPuesto(puesto.getText());
        personal.setDireccion(direccion.getText());
        personal.setTelefono(telefono.getText());
        personal.setSexo(sexo.getText());
        personal.setSueldo(Float.parseFloat(sueldo.getText()));    
        if(personalDao.guardar(personal)){
            limpiar(); //limpiar los campos de texto
            //mensaje de datos guardados
           JOptionPane.showMessageDialog(null,"Se han guardado los datos","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE); //mensaje de guardado exitoso       }
        }else{
            //mensaje de alerta
           JOptionPane.showMessageDialog(null,"Hubo un error al guardar los datos","Alerta",javax.swing.JOptionPane.WARNING_MESSAGE); //mensaje de guardado exitoso
        }
    }//GEN-LAST:event_guardarDatos


    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    //metodo para limpiar los campos de texto
    private void limpiar(){
        nombre.setText("");
        apellidoP.setText("");
        apellidoM.setText("");
        sucursal.setText("");
        puesto.setText("");
        direccion.setText("");
        telefono.setText("");
        sexo.setText("");
        sueldo.setText("");
    }

    //evento para el boton de ver
    private void VerPersonal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPersonal
        PersonalFrame todoElPersonal = new PersonalFrame();
        todoElPersonal.setVisible(true); //abre esta nueva ventana
        MenuPrincipal menu = (MenuPrincipal)SwingUtilities.getWindowAncestor(this);
        menu.dispose();  //cierra la ventana actual
    }//GEN-LAST:event_VerPersonal

    //evento para el boton limpiar
    private void limpiarCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCampos
        limpiar(); //llama al metodo limpiar
    }//GEN-LAST:event_limpiarCampos


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoM;
    private javax.swing.JTextField apellidoP;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnVer;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel etApellidoM;
    private javax.swing.JLabel etApellidoP;
    private javax.swing.JLabel etDireccion;
    private javax.swing.JLabel etNombre;
    private javax.swing.JLabel etPuesto;
    private javax.swing.JLabel etSexo;
    private javax.swing.JLabel etSucursal;
    private javax.swing.JLabel etSueldo;
    private javax.swing.JLabel etTelefono;
    private javax.swing.JLabel etTitulo;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField puesto;
    private javax.swing.JTextField sexo;
    private javax.swing.JTextField sucursal;
    private javax.swing.JTextField sueldo;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
