
import java.sql.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fran De La Torre
 */
public class vista extends javax.swing.JFrame {

    DefaultTableModel modeloDatos;
    coche automovil;
    controlador control;

    /**
     * Creates new form vista
     */
    public vista() {
        initComponents();
        rellenarListaDesplegable();
        generaTabla();
    }

    public void rellenarListaDesplegable() {
        ResultSet resultado = control.obtenerRegistros("Coches");
        try {
            if (resultado != null) {
                combo.removeAllItems();
                while (resultado.next()) {
                    combo.addItem(resultado.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.out.println("FALLO rellenarLista()");
        }
    }

    public void generaTabla() {
        modeloDatos = new DefaultTableModel();
        modeloDatos.addColumn("Infracción");
        modeloDatos.addColumn("Fecha");
        modeloDatos.addColumn("Penalización");
        tabla.setModel(modeloDatos);
    }

    public void agregarFila() {
        Object[] fila = new Object[modeloDatos.getColumnCount()];
        modeloDatos.addRow(fila);
    }

    /*public void visualizarContactos() {
     ResultSet res = agenda.obtenerRegistros("contacto");
     int fila = 0;
     if (res != null) {
     try{
     while(res.next()){
     agregarFila();
     modeloDatos.setValueAt(res.getString("nombre"), fila, 0);
     modeloDatos.setValueAt(res.getString("direccion"), fila, 1);
     modeloDatos.setValueAt(res.getString("telefonos"), fila, 2);
     modeloDatos.setValueAt(res.getString("localidad"), fila, 3);
     modeloDatos.setValueAt(res.getString("correo"), fila, 4);
     modeloDatos.setValueAt(res.getString("edad"), fila++, 5);
     }
     }catch(SQLException evt){}
     }
     }*/
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tcoche = new javax.swing.JTextField();
        tmatricula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 480));
        getContentPane().setLayout(null);

        jLabel1.setText("Conductor");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 50, 70, 16);

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboItemStateChanged(evt);
            }
        });
        getContentPane().add(combo);
        combo.setBounds(160, 50, 190, 22);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del coche"));
        jPanel1.setLayout(null);

        jLabel2.setText("Coche");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(22, 37, 40, 16);

        jLabel3.setText("Matricula");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(12, 83, 50, 16);

        tcoche.setEditable(false);
        jPanel1.add(tcoche);
        tcoche.setBounds(80, 34, 162, 22);

        tmatricula.setEditable(false);
        jPanel1.add(tmatricula);
        tmatricula.setBounds(80, 80, 160, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(100, 90, 280, 120);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 230, 390, 120);

        consultar.setText("Consultar");
        getContentPane().add(consultar);
        consultar.setBounds(90, 380, 90, 25);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(300, 380, 80, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboItemStateChanged
        rellenarListaDesplegable();
    }//GEN-LAST:event_comboItemStateChanged

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
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tcoche;
    private javax.swing.JTextField tmatricula;
    // End of variables declaration//GEN-END:variables
}
