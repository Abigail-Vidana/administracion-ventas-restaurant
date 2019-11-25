
package mx.com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.model.VentaDetalle;

/**
 *
 * @author abiga
 */
//clase para los query de los detalles de las ventas hereda de DAO, donde se crea la conexion
public class VentaDetalleDAO extends DAO {
    
    public VentaDetalleDAO(){
        super();//constructor para llamar a la clase padre(que a su vez contiene el metodo de conexion)
    }
    
    /**
     * Metodo de consulta para guardar los datos de detalle de venta
     */
    public boolean guardar(int idVenta,List<VentaDetalle> detalles) {

        boolean exito = false;
        try (PreparedStatement ps2 = conn.prepareStatement("INSERT INTO ventas_detalle (id_venta,articulo,cantidad,precio) VALUES (?,?,?,?)")
                ){
            
            for(VentaDetalle detalle: detalles){
                ps2.setInt(1, idVenta);
                ps2.setString(2, detalle.getArticulo());
                ps2.setInt(3, detalle.getCantidad());
                ps2.setDouble(4, detalle.getPrecio());
                ps2.executeUpdate();
            }
            exito = true;
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }
    
    /**
     * Metodo de consulta para eliminar los datos de detalle de venta
     * cuando se tiene una lista de detalles
     */
    public int eliminar(List<VentaDetalle> detalles) {
        int filasBorradas = 0;
            for(VentaDetalle detalle : detalles){
                
                filasBorradas += eliminar(detalle);
            }
        return filasBorradas;
    }
    
    /**
     * Metodo de consulta para eliminar los datos de detalle de venta 
     */
    public int eliminar(VentaDetalle detalle) {
        int filasBorradas = 0;
        try (PreparedStatement ps2 = conn.prepareStatement("DELETE FROM ventas_detalle WHERE id=? and id_venta=?")
                ){
                ps2.setInt(1, detalle.getId());
                ps2.setInt(2, detalle.getId_venta());
                filasBorradas += ps2.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasBorradas;
    }
    
    /**
     * Metodo de consulta para actualizar los datos de detalle de venta
     * cuando se tiene una lista de detalles
     */
    public int actualizar(List<VentaDetalle> detalles) {
        int filasModificadas = 0;
        for( VentaDetalle detalle : detalles){
            filasModificadas += actualizar(detalle);
        }
        return filasModificadas;
    }
    
    
    /**
     * Metodo de consulta para actualizar los datos de detalle de venta 
     */
    public int actualizar(VentaDetalle detalle) {
        int filasModificadas = 0;
        try (PreparedStatement ps2 = conn.prepareStatement("UPDATE ventas_detalle SET articulo=?, cantidad=?, precio=? WHERE id=?")
                ){
                ps2.setString(1, detalle.getArticulo());
                ps2.setInt(2, detalle.getCantidad());
                ps2.setFloat(3, detalle.getPrecio());
                ps2.setInt(4, detalle.getId());
                filasModificadas += ps2.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasModificadas;
    }
}
