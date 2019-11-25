
package mx.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mx.com.model.Personal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abigail
 */
//clase para los query del personal que hereda de DAO, donde se crea la conexion
public class PersonalDAO extends DAO{
    
    public PersonalDAO(){
        super();
    }
    
    /**
     * Metodo de consulta para guardar los datos del personal, se guardan en la tabla
     */
    public boolean guardar(Personal personal) {

        boolean exito = false;
        
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO personal (nombre,apellido_p,apellido_m,id_sucursal,"
                + "puesto,direccion,telefono,sexo,sueldo) VALUES (?,?,?,?,?,?,?,?,?)")
                ){
            ps.setString(1, personal.getNombre());
            ps.setString(2, personal.getApellidoP());
            ps.setString(3, personal.getApellidoM());
            ps.setInt(4, personal.getIdSucursal());
            ps.setString(5, personal.getPuesto());
            ps.setString(6, personal.getDireccion());
            ps.setString(7, personal.getTelefono());
            ps.setString(8, personal.getSexo());
            ps.setDouble(9, personal.getSueldo());
            ps.executeUpdate();

            exito = true;
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }
    
    /**
     *  Metodo de consulta para seleccionar todos los datos del personal, para visualizar todos los registros
     */
    public List<Personal> traerTodosLosRegistros() {

        getConexion();
        List<Personal> personal = new ArrayList<>();
        Personal persona = null;
        
        try (PreparedStatement ps = conn.prepareStatement("SELECT id,nombre,apellido_p,apellido_m,id_sucursal,"
                + "puesto,direccion,telefono,sexo,sueldo FROM personal ORDER BY id");
                ResultSet rst = ps.executeQuery()
                ){

            while (rst.next()) {
                persona = new Personal();
                persona.setId(rst.getInt(1));
                persona.setNombre(rst.getString(2));
                persona.setApellidoP(rst.getString(3));
                persona.setApellidoM(rst.getString(4));
                persona.setIdSucursal(rst.getInt(5));
                persona.setPuesto(rst.getString(6));
                persona.setDireccion(rst.getString(7));
                persona.setTelefono(rst.getString(8));
                persona.setSexo(rst.getString(9));
                persona.setSueldo(rst.getFloat(10));
                personal.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return personal;
    }
    
    /**
     * Metodo de consulta para eliminar los datos del personal, elimina datos de la tabla
     */
    public int eliminar(Personal personal) {
        int filasBorradas = 0;
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM personal WHERE id=?");
                ){
            ps.setInt(1, personal.getId());
            filasBorradas += ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasBorradas;
    }
    
    /**
     * Metodo de consulta para actualizar los datos del personal, cuando queremos modificar 
     */
    public int actualizar(Personal personal) {
        int filasModificadas = 0;
        try (PreparedStatement ps = conn.prepareStatement("UPDATE personal SET nombre=?,apellido_p=?,apellido_m=?,"
                + "id_sucursal=?,puesto=?,direccion=?,telefono=?,sexo=?,sueldo=? WHERE id=?")
                ){
            ps.setString(1, personal.getNombre());
            ps.setString(2, personal.getApellidoP());
            ps.setString(3, personal.getApellidoM());
            ps.setInt(4, personal.getIdSucursal());
            ps.setString(5, personal.getPuesto());
            ps.setString(6, personal.getDireccion());
            ps.setString(7, personal.getTelefono());
            ps.setString(8, personal.getSexo());
            ps.setDouble(9, personal.getSueldo());
            ps.setInt(10, personal.getId());
            filasModificadas += ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return filasModificadas;
    }
    /**
     * Metodo de consulta para obtener los registros por fecha y sucursal
     */
    public List<Map<String, String>> registrosPorFechaYSucursal(int sucursal, int mes, int anio) {

        getConexion();
        List<Map<String, String>> resultado = new ArrayList<>();
        
        try (PreparedStatement ps = conn.prepareStatement("SELECT id_sucursal,fecha, nombre, apellido_p, apellido_m, puesto, total " +
                " FROM personal p INNER JOIN ventas v on p.id = v.id_personal " +
                " WHERE id_sucursal = ?  AND MONTH(fecha) = ? and YEAR(fecha) = ? ")
            ){
                ps.setInt(1, sucursal);
                ps.setInt(2, mes);
                ps.setInt(3, anio);
                
                ResultSet rst = ps.executeQuery();
                while (rst.next()) {
                    Map<String, String> fila = new LinkedHashMap<>();
                    fila.put("Sucursal", rst.getString("id_sucursal"));
                    fila.put("Fecha", rst.getString("fecha"));
                    fila.put("Nombre", rst.getString("nombre"));
                    fila.put("A. Paterno", rst.getString("apellido_p"));
                    fila.put("A. Materno", rst.getString("apellido_m"));
                    fila.put("Puesto", rst.getString("puesto"));
                    fila.put("Total", rst.getString("total"));
                    resultado.add(fila);
                }
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return resultado;
    }
    /**
     * Metodo de consulta para obtener las sucursales
     */
    public List<Integer> todasLasSucursales(){
        getConexion();
        List <Integer> sucursales = new ArrayList<>();
        
        try (PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT id_sucursal FROM personal")    
            ){
            ResultSet rst = ps.executeQuery();
                while (rst.next()) {
                    sucursales.add(rst.getInt(1));
                }
            
        }catch (SQLException e) {
            System.out.println("Error en sql: ");
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return sucursales;
    }
}
