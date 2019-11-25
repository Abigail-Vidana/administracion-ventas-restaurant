
package mx.com.model.util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import mx.com.model.VentaDetalle;

/**
 *
 * @author abigail
 */
//clase para almacenar datos de detalle en la tabla de venta
public class VentaDetalleTableModel  extends AbstractTableModel{

    //titulos de las columnas
    private String[] columnas = {"Articulo","Cantidad","Precio", "Importe"};
    private List<VentaDetalle> ventas;
    
    public VentaDetalleTableModel(List<VentaDetalle> ventas ){
        this.ventas = ventas;
    }
    
    /**
     * Metodo para obtener las filas 
     */
    @Override
    public int getRowCount() {
        if(ventas == null){
            return 0;
        }
        return ventas.size();
    }

    /**
     * Metodo para obtener las columnas
     */
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    /**
     * Metodo para dar valores a los campos de la tabla 
     */
    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        
        switch(col){
            case 0: temp = ventas.get(row).getArticulo(); //para la columna 0
                break;
            case 1: temp = ventas.get(row).getCantidad();//para la columna 1
                break;
            case 2: temp = ventas.get(row).getPrecio();//para la columna 2
                break;
            case 3: temp = ventas.get(row).getCantidad()*ventas.get(row).getPrecio(); //para la columna 3
                break;  
        }
        return temp;
    }
    
    /*
    El siguinte codigo se necesita para mostrar los nombres de las columnas en JTable
    */
    public String getColumnName(int col){
        return columnas[col];
    }
    
    public Class getColumnClass(int col){
        if(col == 0){
            return String.class;
        }
        else if(col==1){
            return Integer.class;
        }
        return Float.class;
    }
    
}
