package mx.com.object;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import mx.com.dao.PersonalDAO;
import mx.com.model.util.ReporteTable;

/**
 *
 * @author abigail
 */
//Frame para la ventana de la tabla de reporte PDF
public class ReporteFrame extends javax.swing.JFrame {

    //variables de la clase
    List<Map<String, String>> personal = null; //una lista para todo lo que contendrá la tabla
    ReporteTable modeloTabla =  new ReporteTable(); //objeto modelo de la clase donde declaramos la tabla
    PersonalDAO personalDao = new PersonalDAO(); //objeto para obtener las consultas a la BD
    
    List<Integer> listaSucursales = personalDao.todasLasSucursales(); //en una lista guardamos todas las sucursales 
    DefaultComboBoxModel modelo = new DefaultComboBoxModel(listaSucursales.toArray()); //valores de la lista desplegable para las sucursales
    //valores para la lista desplegable del mes (en numero)
    DefaultComboBoxModel modeloMes = new DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
    DefaultComboBoxModel modeloAnio; //para asignar los valores de la lista desplegable del año
    
    public ReporteFrame() { 
        setTitle("Reporte PDF"); //titulo de la ventana
        ImageIcon icon = new ImageIcon("src/main/resources/comida.jpg"); //icono de la ventana
        Image image = icon.getImage(); //icono de imagen
        setIconImage(image); 
        int anio = Calendar.getInstance().get(Calendar.YEAR); //se obtiene el año actual
        List<Integer> anios = new ArrayList<>(); //lista para los 5 años permitidos
        for(int i = anio; i > anio-5; i--){ //se añade a la lista, el año actual y 4 años anteriores
            anios.add(i);
        }
        modeloAnio = new DefaultComboBoxModel(anios.toArray());//se establece en el modelo la lista de años como un arreglo
        initComponents();
        //el siguiente codigo es para un filtro del tipo de documento que es pdf
        FileFilter filter = new FileNameExtensionFilter("PDF Document","pdf"); 
        jFileChooser1.setFileFilter(filter);
        jFileChooser1.setAcceptAllFileFilterUsed(false);
        setLocationRelativeTo(null);
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        pnlReporte = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        etSucursal = new javax.swing.JLabel();
        sucursal = new javax.swing.JComboBox<>();
        etMes = new javax.swing.JLabel();
        mes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPDF = new javax.swing.JTable();
        btnReporte = new javax.swing.JButton();
        etAño = new javax.swing.JLabel();
        anio = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlReporte.setBackground(new java.awt.Color(0, 102, 102));
        pnlReporte.setForeground(new java.awt.Color(0, 153, 153));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Reporte PDF");

        etSucursal.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etSucursal.setForeground(new java.awt.Color(255, 255, 255));
        etSucursal.setText("Sucursal:");

        sucursal.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        sucursal.setModel(modelo);

        etMes.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etMes.setForeground(new java.awt.Color(255, 255, 255));
        etMes.setText("Mes:");

        mes.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        mes.setModel(modeloMes);

        tablaPDF.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        tablaPDF.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaPDF);

