
package mx.com.model;

/**
 *
 * @author abigail
 */
public class Inventario {
    
    //variables del objeto
    private int idProducto;
    private int cantidad;
    private float precio;
    private String articulo;
    private boolean seActualizo = false;//variable para identificar si fueron actualizados datos

    //sus correspondientes metodos get y set de las variables anteriores
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public boolean isSeActualizo() {
        return seActualizo;
    }

    public void setSeActualizo(boolean seActualizo) {
        this.seActualizo = seActualizo;
    }
    
    
}
