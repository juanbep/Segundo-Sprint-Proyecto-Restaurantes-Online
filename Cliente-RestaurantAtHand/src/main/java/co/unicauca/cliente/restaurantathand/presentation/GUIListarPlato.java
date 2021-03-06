/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.cliente.restaurantathand.presentation;

import javax.swing.ImageIcon;



/**
 *
 * @author Michelle Vallejo
 */
public class GUIListarPlato extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIListarMenu
     */
    ImageIcon iconobtn = new ImageIcon("src/main/java/resource/mas.png");
    ImageIcon iconolbl = new ImageIcon("src/main/java/resource/listarPlato.png");
    public GUIListarPlato() {
        initComponents();
        lblLogo.setIcon(iconolbl);
        btnBuscarMenuList.setIcon(iconobtn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        lblidMenuList = new javax.swing.JLabel();
        txtIdMenuList = new javax.swing.JTextField();
        jlblIdPlatolist = new javax.swing.JLabel();
        txtIdPlatoList = new javax.swing.JTextField();
        lblEspacioBoton = new javax.swing.JLabel();
        btnBuscarMenuList = new javax.swing.JButton();
        pnlSur = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarRestaurant = new javax.swing.JTable();
        pnlNorte = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pnlCentro.setBackground(new java.awt.Color(255, 255, 255));
        pnlCentro.setPreferredSize(new java.awt.Dimension(393, 140));
        pnlCentro.setLayout(new java.awt.GridLayout(7, 3));

        lblidMenuList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblidMenuList.setText("Id Menu:");
        lblidMenuList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCentro.add(lblidMenuList);
        pnlCentro.add(txtIdMenuList);

        jlblIdPlatolist.setText("Id Plato:");
        jlblIdPlatolist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCentro.add(jlblIdPlatolist);
        pnlCentro.add(txtIdPlatoList);
        pnlCentro.add(lblEspacioBoton);

        btnBuscarMenuList.setText("Buscar");
        pnlCentro.add(btnBuscarMenuList);

        pnlSur.setBackground(new java.awt.Color(255, 255, 255));
        pnlSur.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Plato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pnlSur.setLayout(new java.awt.GridLayout(1, 0));

        tblListarRestaurant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tblListarRestaurant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListarRestaurantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListarRestaurant);

        pnlSur.add(jScrollPane1);

        pnlNorte.setBackground(new java.awt.Color(255, 255, 255));
        pnlNorte.setLayout(new java.awt.GridLayout(1, 0));

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setMaximumSize(new java.awt.Dimension(393, 56));
        lblLogo.setMinimumSize(new java.awt.Dimension(393, 56));
        lblLogo.setPreferredSize(new java.awt.Dimension(393, 28));
        pnlNorte.add(lblLogo);
        lblLogo.getAccessibleContext().setAccessibleName("holi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNorte, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addComponent(pnlSur, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNorte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(pnlSur, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pnlSur.getAccessibleContext().setAccessibleName("Lista de Menus");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListarRestaurantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListarRestaurantMouseClicked
        // TODO add your handling code here:
        int column = tblListarRestaurant.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblListarRestaurant.getRowHeight();
        /*if (row < tblListarRestaurant.getRowCount() && row >= 0 && column < tblListarRestaurant.getColumnCount() && column >= 0) 
        {
            Object value = tblListarRestaurant.getValueAt(row, column);
            if (value instanceof JButton) 
            {
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                if (btn.getName().equals("btnEliminar")) {
                    if (JOptionPane.showConfirmDialog(rootPane, "Se eliminar?? el registro, ??desea continuar?",
                            "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                    {
                        objPedido.eliminarHamburguesa(row);
                        if (objPedido.getListaHamburguesas().size() == 0) 
                        {
                            objVistaInicio.deshabilitar();
                        }
                        cargarDatosTabla();
                    }
                } else 
                {
                    actualizarHamburguesa(row, objPedido, this);
                }
            }
        }*/
    }//GEN-LAST:event_tblListarRestaurantMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMenuList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblIdPlatolist;
    private javax.swing.JLabel lblEspacioBoton;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblidMenuList;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tblListarRestaurant;
    private javax.swing.JTextField txtIdMenuList;
    private javax.swing.JTextField txtIdPlatoList;
    // End of variables declaration//GEN-END:variables

}
