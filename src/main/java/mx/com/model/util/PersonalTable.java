package mx.com.model.util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import mx.com.model.Personal;

/**
 *
 * @author abigail
 */
//clase para almacenar los datos de la tabla del personal
public class PersonalTable extends AbstractTableModel{
    //arreglo para titulos de las columnas
    private String[] columnas;
    private List<Personal> personal=null; //lista de personal
    private boolean cambio; //verificar si hubo o no cambios
    
    //constructor que recibe como parametro una lista del personal
    public PersonalTable(List<Personal> personal){
        this.columnas = new String[]{"No. trabajador", "Nombre", "A. paterno", "A. materno", "Sucursal", 
             "Puesto", "Direccion","Telefono","Sexo","Sueldo"};
        this.personal= personal;
        this.cambio=false;
    }
    //Numero de filas de la tabla
    @Override
    public int getRowCount() {
        if(personal == null){
            return 0;
        }
        return personal.size();
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
            case 0: temp = personal.get(row).getId(); //para la columna 0
                break;
            case 1: temp = personal.get(row).getNombre();//para la columna 1
                break;
            case 2: temp = personal.get(row).getApellidoP();//para la columna 2
                break;
            case 3: temp =  personal.get(row).getApellidoM();//para la columna 3
                break; 
            case 4: temp =  personal.get(row).getIdSucursal();//para la columna 4
                break; 
            case 5: temp =  personal.get(row).getPuesto();//para la columna 5
                break; 
            case 6: temp =  personal.get(row).getDireccion();//para la columna 6
                break; 
            case 7: temp =  personal.get(row).getTelefono();//para la columna 7
                break;  
            case 8: temp =  personal.get(row).getSexo();//para la columna 8
                break; 
            case 9: temp = personal.get(row).getSueldo();//para la columna 9
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
       Personal persona = personal.get(row);
       String val = aValue.toString();
       switch(col){
            case 0: persona.setId(Integer.parseInt(val)); //para la columna 0
                break;
            case 1: persona.setNombre(val);//para la columna 1
                break;
            case 2: persona.setApellidoP(val);//para la columna 2
                break;
            case 3: persona.setApellidoM(val);//para la columna 3
                break; 
            case 4: persona.setIdSucursal(Integer.parseInt(val));//para la columna 4
                break; 
            case 5: persona.setPuesto(val);//para la columna 5
                break; 
            case 6: persona.setDireccion(val);//para la columna 6
                break; 
            case 7: persona.setTelefono(val);//para la columna 7
                break;  
            case 8: persona.setSexo(val);//para la columna 8
                break; 
            case 9: persona.setSueldo(Float.parseFloat(val));//para la columna 9
                break;
       }
        this.fireTableDataChanged();
        persona.setSeActualizo(true);
        cambio =true;
   }
       
    /*
    El siguinte codigo se necesita para mostrar los nombres de las columnas en JTable
    */
    public String getColumnName(int col){
        return columnas[col];
    }
    
    public Class getColumnClass(int col){
        // int, string, string, string, int, string, string, int, string, float
        if(col == 0 || col==4 || col==7){
            return Integer.class;
        }
        else if(col==9){
            return Float.class;
        }
        return String.class;
    }
    /**
     * Metodo para obtener el personal
     */
    public Personal getPersonalByRow(int row){
        Personal persona = personal.get(row);
        return persona;
    }
    //metodo para obtener la lista del personal
    public List<Personal> getPersonal(){
        return personal;
    }

    public boolean isCambio() {
        return cambio;
    }
     
}
