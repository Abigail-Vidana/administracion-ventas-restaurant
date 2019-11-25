package mx.com.model.util;

import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author abigail
 */
//clase para almacenar los datos de la tabla de reporte de ventas
public class ReporteTable extends AbstractTableModel{

    private String[] columnas =  new String[]{"No hay datos"}; //arreglo con un solo string, que informa que no hay datos
    private boolean dataLoaded = false; //bandera para saber si hay datos que descargar
    private List<Map<String, String>> personal = null; //en esta lista guardamos todos los datos que contiene la tabla
    
    //constructor de la clase que recibe una lista con todos los datos de la tabla
    public ReporteTable(List<Map<String, String>> personal) {
        this.personal= personal; //se asigna esa lista en la lista de esta clase
        if(personal.size()>0){ //si es mayor que 0 significa que si tenemos datos
            //obtenemos la primera fila de la tabla (los titulos o columnas)
            columnas = personal.get(0).keySet().toArray(new String[personal.get(0).size()]); 
            dataLoaded = true; //le decimos que si hay datos
        }
    }
    
    public ReporteTable() { //constructor vacio
        
    }

    //para obtener las filas
    @Override
    public int getRowCount() {
        if(personal == null){
            return 0;
        }
        return personal.size();
    }

    //para obtener las columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //para obtener los valores de la tabla
    @Override
    public Object getValueAt(int row, int col) {
        
        if (dataLoaded){ //si hay valores en la tabla
            return personal.get(row).get(columnas[col]); //se obtienen todas las filas y columnas
        }
        return "No Hay Datos"; //si no, retorna este string
    }
    
    /**
     * Metodo para preguntar si puede comenzar a editar o no
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false; //la tabla no puede editarse
    }
    
    /*
    El siguinte codigo se necesita para mostrar los nombres de las columnas en JTable
    */
    public String getColumnName(int col){
        return columnas[col];
    }
    
    public Class getColumnClass(int col){
        return String.class;
    }
}
