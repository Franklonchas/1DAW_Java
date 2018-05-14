
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class Vista extends javax.swing.JFrame {

    Controlador control;
    Alumnos alumno;
    Asignaturas asignatura;
    Cursos curso;
    Notas nota;
    DefaultListModel modeloLista;
    DefaultListModel modeloLista2;
    DefaultTableModel modelo;
    ArrayList<Cursos> listaCursos;
    ArrayList<Asignaturas> listaAsignaturas;
    ArrayList<Alumnos> listaAlumnos;

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        control = new Controlador();
        modeloLista = new DefaultListModel();
        modeloLista2 = new DefaultListModel();
        modelo = new DefaultTableModel();
        listaCursos = new ArrayList<Cursos>();
        listaAsignaturas = new ArrayList<Asignaturas>();
        listaAlumnos = new ArrayList<Alumnos>();
        rellenarListaDesplegable();
        rellenarListaAsignaturas();
        list1.setModel(modeloLista);
        list2.setModel(modeloLista2);
        tabla.setModel(modelo);
    }

    public void rellenarListaDesplegable() {
        ResultSet resultado = control.ObtenerCursos();
        try {
            if (resultado != null) {
                cCurso.removeAll();
                while (resultado.next()) {
                    curso = new Cursos(resultado.getInt("idCurso"), resultado.getString("curso"));
                    listaCursos.add(curso);
                    cCurso.addItem(curso.getCurso());
                }
            }
        } catch (SQLException e) {
            System.out.println("FALLO rellenarLista()");
        }
    }

    public void rellenarListaAsignaturas() {
        int cursoSeleccionado = listaCursos.get(cCurso.getSelectedIndex()).getIdCurso();
        ResultSet res = control.ObtenerAsignaturas(cursoSeleccionado);
        if (res != null) {
            cAsignatura.removeAll();
            try {
                while (res.next()) {
                    asignatura = new Asignaturas(res.getInt("idAsignatura"), res.getInt("idCurso"), res.getString("asignatura"));
                    listaAsignaturas.add(asignatura);
                    cAsignatura.addItem(asignatura.getAsignatura());
                }
            } catch (SQLException e) {
                System.err.println("Error al rellenar lista desplegable de Asignaturas");
            }
        }
    }

    public void rellenarJList1() {
        int cursoSeleccionado = listaCursos.get(cCurso.getSelectedIndex()).getIdCurso();
        ResultSet res = control.rellenarLista1(cursoSeleccionado);
        if (res != null) {
            try {
                while (res.next()) {
                    alumno = new Alumnos(res.getInt("idAlumno"), res.getString("nombre"), res.getInt("idCurso"));
                    listaAlumnos.add(alumno);
                    modeloLista.addElement(alumno.getNombre());
                }
            } catch (SQLException e) {
                System.err.println("Error al rellenar lista desplegable de Asignaturas");
            }
        }
    }

    public void moverTodosDerecha() {
        for (int i = 0; i < modeloLista.size(); i++) {
            modeloLista2.addElement(modeloLista.elementAt(i));
        }
        modeloLista.removeAllElements();
    }

    public void moverTodosIzquierda() {
        for (int i = 0; i < modeloLista2.size(); i++) {
            modeloLista.addElement(modeloLista2.elementAt(i));
        }
        modeloLista2.removeAllElements();
    }

    public void moverSeleccionadoDerecha() {
        try {
            Object cosa = list1.getSelectedValue();
            if (cosa.toString() != "") {
                modeloLista2.addElement(cosa);
                modeloLista.removeElement(cosa);
            }
        } catch (Exception evt) {
            System.err.println("No has seleccionado nada!");
        }
    }

    public void moverSeleccionadoIzquierda() {
        try {
            Object cosa = list2.getSelectedValue();
            if (cosa.toString() != "") {
                modeloLista.addElement(cosa);
                modeloLista2.removeElement(cosa);
            }
        } catch (Exception evt) {
            System.err.println("No has seleccionado nada!");
        }
    }

    public void rellenarTabla() {
        int cont = 0;
        int tamaño = Integer.parseInt(list2.getSize().toString());
        String[] nombreAlumnos = new String[tamaño];
        modelo.addColumn("Alumno");
        for (int i = 0; i < tamaño; i++) {
            nombreAlumnos[cont]=list2.getSelectedValue().toString();
            list2.remove(0);
            cont++;
        }
    }
    
//        int cursoSeleccionado = listaCursos.get(cCurso.getSelectedIndex()).getIdCurso();
//        ResultSet res = control.ObtenerAlumnosEvaluados(cursoSeleccionado);
//        String[] nombreAlumnos = new String[30];
//        if (res != null) {
//            modelo.addColumn("Alumno");
//            try {
//                while (res.next()) {
//                    modelo.addColumn(cAsignatura.getSelectedItem());
//                    for (int i = 0; i < list2.getComponentCount(); i++) {
//                        nombreAlumnos[i] = res.getString(i);
//                        for (int j = 0; j < nombreAlumnos.length ;j++) {
//                             modelo.addRow(nombreAlumnos);
//                        }
//                    }
//                }
//            } catch (SQLException e) {
//                System.err.println("Error al hacer la tabla");
//            }
//        }

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
        jLabel3 = new javax.swing.JLabel();
        aplicar = new javax.swing.JButton();
        cCurso = new java.awt.Choice();
        cEvaluacion = new java.awt.Choice();
        cAsignatura = new java.awt.Choice();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        evaluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        list2 = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        procesar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(765, 720));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección Asignatura"));

        jLabel1.setText("Curso");

        jLabel2.setText("Evaluación");

        jLabel3.setText("Asignatura");

        aplicar.setText("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });

        cCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cCursoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(cEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(cCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(cAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(aplicar)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3))
                    .addComponent(cCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(aplicar)
                    .addComponent(cEvaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        cEvaluacion.add("Evaluacion 1");
        cEvaluacion.add("Evaluacion 2");
        cEvaluacion.add("Evaluacion 3");
        cEvaluacion.add("Evaluacion FINAL");

        getContentPane().add(jPanel1);
        jPanel1.setBounds(54, 38, 639, 121);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección Alumnos"));

        jButton2.setText("> >");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("> |");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("< <");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("| <");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        evaluar.setText("Evaluar");
        evaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarActionPerformed(evt);
            }
        });

        list1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list1);

        list2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(list2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(evaluar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(15, 15, 15)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(evaluar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 190, 630, 270);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Evaluación Alumnos"));

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
        jScrollPane2.setViewportView(tabla);

        procesar.setText("Procesar");

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(procesar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(salir)
                        .addGap(13, 13, 13)))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(procesar)
                        .addGap(32, 32, 32)
                        .addComponent(salir))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(318, 318, 318))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(60, 480, 630, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void cCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cCursoItemStateChanged
        rellenarListaAsignaturas();
    }//GEN-LAST:event_cCursoItemStateChanged

    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
        rellenarJList1();
    }//GEN-LAST:event_aplicarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        moverTodosDerecha();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        moverTodosIzquierda();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        moverSeleccionadoDerecha();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        moverSeleccionadoIzquierda();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void evaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarActionPerformed
        rellenarTabla();
    }//GEN-LAST:event_evaluarActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicar;
    private java.awt.Choice cAsignatura;
    private java.awt.Choice cCurso;
    private java.awt.Choice cEvaluacion;
    private javax.swing.JButton evaluar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList list1;
    private javax.swing.JList list2;
    private javax.swing.JButton procesar;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
