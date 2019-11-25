
package mx.com.model.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import mx.com.model.Venta;
import mx.com.model.VentaDetalle;

/**
 *
 * @author abigail
 */

//clase para almacenar los datos de la tabla de ventas
public class VentaTable extends AbstractTableModel{
//arreglo para titulos de las columnas
    private String[] columnas;
    private List<Venta> ventas = null; //Lista de venta
    private List<VentaDetalle> detalles = null;// Lista de detalles de venta
    private Map<Integer, Venta> mapaVentas = null; //para almacenar venta y sus detalles
    
    //constructor de la clase
    public VentaTable(List<Venta> ventas){
        this.columnas = new String[]{"No venta", "No personal", "Fecha", "Articulo", "Cantidad", "Precio", "Total"};//titulos de la tabla
        this.ventas = ventas; //se guardan las ventas en una lista
        mapaVentas = new HashMap<>();
        ventas.forEach(venta -> this.mapaVentas.put(venta.getId(), venta)); //itera las ventas para obtener el id
        this.detalles = ventas.stream() //guardamos los detalles de cada venta
                .map(venta -> venta.getDetalles())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    //Numero de filas de la tabla
    @Override
    public int getRowCount() {
       if(detalles == null){
            return 0;
        }
        return detalles.size();
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
        VentaDetalle detalle = detalles.get(row);
        Venta venta = mapaVentas.get(detalle.getId_venta());
        
        switch(col){
            case 0: 
                temp = venta.getId();//para la columna 0
                break;
            case 1: 
                temp = venta.getId_personal();//para la columna 1
                break;
            case 2: 
                temp = venta.getFecha();//para la columna 2
                break;
            case 3: 
                temp = detalle.getArticulo();//para la columna 3
                break;
            case 4:
                temp = detalle.getCantidad();//para la columna 4
                break;
            case 5:
                temp = detalle.getPrecio();//para la columna 5
                break;
            case 6:  
                temp = detalle.getPrecio()*detalle.getCantidad();//para la columna 6
                break;
        }
        return temp;
    }
   
    /**
     * Metodo para preguntar si puede comenzar a editar o no
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
    
   /**
    *  Metodo para dar valores a la tabla
    */
   @Override
   public void setValueAt(Object aValue, int row, int col)
   {
       VentaDetalle detalle = detalles.get(row);
       Venta venta = mapaVentas.get(detalle.getId_venta());
       String val = aValue.toString();
       switch(col){
            case 1: 
                venta.setId_personal(Integer.parseInt(val));
                break;
            case 2: 
                venta.setFecha(val);
                break;
            case 3: 
                detalle.setArticulo(val);
                break;
            case 4:
                detalle.setCantidad(Integer.parseInt(val));
                venta.actualizarTotal();
                break;
            case 5:
                detalle.setPrecio(Float.parseFloat(val));
                venta.actualizarTotal();
                break;
            default :
                break;
        }
       this.fireTableDataChanged();
       venta.setSeActualizo(true);
   }
   
     /*
    El siguinte codigo se necesita para mostrar los nombres de las columnas en JTable
    */
    public String getColumnName(int col){
        return columnas[col];
    }
    
    public Class getColumnClass(int col){
        // int, int, Timestamp, String, int, float, float
        if(col <= 1 || col==4){
            return Integer.class;
        }
        else if(col==2){
            return Timestamp.class;
        }
        else if(col==3){
            return String.class;
        }
        return Float.class;
    }

    /**
     * Metodo para obtener las ventas
     */
    public Venta getVentaByRow(int row){
        Venta venta = mapaVentas.get(detalles.get(row).getId_venta());
        return venta;
    }
    
    /**
     * Metodo para obtener el detalle de las venta
     */
    public VentaDetalle getVentaDetalleByRow(int row){
        VentaDetalle detalle = detalles.get(row);
        return detalle;
    }
    
    //metodo para la lista de ventas
    public List<Venta> getVentas(){
        return ventas;
    }
    
    
}
