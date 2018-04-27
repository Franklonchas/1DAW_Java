
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;

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

    controlador control;
    jornadas jornada;
    partidos partido;
    ArrayList<jornadas> listaJornadas;
    ArrayList<partidos> listaPartidos;

    /**
     * Creates new form vista
     */
    public vista() {
        initComponents();
        listaJornadas = new ArrayList<jornadas>();
        listaPartidos = new ArrayList<partidos>();
        control = new controlador();
        rellenarListaDesplegableJornada();
        rellenarPanel();
        rellenarTabla();
    }

    public void rellenarListaDesplegableJornada() {

        ResultSet res = control.obtenerRegistroJornada("JORNADAS");
        if (res != null) {
            combo1.removeAll();
            try {

                while (res.next()) {
                    jornada = new jornadas(res.getString("jornada"), res.getString("fecha"));
                    listaJornadas.add(jornada);
                    combo1.addItem(jornada.getJornada());
                }
            } catch (SQLException e) {
                System.err.println("Error al rellenar lista desplegable de JORNADAS");
            }
        }

        String jornadaSeleccionada = listaJornadas.get(combo1.getSelectedIndex()).getJornada();
        ResultSet res2 = control.obtenerRegistroPartido(jornadaSeleccionada);
        if (res2 != null) {
            combo2.removeAll();
            try {
                while (res2.next()) {
                    partido = new partidos(res2.getString("jornada"), res2.getString("codigoPartido"), res2.getString("codigoEquipo1"), res2.getString("codigoEquipo2"));
                    listaPartidos.add(partido);
                    combo2.addItem(partido.getcodigoPartido());
                }
            } catch (SQLException e) {
                System.err.println("Error al rellenar lista desplegable de PARTIDOS");
            }
        }
    }

    public void refrescarListaPartidos() {
        String jornadaSeleccionada = listaJornadas.get(combo1.getSelectedIndex()).getJornada();
        ResultSet res2 = control.obtenerRegistroPartido(jornadaSeleccionada);
        if (res2 != null) {
            combo2.removeAll();
            listaPartidos.clear();
            try {
                while (res2.next()) {
                    partido = new partidos(res2.getString("jornada"), res2.getString("codigoPartido"), res2.getString("codigoEquipo1"), res2.getString("codigoEquipo2"));
                    listaPartidos.add(partido);
                    combo2.addItem(partido.getcodigoPartido());
                }
            } catch (SQLException e) {
                System.err.println("Error al rellenar lista desplegable de PARTIDOS");
            }
        }
    }

    public void rellenarPanel() {
        local.setText("");
        visitante.setText("");
        String fechaJornadas = listaJornadas.get(combo1.getSelectedIndex()).getFecha();
        fecha.setText(fechaJornadas);

        String codigoEquipo1 = listaPartidos.get(combo2.getSelectedIndex()).getcodigoEquipo1();
        String codigoEquipo2 = listaPartidos.get(combo2.getSelectedIndex()).getcodigoEquipo2();

        ResultSet nombreEquipo1 = control.obtenerEquipo1(codigoEquipo1);
        ResultSet nombreEquipo2 = control.obtenerEquipo2(codigoEquipo2);
        if (nombreEquipo1 != null && nombreEquipo2 != null) {
            try {
                nombreEquipo1.next();
                nombreEquipo2.next();

                local.setText(nombreEquipo1.getString("nombre"));
                visitante.setText(nombreEquipo2.getString("nombre"));
            } catch (SQLException evt) {
                System.err.println("ERROR AL RELLENAR NOMBRES EN EL PANEL");
            }
        }
    }

    public void rellenarTabla() {
        String codigoPartido = listaPartidos.get(combo2.getSelectedIndex()).getcodigoPartido();
        String codigoEquipo1 = listaPartidos.get(combo2.getSelectedIndex()).getcodigoEquipo1();
        String codigoEquipo2 = listaPartidos.get(combo2.getSelectedIndex()).getcodigoEquipo2();
        ResultSet res = control.obtenerIntentos(codigoPartido,codigoEquipo1);
        ResultSet res2 = control.obtenerIntentos(codigoPartido,codigoEquipo2);

        if (res != null) {
            tabla.removeAll();
            try {
                int canastasLocal1 = Integer.parseInt(res.getString("canastas1"))*100/Integer.parseInt(res.getString("intentos1"));
                int canastasLocal2 = Integer.parseInt(res.getString("canastas2"))*100/Integer.parseInt(res.getString("intentos2"));
                int canastasLocal3 = Integer.parseInt(res.getString("canastas3"))*100/Integer.parseInt(res.getString("intentos3"));
                
                int canastasVisitante1 = Integer.parseInt(res2.getString("canastas1"))*100/Integer.parseInt(res2.getString("intentos1"));
                int canastasVisitante2 = Integer.parseInt(res2.getString("canastas2"))*100/Integer.parseInt(res2.getString("intentos2"));
                int canastasVisitante3 = Integer.parseInt(res2.getString("canastas3"))*100/Integer.parseInt(res2.getString("intentos3"));
                
                tabla.setValueAt(canastasLocal1 + "%", 0, 0);
                tabla.setValueAt(canastasLocal2 + "%", 0, 1);
                tabla.setValueAt(canastasLocal3 + "%", 0, 2);
                
                tabla.setValueAt(canastasVisitante1 + "%", 1, 0);
                tabla.setValueAt(canastasVisitante2 + "%", 1, 1);
                tabla.setValueAt(canastasVisitante3 + "%", 1, 2);
                
            } catch (SQLException evt) {
                System.err.println("ERROR AL RELLENAR LA TABLA");
            }
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        local = new javax.swing.JTextField();
        visitante = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        combo1 = new java.awt.Choice();
        combo2 = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 550));
        getContentPane().setLayout(null);

        jLabel1.setText("Jornada");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 50, 45, 16);

        jLabel2.setText("Partido");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 50, 40, 16);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Partido"));
        jPanel1.setLayout(null);

        jLabel3.setText("Fecha");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(39, 46, 34, 16);

        jLabel4.setText("Local");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(33, 103, 40, 16);

        jLabel5.setText("Visitante");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(214, 103, 49, 16);

        fecha.setEditable(false);
        jPanel1.add(fecha);
        fecha.setBounds(110, 40, 90, 22);

        local.setEditable(false);
        jPanel1.add(local);
        local.setBounds(82, 100, 110, 22);

        visitante.setEditable(false);
        jPanel1.add(visitante);
        visitante.setBounds(281, 100, 130, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(100, 120, 430, 160);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Canastas de 1", "Canastas de 2", "Canastas de 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(150, 320, 350, 70);

        jLabel6.setText("Local");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 340, 40, 16);

        jLabel7.setText("Visitante");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 370, 50, 16);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(270, 440, 70, 25);

        combo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1ItemStateChanged(evt);
            }
        });
        getContentPane().add(combo1);
        combo1.setBounds(160, 50, 100, 20);

        combo2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo2ItemStateChanged(evt);
            }
        });
        getContentPane().add(combo2);
        combo2.setBounds(400, 50, 120, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void combo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1ItemStateChanged
        refrescarListaPartidos();
        rellenarPanel();
        rellenarTabla();
    }//GEN-LAST:event_combo1ItemStateChanged

    private void combo2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo2ItemStateChanged
        rellenarPanel();
        rellenarTabla();
    }//GEN-LAST:event_combo2ItemStateChanged

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
    private java.awt.Choice combo1;
    private java.awt.Choice combo2;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField local;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField visitante;
    // End of variables declaration//GEN-END:variables
}
