
package mx.com.model.util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import mx.com.model.Inventario;

/**
 *
 * @author abigail
 */
//clase para almacenar los datos de la tabla de inventarios
public class InventarioTable extends AbstractTableModel{
    //arreglo para titulos de las columnas
    private String[] columnas;
    private List<Inventario> inventario=null; //lista de inventario
    private boolean cambio; //verificar si hubo o no cambios en la tabla
    
    //constructor que recibe como parametro una lista del inventario
    public InventarioTable(List<Inventario> inventario){
        //inicializacion de variables
        this.columnas = new String[]{"Id producto","Cantidad","Precio","Articulo"};
        this.inventario= inventario;
        this.cambio=false;
    }

    //constructor sin parametros de la clase
    public InventarioTable() {
    }

    //Numero de filas de la tabla
    @Override
    public int getRowCount() {
        if(inventario == null){
            return 0;
        }
        return inventario.size();
    }
    //Numero de columnas de la tabla
    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    //Metodo para obtener valores de la tabla
    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        
        switch(col){
            case 0: temp = inventario.get(row).getIdProducto(); //para la columna 0
                    break;
            case 1: temp = inventario.get(row).getCantidad();//para la columna 1
                    break;
            case 2: temp = inventario.get(row).getPrecio();//para la columna 2
                    break;
            case 3: temp = inventario.get(row).getArticulo();//para la columna 3
                    break;
        }
        return temp;
    
    }
    
    /**
     * Metodo para preguntar si puede comenzar a editar o no
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    /**
    *  Metodo para dar valores a la tabla
    */
   @Override
   public void setValueAt(Object aValue, int row, int col){
       Inventario inventarios = inventario.get(row);
       String val = aValue.toString();
       switch(col){
            case 0: inventarios.setIdProducto(Integer.parseInt(val));
                break;
            case 1: inventarios.setCantidad(Integer.parseInt(val));
                break;
            case 2: inventarios.setPrecio(Float.parseFloat(val));
                break;
            case 3: inventarios.setArticulo(val);
                break;
        }
        this.fireTableDataChanged();
        inventarios.setSeActualizo(true);
        cambio =true;
   }
   
   /*
    El siguinte codigo se necesita para mostrar los nombres de las columnas en JTable
    */
    public String getColumnName(int col){
        return columnas[col];
    }
    
    public Class getColumnClass(int col){
        // int, int, float, String
        if(col <= 1 ){
            return Integer.class;
        }
        else if(col==2){
            return Float.class;
        }
        return String.class;
    }
    /**
     * Metodo para obtener el inventario  
     */
    public Inventario getInventarioByRow(int row){
        Inventario inventarios = inventario.get(row);
        return inventarios;
    }
    //obtener las lista de inventario
    public List<Inventario> getInventario(){
        return inventario;
    }
    
    public boolean isCambio() {
        return cambio;
    }
}
