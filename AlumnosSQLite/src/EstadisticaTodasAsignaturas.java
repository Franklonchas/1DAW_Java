/**
 *
 * @author Medina
 */
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class EstadisticaTodasAsignaturas extends javax.swing.JFrame {

    /** Creates new form EvaluacionAsignatura */
    AlumnosBD alumnos;
    int idCurso=0;
    int idAsignaturas[];
    int idAlumnos[];
    String asignaturas [];
    boolean existe=false;
    String tituloColumnas[];
    DefaultTableModel modelo;
    
    public EstadisticaTodasAsignaturas() {
        initComponents();
        alumnos=new AlumnosBD();
        rellenarCursos();        
    }
    public void rellenarCursos(){
        jComboBox1.removeAllItems();
        ResultSet res=alumnos.obtenerTabla("Cursos");
        if(res!=null){            
            try{
                while(res.next()){
                    String curso=res.getString("curso");
                    jComboBox1.addItem(curso);
                }
            }catch(SQLException e){
                System.out.println("error");
            }        
        }
    }
    public void generarTabla(int nAsignaturas) {
        modelo = new DefaultTableModel();
        modelo.addColumn("      ");
        for(int i=0; i<nAsignaturas; i++)
            modelo.addColumn(asignaturas[i]);
        for(int i=1;i<=5; i++) 
            agregarFilaTabla();
        modelo.setValueAt("Insuficiente", 0, 0);
        modelo.setValueAt("Suficiente", 1, 0);
        modelo.setValueAt("Bien", 2, 0);
        modelo.setValueAt("Notable", 3, 0);
        modelo.setValueAt("Sobresaliente", 4, 0);
        jTable1.setModel(modelo);        
    }
    public void agregarFilaTabla(){               
        Object[] fila = new Object[modelo.getColumnCount()];
        modelo.addRow(fila);          
    }    
    public void limpiarTabla(int col){
        for(int fila=0; fila<5; fila++)
            for(int j=1; j<col; j++)
                jTable1.setValueAt("",fila, j);
    }  
    
    public void visualizarEstadistica(){
        DecimalFormat df = new DecimalFormat("0.0");
        idCurso=alumnos.idClaveTabla("Cursos", "curso", (String) jComboBox1.getSelectedItem());
        idAlumnos=alumnos.obtenerAlumnos(idCurso);
        idAsignaturas=alumnos.obtenerAsignaturas(idCurso);
        existe=true;
        asignaturas=alumnos.obtenerNombreAsignaturas(idCurso);
        generarTabla(asignaturas.length);           
        for(int asig=0; asig<asignaturas.length; asig++){
            float ins=0, suf=0, bien=0, not=0, sob=0;
            for(int i=0; i<idAlumnos.length; i++){
                int nota=alumnos.obtenerNota(idAlumnos[i], idCurso, idAsignaturas[asig], (String) jComboBox2.getSelectedItem());
                if(nota==-1)
                    existe=false;
                if(nota<5)
                    ins++;
                else
                    if(nota<6)
                        suf++;
                    else
                        if(nota<7)
                            bien++;
                        else
                            if(nota<9)
                                not++;
                             else
                                sob++;
            }
            if(existe){
                modelo.setValueAt(""+df.format(ins*100/idAlumnos.length)+" %", 0, asig+1);
                modelo.setValueAt(""+df.format(suf*100/idAlumnos.length)+" %", 1, asig+1);
                modelo.setValueAt(""+df.format(bien*100/idAlumnos.length)+" %", 2, asig+1);
                modelo.setValueAt(""+df.format(not*100/idAlumnos.length)+" %", 3, asig+1);
                modelo.setValueAt(""+df.format(sob*100/idAlumnos.length)+" %", 4, asig+1);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estadística notas de un curso y una evaluación");
        setMinimumSize(new java.awt.Dimension(880, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección curso/evaluación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Curso:");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Evaluación");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.addItem("Evaluacion 1");
        jComboBox2.addItem("Evaluacion 2");
        jComboBox2.addItem("Evaluacion 3");
        jComboBox2.addItem("Evaluacion Final");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(441, 441, 441))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(32, 21, 800, 114);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estadística notas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(32, 32, 32))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(32, 162, 800, 158);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        visualizarEstadistica();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       //rellenarAsignaturas();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadisticaTodasAsignaturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