        btnReporte.setText("Crear PDF");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPdf(evt);
            }
        });

        etAño.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etAño.setForeground(new java.awt.Color(255, 255, 255));
        etAño.setText("Año:");

        anio.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        anio.setModel(modeloAnio);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarDatos(evt);
            }
        });

        javax.swing.GroupLayout pnlReporteLayout = new javax.swing.GroupLayout(pnlReporte);
        pnlReporte.setLayout(pnlReporteLayout);
        pnlReporteLayout.setHorizontalGroup(
            pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReporteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReporteLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlReporteLayout.createSequentialGroup()
                        .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReporteLayout.createSequentialGroup()
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReporteLayout.createSequentialGroup()
                                .addComponent(etMes)
                                .addGap(47, 47, 47)
                                .addComponent(etAño)))
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        pnlReporteLayout.setVerticalGroup(
            pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etSucursal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etAño)
                        .addComponent(etMes, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnReporte))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //evento para el boton de bucar
    private void BuscarDatos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarDatos
        //se buscar en la BD por fecha y sucursal, se obtienen los valores
        personal= personalDao.registrosPorFechaYSucursal(sucursal.getItemAt(sucursal.getSelectedIndex()), 
                mes.getItemAt(mes.getSelectedIndex()), anio.getItemAt(anio.getSelectedIndex()));
        modeloTabla = new mx.com.model.util.ReporteTable(personal); //se envía a la tabla todos los valores
        tablaPDF.setModel(modeloTabla); //se envía a la tabla del reporte los valores de la tabla que buscó por sucural y fecha
    }//GEN-LAST:event_BuscarDatos
    //evento para el boton de crear PDF
    private void crearPdf(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPdf
        if(personal.size()>0){ //si hay resgitros encontrados
            //le damos a elegir donde guardar el archivo
            jFileChooser1.showSaveDialog(null);
            File archivo =jFileChooser1.getSelectedFile(); //aqui se almacena el nombre del archivo
            if(archivo !=null){ //si se solicitó guardar un archivo
                String suffix = ".pdf"; //variable para el sufijo
                //en caso de que no se asignó automáticamente el .pdf
                if(!jFileChooser1.getSelectedFile().getAbsolutePath().endsWith(suffix)){
                    archivo = new File(jFileChooser1.getSelectedFile() + suffix); //se asigna a nuestro nombre el .pdf
                }
                Document reportePdf = new Document(); //variable de tipo Document para el reporte
                try {
                    //con esta variable escribimos sobre el archivo
                    PdfWriter pdfWriter = PdfWriter.getInstance(reportePdf, new FileOutputStream(archivo));
                    reportePdf.open(); //se abre
                    //al titulo le ponemos un tipo de fuente y tamaño
                    reportePdf.add(getParrafo(18f,24f,"Reporte por mes",FontFactory.HELVETICA_BOLDOBLIQUE));
                    reportePdf.add(crearTabla()); //se crea el reporte
                    reportePdf.close(); //cerramos el reporte
                    pdfWriter.close(); //le indica que no escribimos mas
                    JOptionPane.showMessageDialog(null, "Reporte Creado!"); //mensaje que informa al usuario de reporte creado
                } catch (FileNotFoundException | DocumentException ex) { //excepcion que puede ocurrir
                    Logger.getLogger(ReporteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay Información!");//si no hay registros, se le informa al usuario
        }
    }//GEN-LAST:event_crearPdf

    //con este metodo le damos al texto del documento, un tamaño a la letra, espacios y tipo de letra al texto que recibe
    private Paragraph getParrafo(float fntSize, float lineSpacing, String text, String letra){
        return new Paragraph(new Phrase(lineSpacing,text,
                               FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)));
    }
    
    //metodo para obtener los valores que se van a guardar en la tabla de reporte
    private PdfPTable crearTabla(){
        float[] anchoColumnas = {1.6f,3f,1.8f,1.8f,1.8f,1.8f,1.8f}; //espacio de las columnas
        //se crea la tabla y se indica el ancho que lleva sus columnas, y al mismo tiempo le decimos que son 7 columnas
        PdfPTable tabla = new PdfPTable(anchoColumnas); 
        tabla.setWidthPercentage(110); //ancho
        tabla.setSpacingAfter(5f); //espacio despues
        tabla.setSpacingBefore(5f); //espacio antes
        
        //aqui obtenemos la primera fila (los titulos)
        personal.get(0).keySet().forEach( col -> { //se itera cada titulo o columna
            PdfPCell celda = new PdfPCell(getParrafo(10f,10f,col,FontFactory.COURIER_BOLD)); //tamaño, espacio, texto y tipo de letra de cada titulo
            celda.setBackgroundColor(BaseColor.CYAN); //un color para los titulos
            tabla.addCell( celda); //añadimos todos estos titulos a la tabla
        });
        
        //aqui obtenemos todos los valores de la tabla
        personal.forEach(fila ->{ //se itera cada fila
            fila.values().forEach(col ->{ //para cada fila le damos un valor a las 7 columnas (0,1 - 0,2 - 0,3 - 0,4...)
                //tamaño, espacio, texto y tipo de letra de cada titulo
                tabla.addCell( new PdfPCell(getParrafo(8f,10f,col,FontFactory.COURIER))); //se añade todos estos valores a la tabla
            });
        });
        return tabla; //se retorna la tabla
    }
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Integer> anio;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel etAño;
    private javax.swing.JLabel etMes;
    private javax.swing.JLabel etSucursal;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Integer> mes;
    private javax.swing.JPanel pnlReporte;
    private javax.swing.JComboBox<Integer> sucursal;
    private javax.swing.JTable tablaPDF;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
