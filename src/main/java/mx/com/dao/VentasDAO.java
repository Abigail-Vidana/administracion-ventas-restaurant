
package mx.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.model.Venta;
import mx.com.model.VentaDetalle;

/**
 *
 * @author abiga
 */
//clase para los query de los datos de ventas hereda de DAO, donde se crea la conexion
public class VentasDAO extends DAO{
    
    VentaDetalleDAO detalleDao = new VentaDetalleDAO();
    
    public VentasDAO(){
        super();//constructor para llamar a la clase padre(que a su vez contiene el metodo de conexion)
    }
    
    /**
     * Metodo de consulta para guardar los datos del inventario, se guardan en la tabla
     */
    public boolean guardar(Venta venta, List<VentaDetalle> detallesVenta) {

        boolean exito = false;
        
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO ventas (id_personal,fecha, total) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)
                ){

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
            System.out.println(venta);
            ps.setInt(1, venta.getId_personal());
            ps.setTimestamp(2, venta.getFecha());
            ps.setDouble(3, venta.getTotal());
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    venta.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            detalleDao.guardar(venta.getId(), detallesVenta);
            exito = true;
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }
    
    /**
     *  Metodo de consulta para seleccionar todos los datos del inventario, para visualizar todos los registros
     */
    public List<Venta> traerTodasLasVentas() {

        getConexion();
        List<Venta> ventas = new ArrayList<>();
        Venta venta = null;
        
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_venta, id_personal, fecha, "
                + "articulo,cantidad,precio,total,"
                + " a.id id_detalle "
                + "FROM ventas_detalle a INNER JOIN ventas b ON a.id_venta = b.id ORDER BY 1");
                ResultSet rst = ps.executeQuery()
                ){

            while (rst.next()) {
                int idVenta = rst.getInt(1);
                if(venta == null || venta.getId() != idVenta){
                    venta = new Venta();
                    venta.setId(idVenta);
                    venta.setId_personal(rst.getInt(2));
                    venta.setFecha(rst.getDate(3));
                    venta.setTotal(rst.getFloat(7));
                    ventas.add(venta);
                }
                VentaDetalle detalle = new VentaDetalle();
                detalle.setId_venta(rst.getInt(1));
                detalle.setArticulo(rst.getString(4));
                detalle.setCantidad(rst.getInt(5));
                detalle.setPrecio(rst.getFloat(6));
                detalle.setId(rst.getInt(8));
                venta.getDetalles().add(detalle); 
            }
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return ventas;
    }

    /**
     * Metodo de consulta para eliminar los datos del inventario, elimina datos de la tabla
     */
    public int eliminar(Venta venta) {
        int filasBorradas = 0;
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM ventas WHERE id=?");
                ){
            ps.setInt(1, venta.getId());
            filasBorradas += ps.executeUpdate();
            filasBorradas += detalleDao.eliminar(venta.getDetalles());
            
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasBorradas;
    }
    
    /**
     * Metodo de consulta para actualizar los datos del inventario, cuando queremos modificar 
     */
    public int actualizar(Venta venta, boolean includDetalle) {
        int filasModificadas = 0;
        try (PreparedStatement ps = conn.prepareStatement("UPDATE ventas SET id_personal=?, fecha=?, total=? WHERE id=?")
                ){
            ps.setInt(1, venta.getId_personal());
            ps.setTimestamp(2, venta.getFecha());
            ps.setFloat(3, venta.getTotal());
            ps.setInt(4, venta.getId());
            filasModificadas += ps.executeUpdate();
            if(includDetalle){
                filasModificadas += detalleDao.actualizar(venta.getDetalles());
            }
            
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasModificadas;
    }
}
