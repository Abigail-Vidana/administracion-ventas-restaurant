
package mx.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.model.Inventario;

/**
 *
 * @author abiga
 */
//clase para los query del inventario que hereda de DAO, donde se crea la conexión
public class InventarioDAO extends DAO{
    
    public InventarioDAO(){
        super();
    }
    
    /**
     * Metodo de consulta para guardar los datos del inventario, se guardan en la tabla
     */
    public boolean guardar(Inventario inventario) {

        boolean exito = false;
        
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO inventario (cantidad,precio,articulo) VALUES (?,?,?)")
                ){
            ps.setInt(1, inventario.getCantidad());
            ps.setDouble(2, inventario.getPrecio());
            ps.setString(3, inventario.getArticulo());
            ps.executeUpdate();

            exito = true;
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }
    
    /**
     *  Metodo de consulta para seleccionar todos los datos del inventario, para visualizar todos los registros
     */
    public List<Inventario> traerTodosLosRegistros() {

        getConexion();
        List<Inventario> inventarios = new ArrayList<>();
        Inventario inventario = null;
        
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_producto,cantidad,precio,articulo FROM inventario ORDER BY id_producto");
                ResultSet rst = ps.executeQuery()
                ){

            while (rst.next()) {
                inventario = new Inventario();
                inventario.setIdProducto(rst.getInt(1));
                inventario.setCantidad(rst.getInt(2));
                inventario.setPrecio(rst.getFloat(3));
                inventario.setArticulo(rst.getString(4));
                inventarios.add(inventario);
            }
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return inventarios;
    }
    
    /**
     * Metodo de consulta para eliminar los datos del inventario, elimina datos de la tabla
     */
    public int eliminar(Inventario inventario) {
        int filasBorradas = 0;
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM inventario WHERE id_producto=?");
                ){
            ps.setInt(1, inventario.getIdProducto());
            filasBorradas += ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasBorradas;
    }
    
    /**
     * Metodo de consulta para actualizar los datos del inventario, cuando queremos modificar 
     */
    public int actualizar(Inventario inventario) {
        int filasModificadas = 0;
        try (PreparedStatement ps = conn.prepareStatement("UPDATE inventario SET cantidad=?,"
                + "precio=?, articulo=? WHERE id_producto=?")
                ){
            ps.setInt(1, inventario.getCantidad());
            ps.setFloat(2, inventario.getPrecio());
            ps.setString(3, inventario.getArticulo());
            ps.setInt(4, inventario.getIdProducto());
            filasModificadas += ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasModificadas;
    }
}
