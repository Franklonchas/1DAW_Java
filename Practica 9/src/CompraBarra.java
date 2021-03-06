
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fran de la Torre
 */
public class CompraBarra extends javax.swing.JFrame {

    ConsumoBarra agenda;
    DefaultTableModel modelo;

    public CompraBarra() {
        initComponents();
        agenda = new ConsumoBarra();
        rellenarListaDesplegable();
        generarTabla();
    }

    public void rellenarListaDesplegable() {
        ResultSet res = agenda.obtenerRegistroBarra("Barras");
        if (res != null) {
            try {
                combo.removeAll();
                while (res.next()) {
                    combo.addItem(res.getString("barra"));
                }
            } catch (SQLException e) {
            }
        }
    }

    public void generarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Articulo");
        modelo.addColumn("Unidades");
        modelo.addColumn("PVP");
        modelo.addColumn("Importe");
        tabla.setModel(modelo);
    }

    public void agregarFila() {
        modelo.addRow(new Object[tabla.getColumnCount()]);
    }

    public void visualizarBarra() {
        String fecha = tfecha.getText();
        String barra = (String) combo.getSelectedItem();

        ResultSet res = agenda.obtenerDatosBarra(barra, fecha);
        ResultSet res2 = agenda.obtenerConsumosBarra(barra, fecha);

        int fila = 0;
        if (res != null) {
            try {
                while (res.next()) {
                    agregarFila();
                    modelo.setValueAt(res.getString("articulo"), fila, 0);
                    modelo.setValueAt(res.getString("unidades"), fila, 1);
                    modelo.setValueAt(res.getString("pvp"), fila, 2);
                    fila++;
                }
            } catch (SQLException se) {
            }
        }
        fila = 0;

        if (res2 != null) {
            try {
                while (res2.next()) {
                    modelo.setValueAt(res2.getString("Importe"), fila, 3);
                    fila++;
                }
            } catch (SQLException se) {
            }
        }
        Double suma = 0.0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String total = (String) modelo.getValueAt(i, 3);
            suma = suma + (Double.parseDouble(total));
            labelCambia.setText("" + suma);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tfecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelCambia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        jLabel1.setText("Barra");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 55, 31, 16);

        getContentPane().add(combo);
        combo.setBounds(61, 52, 263, 22);

        jLabel2.setText("Fecha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 108, 34, 16);
        getContentPane().add(tfecha);
        tfecha.setBounds(64, 105, 164, 22);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Articulo", "Unidades", "PVP", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 170, 374, 96);

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar);
        consultar.setBounds(39, 309, 87, 25);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(263, 309, 59, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Total importe");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(182, 284, 86, 16);

        labelCambia.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labelCambia.setForeground(new java.awt.Color(204, 0, 0));
        labelCambia.setText(".");
        getContentPane().add(labelCambia);
        labelCambia.setBounds(286, 284, 52, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        visualizarBarra();
    }//GEN-LAST:event_consultarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompraBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraBarra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompraBarra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCambia;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tfecha;
    // End of variables declaration//GEN-END:variables
}
