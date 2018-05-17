/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Medina vega
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.*;

public class MainAlumnos extends javax.swing.JFrame {

    AlumnosBD alumnos;
    int contador = 1;
    double nota = 0;
    double notaFinal = 0;
    Object Insufi[], Sufi[], Bien[], Notable[], Sobre[];
    double insufi = 0, sufi = 0, bien = 0, notable = 0, sobre = 0;

    public static DefaultTableModel modelo;

    /**
     * Creates new form MainAlumnos
     */
    public MainAlumnos() {
        modelo = new DefaultTableModel();
        alumnos = new AlumnosBD();
        initComponents();
        RellenarListaDesplegable1();
        choice2.add("Evaluacion 1");
        choice2.add("Evaluacion 2");
        choice2.add("Evaluacion 3");
        choice2.add("Evaluacion Final");

    }

    public void RellenarListaDesplegable1() {
        ResultSet res = alumnos.obtenerRegistro("Cursos");
        if (res != null) {
            choice1.removeAll();

            try {
                while (res.next()) {
                    choice1.add(res.getString("curso"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public int obtenerIdCurso() {

        ResultSet res = alumnos.obtenerIdCurso(choice1.getSelectedItem());

        try {
            return res.getInt("idCurso");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public void RellenarColumnasTabla() {
        int idCurso = obtenerIdCurso();
        modelo.addColumn("");
        ResultSet res = alumnos.obtenerAsignaturas(idCurso);
        if (res != null) {

            try {
                while (res.next()) {

                    modelo.addColumn(res.getString("asignatura"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarFilasYColumnas() {
        modelo = new DefaultTableModel();
        for (int i = modelo.getColumnCount() - 1; i >= 0; i--) {
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(i));
            // System.out.print(jTable1.getColumnModel().getColumn(i));
        }
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {

            modelo.removeRow(i);
        }
    }

    public void GuardarNotaArray(int idAsignatura) {
        insufi = 0;
        sufi = 0;
        bien = 0;
        notable = 0;
        sobre = 0;

        ResultSet res = alumnos.obtenerNotas(idAsignatura, choice2.getSelectedItem());

        if (res != null) {

            try {
                while (res.next()) {
                    nota = res.getDouble("nota");
                    if (nota < 5.0) {
                        insufi++;
                    } else if (nota >= 5.0 && nota < 6.0) {
                        sufi++;
                    } else if (nota >= 6.0 && nota < 7.0) {
                        bien++;
                    } else if (nota >= 7.0 && nota < 9.0) {
                        notable++;
                    } else if (nota >= 9.0) {
                        sobre++;
                    }

                }
                double totalinsufi = 100 * insufi / 3;
                String insufiTotal = String.valueOf(insufi) + "(" + String.valueOf(totalinsufi) + ")%";
                Insufi[contador] = insufiTotal;
                double totalSufi = 100 * sufi / 3;
                String sufiTotal = String.valueOf(sufi) + "(" + String.valueOf(totalSufi) + ")%";
                Sufi[contador] = sufiTotal;
                double totalBien = 100 * bien / 3;
                String bienTotal = String.valueOf(bien) + "(" + String.valueOf(totalBien) + ")%";
                Bien[contador] = bienTotal;
                double totalNotable = 100 * notable / 3;
                String notableTotal = String.valueOf(notable) + "(" + String.valueOf(totalNotable) + ")%";
                Notable[contador] = notableTotal;
                double totalSobre = 100 * sobre / 3;
                String sobreTotal = String.valueOf(sobre) + "(" + String.valueOf(totalSobre) + ")%";
                Sobre[contador] = sobreTotal;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void ObtenerTodosArrays() {
        contador = 1;
        ResultSet res = alumnos.obtenerIdAsignatura(obtenerIdCurso());

        if (res != null) {

            try {
                while (res.next()) {

                    GuardarNotaArray(res.getInt("idAsignatura"));
                    contador++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public int Asignaturas() {
        int total = 0;
        ResultSet res = alumnos.obtenerAsignaturas(obtenerIdCurso());
        try {
            while (res.next()) {

                total++;
            }
            return total;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void RellenarFilasTabla() {

        modelo.addRow(Insufi);
        modelo.addRow(Sufi);
        modelo.addRow(Bien);
        modelo.addRow(Notable);
        modelo.addRow(Sobre);

        jTable1.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        choice2 = new java.awt.Choice();
        jPanel2 = new javax.swing.JPanel();
        Consultar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 500));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccion curso/evaluacion"));
        jPanel1.setLayout(null);

        jLabel1.setText("Curso:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 30, 32, 14);

        jLabel2.setText("Evaluacion:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 60, 70, 14);
        jPanel1.add(choice1);
        choice1.setBounds(110, 30, 70, 20);
        jPanel1.add(choice2);
        choice2.setBounds(110, 60, 100, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 710, 120);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estadisticas Notas"));
        jPanel2.setLayout(null);

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        jPanel2.add(Consultar);
        Consultar.setBounds(600, 30, 100, 23);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel2.add(Salir);
        Salir.setBounds(630, 80, 53, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 570, 100);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 150, 720, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed

        Insufi = new Object[Asignaturas() + 1];
        Sufi = new Object[Asignaturas() + 1];
        Bien = new Object[Asignaturas() + 1];
        Notable = new Object[Asignaturas() + 1];
        Sobre = new Object[Asignaturas() + 1];
        Insufi[0] = "Insuficiente";
        Sufi[0] = "Suficiente";
        Bien[0] = "Bien";
        Notable[0] = "Notable";
        Sobre[0] = "Sobresaliente";
        eliminarFilasYColumnas();
        ObtenerTodosArrays();
        RellenarColumnasTabla();
        RellenarFilasTabla();
// TODO add your handling code here:
    }//GEN-LAST:event_ConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(MainAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Salir;
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
