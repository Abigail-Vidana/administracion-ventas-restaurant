
package mx.com.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abiga
 */

//clase venta, contiene los campos que identifican a una venta
public class Venta {
    //variables de venta
    private int id;
    private int id_personal;
    private Timestamp fecha;
    private float total;
    private List<VentaDetalle> detalles = new ArrayList<>(); //para cada venta, se pueden especificar detalles
    private boolean seActualizo = false;//variable para identificar si fueron actualizados datos

    //Y sus respectivos metodos get y set de las variables anteriores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = new Timestamp (fecha.getTime());
    }   
    
    /**
     * Metodo para pasar la fecha de String a formato fecha 
     */
    public void setFecha(String fecha){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            setFecha(date);
        } catch (ParseException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<VentaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<VentaDetalle> detalles) {
        this.detalles = detalles;
    }

    public boolean isSeActualizo() {
        return seActualizo;
    }

    public void setSeActualizo(boolean seActualizo) {
        this.seActualizo = seActualizo;
    }

    /**
     * Metodo que actualiza el total, nos sirve cuando eliminamos o modificamos datos
     * se trae todos los datos de detalles y recalcula el total
     */
    public void actualizarTotal(){
        this.total = (float)detalles.stream()
                        .mapToDouble(det -> det.getPrecio()*det.getCantidad())
                        .sum();
    }
    
    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", id_personal=" + id_personal + ", fecha=" + fecha + ", total=" + total + ", detalles=" + detalles + '}';
    }
    
}
