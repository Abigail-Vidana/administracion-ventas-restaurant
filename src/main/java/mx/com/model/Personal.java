package mx.com.model;

/**
 *
 * @author abiga
 */
//clase Personal, contiene los campos que identifican a un empleado
public class Personal {
    //variables de un empleado
    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int idSucursal;
    private String puesto;
    private String direccion;
    private String telefono;
    private String sexo;
    private float sueldo;
    private boolean seActualizo = false;//variable para identificar si fueron actualizados datos

    //Y sus respectivos metodos get y set para cada una de las variables anteriores

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isSeActualizo() {
        return seActualizo;
    }

    public void setSeActualizo(boolean seActualizo) {
        this.seActualizo = seActualizo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidoP;
    }
    
    
    
}
