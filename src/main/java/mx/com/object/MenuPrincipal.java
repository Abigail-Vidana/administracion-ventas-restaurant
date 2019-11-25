
package mx.com.object;

import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author abigail
 */

 //ventana para el menu principal
public class MenuPrincipal extends JFrame{

    public MenuPrincipal() {
        initComponents();
        //caracteristicas de la ventana
        setTitle("Restaurant Los bandidos");
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src/main/resources/comida.jpg"); //icono de la ventana
        Image image = icon.getImage();
        setIconImage(image); 
    }
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
                
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(51, 51, 51));

        jPanel1.setLayout(new java.awt.CardLayout());

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 255));

        jMenu1.setBackground(new java.awt.Color(255, 51, 204));
        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMenu1.setForeground(new java.awt.Color(0, 153, 153));
        jMenu1.setText("Inicio");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicio(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(153, 153, 153));
        jMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMenu2.setForeground(new java.awt.Color(0, 153, 153));
        jMenu2.setText("Ventas");
        jMenu2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventas(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMenu3.setForeground(new java.awt.Color(0, 153, 153));
        jMenu3.setText("Personal");
        jMenu3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personal(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMenu4.setForeground(new java.awt.Color(0, 153, 153));
        jMenu4.setText("Inventario");
        jMenu4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventario(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        jPanel1.add(new mx.com.object.Inicio(), "inicio");
        jPanel1.add(new mx.com.object.VentasPanel(), "ventas");
        jPanel1.add(new mx.com.object.PersonalPanel(), "personal");
        jPanel1.add(new mx.com.object.InventarioPanel(), "inventario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void changeCardPanel(String name){ //añadiendo el diseño de carta
        CardLayout cl = (CardLayout)(jPanel1.getLayout());
         cl.show(jPanel1, name);
    }
    private void inicio(java.awt.event.MouseEvent evt) {//carta de inicio
        changeCardPanel("inicio");
    }                       

    private void ventas(java.awt.event.MouseEvent evt) {//carta de ventas
        changeCardPanel("ventas");
    }                       

    private void personal(java.awt.event.MouseEvent evt) {//carta de personal
        changeCardPanel("personal");
    }                         

    private void inventario(java.awt.event.MouseEvent evt) {//carta de inventario
        changeCardPanel("inventario");
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}
