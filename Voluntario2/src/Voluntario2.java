
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fran De La Torre
 */
public class Voluntario2 extends javax.swing.JFrame {

    private static int cont = 0;
    private static ArrayList<Double> notas = new ArrayList<Double>();
    private double anota;
    private DecimalFormat f = new DecimalFormat("0.00");

    public Voluntario2() {
        initComponents();
    }

    public boolean ExceptionNotaString(String nota) {
        try {
            anota = Double.parseDouble(nota);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double divide(double op1, int op2) throws DivisionPorCeroException {
        if (op2 == 0) {
            DivisionPorCeroException e = new DivisionPorCeroException();
            throw e;
        } else {
            return op1 / op2;
        }

    }

    public void añadir() {
        String nota = tnota.getText();

        if (ExceptionNotaString(nota) == false) {
            if ("".equals(nota)) {
                JOptionPane.showMessageDialog(null, "Se debe introducir una nota", "Error nota", JOptionPane.ERROR_MESSAGE);
                tnota.setText(null);
                tnota.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "La nota tiene que ser un numero", "Error nota", JOptionPane.ERROR_MESSAGE);
                tnota.setText(null);
                tnota.requestFocus();
            }

        } else if (anota < 1 || anota > 10) {
            JOptionPane.showMessageDialog(null, "La nota tiene que estar entre 1 y 10", "Error nota", JOptionPane.ERROR_MESSAGE);
            tnota.setText(null);
            tnota.requestFocus();
        } else {
            notas.add(anota);
            cont++;
            tcontador.setText("" + cont);
            tnota.setText(null);
            System.out.println(notas.toString());
        }

    }

    public void nuevo() {
        tnota.setText(null);
        cont = 0;
        tcontador.setText("" + cont);
        tnotaMedia.setText(null);
        notas.clear();
        tnota.requestFocus();

    }

    public void calcular() {
        double media = 0.0;
        for (Double nota : notas) {
            double actual = nota;
            media += actual;}
        try {
            divide(media, cont);
            tnotaMedia.setText("" + f.format((media/cont)));
        } catch (DivisionPorCeroException e) {
            JOptionPane.showMessageDialog(null, "No se puede dividir por 0", "Error nota", JOptionPane.ERROR_MESSAGE);
            tnota.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tnota = new javax.swing.JTextField();
        tcontador = new javax.swing.JTextField();
        tnotaMedia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bAñadir = new javax.swing.JButton();
        bCalcular = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Nota");

        tcontador.setBackground(new java.awt.Color(204, 204, 204));

        tnotaMedia.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Contador");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Nota Media");

        bAñadir.setText("Añadir");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirActionPerformed(evt);
            }
        });

        bCalcular.setText("Calcular");
        bCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalcularActionPerformed(evt);
            }
        });

        bNuevo.setText("Nuevo");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(tnota))
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tcontador, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3))
                    .addComponent(bCalcular))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(tnotaMedia))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tcontador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnotaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAñadir)
                    .addComponent(bCalcular)
                    .addComponent(bNuevo))
                .addGap(30, 30, 30))
        );

        tcontador.setEditable(false);
        tcontador.setText("" +cont);
        tnotaMedia.setEditable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
        añadir();
        tnota.requestFocus();
    }//GEN-LAST:event_bAñadirActionPerformed

    private void bCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalcularActionPerformed
        calcular();
        tnota.requestFocus();
    }//GEN-LAST:event_bCalcularActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_bNuevoActionPerformed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Voluntario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Voluntario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Voluntario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Voluntario2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voluntario2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bCalcular;
    private javax.swing.JButton bNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tcontador;
    private javax.swing.JTextField tnota;
    private javax.swing.JTextField tnotaMedia;
    // End of variables declaration//GEN-END:variables
}
