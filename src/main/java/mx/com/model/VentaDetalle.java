
package mx.com.model;

/**
 *
 * @author abiga
 */
//clase de detalle de venta, contiene los campos que identifican los detalles de las ventas
public class VentaDetalle {
    //variables de detalle de venta
    private int id;
    private int id_venta;
    private String articulo;
    private int cantidad;
    private float precio;

    //Y sus respectivos metodos get y set de las variables anteriores
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
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

    @Override
    public String toString() {
        return "VentaDetalle{" + "id=" + id + ", id_venta=" + id_venta + ", articulo=" + articulo + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
    
}
