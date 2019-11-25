
package mx.com.model.util;

import java.awt.Component;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author abiga
 */

//esta clase permite editar la tabla de ventas
public class MiCellEditor extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = 1L;
    private JComponent editor;
    private NumberFormat format = DecimalFormat.getInstance();
    
    //constructor de la clase
    public MiCellEditor() {
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(4);
            format.setRoundingMode(RoundingMode.HALF_UP);
            editor = new JTextField();
        }
        /**
         * Sobreescritura de metodo, permite obtener el texto del campo seleccionado 
         * Devuelve el valor contenido en el editor.
         */
        @Override
        public Object getCellEditorValue() {
            return ((JTextField)editor).getText();
        }

        /**
         * Sobreescritura de metodo, permite guardar el nuevo valor del campo
         */
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            ((JTextField)editor).setText(value.toString());
            return editor;
        }

        /**
         * Sobreescritura de metodo,Le dice al editor que deje de editar y acepte 
         * cualquier valor parcialmente editado como el valor del editor. 
         * El editor devuelve falso si no se detuvo la edición.
         * Esto es útil para los editores que validan y no pueden aceptar entradas no válidas.
         */
        @Override
        public boolean stopCellEditing() {
//            try {
//                editor.commitEdit();
//            } catch (ParseException e) {
//                System.out.println("Error StopEd");
//                return false;
//            }
            ((JTextField) editor).selectAll();
            return super.stopCellEditing();
        }
    
}
