/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class VentanaSaludo extends java.awt.Frame {

    /**
     * Creates new form VentanaSaludo
     */
    public VentanaSaludo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton = new java.awt.Button();
        etiqueta = new java.awt.Label();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLocationRelativeTo(null);
        setMinimumSize(new java.awt.Dimension(450, 350));
        setResizable(false);
        setTitle("Ejemplo1");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);

        boton.setBackground(new java.awt.Color(204, 255, 204));
        boton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boton.setLabel("Haga click Aquí");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });
        add(boton);
        boton.setBounds(150, 230, 180, 50);

        etiqueta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        etiqueta.setForeground(new java.awt.Color(255, 51, 0));
        etiqueta.setText("HOLA MUNDO!!");
        add(etiqueta);
        etiqueta.setBounds(150, 80, 210, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
        
    }//GEN-LAST:event_botonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSaludo().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button boton;
    private java.awt.Label etiqueta;
    // End of variables declaration//GEN-END:variables
}