/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran de la Torre
 */
public class ejercicio2 extends javax.swing.JFrame {

    /**
     * Creates new form ejercicio2
     */
    public ejercicio2() {
        initComponents();
    }/*
    
     */


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dia = new java.awt.Label();
        cDia = new java.awt.Choice();
        label1 = new java.awt.Label();
        cMes = new java.awt.Choice();
        sbar = new java.awt.Scrollbar();
        reset = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 150));
        getContentPane().setLayout(null);

        Dia.setName("Dia"); // NOI18N
        Dia.setText("Dia");
        getContentPane().add(Dia);
        Dia.setBounds(29, 28, 23, 20);

        cDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cDiaItemStateChanged(evt);
            }
        });
        getContentPane().add(cDia);
        cDia.setBounds(75, 28, 52, 20);
        int dias=1;
        String cad_dias="";
        for(int i=1; i<=31; i++){
            cad_dias = String.valueOf(dias);
            cDia.addItem(cad_dias);
            dias++;}

        label1.setText("Mes");
        getContentPane().add(label1);
        label1.setBounds(165, 28, 27, 20);

        cMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cMesItemStateChanged(evt);
            }
        });
        getContentPane().add(cMes);
        cMes.setBounds(202, 28, 136, 20);
        cMes.addItem("Enero");
        cMes.addItem("Febrero");
        cMes.addItem("Marzo");
        cMes.addItem("Abril");
        cMes.addItem("Mayo");
        cMes.addItem("Junio");
        cMes.addItem("Julio");
        cMes.addItem("Agosto");
        cMes.addItem("Septiembre");
        cMes.addItem("Octubre");
        cMes.addItem("Noviembre");
        cMes.addItem("Diciembre");

        sbar.setBackground(new java.awt.Color(255, 55, 55));
        sbar.setBlockIncrement(1);
        sbar.setForeground(new java.awt.Color(0, 204, 204));
        sbar.setMaximum(375);
        sbar.setMaximumSize(null);
        sbar.setMinimum(1);
        sbar.setOrientation(java.awt.Scrollbar.HORIZONTAL);
        sbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sbarMouseClicked(evt);
            }
        });
        sbar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                sbarAdjustmentValueChanged(evt);
            }
        });
        getContentPane().add(sbar);
        sbar.setBounds(86, 75, 161, 16);

        reset.setLabel("Resetear");
        reset.setName("Resetear"); // NOI18N
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(131, 112, 67, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        sbar.setValue(0);
        cDia.select(0);
        cMes.select(0);
        int valorSbar = sbar.getValue();
        System.out.println(valorSbar);


    }//GEN-LAST:event_resetActionPerformed

    private void sbarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_sbarAdjustmentValueChanged
        // TODO add your handling code here:
        int valorSbar = sbar.getValue();

        if (valorSbar >= 1 && valorSbar <= 31) {
            cDia.select(valorSbar - 1);
            System.out.println(valorSbar);
            cMes.select(0);
        }
        if (valorSbar > 31 && valorSbar <= 59) {
            int dia = valorSbar - 31;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(1);
        }
        if (valorSbar > 59 && valorSbar <= 90) {
            int dia = valorSbar - 59;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(2);
        }
        if (valorSbar > 90 && valorSbar <= 120) {
            int dia = valorSbar - 90;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(3);
        }
        if (valorSbar > 120 && valorSbar <= 151) {
            int dia = valorSbar - 120;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(4);
        }
        if (valorSbar > 151 && valorSbar <= 181) {
            int dia = valorSbar - 151;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(5);
        }
        if (valorSbar > 181 && valorSbar <= 212) {
            int dia = valorSbar - 181;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(6);
        }
        if (valorSbar > 212 && valorSbar <= 243) {
            int dia = valorSbar - 212;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(7);
        }
        if (valorSbar > 243 && valorSbar <= 273) {
            int dia = valorSbar - 243;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(8);
        }
        if (valorSbar > 273 && valorSbar <= 304) {
            int dia = valorSbar - 273;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(9);
        }
        if (valorSbar > 304 && valorSbar <= 334) {
            int dia = valorSbar - 304;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(10);
        }
        if (valorSbar > 334 && valorSbar <= 365) {
            int dia = valorSbar - 334;
            cDia.select(dia - 1);
            System.out.println(dia);
            cMes.select(11);
        }
        System.out.println(valorSbar);
    }//GEN-LAST:event_sbarAdjustmentValueChanged

    private void sbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sbarMouseClicked

    private void cDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cDiaItemStateChanged
        // TODO add your handling code here
        String mes = (cMes.getSelectedItem());
        int dia = Integer.parseInt(cDia.getSelectedItem());
        if (mes == "Enero") {
            sbar.setValue(dia);

        } else if (mes == "Febrero") {
            int actual = 31;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Marzo") {
            int actual = 59;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Abril") {
            int actual = 89;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Mayo") {
            int actual = 120;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Junio") {
            int actual = 151;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Julio") {
            int actual = 181;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Agosto") {
            int actual = 212;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Septiembre") {
            int actual = 243;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Octubre") {
            int actual = 273;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mes == "Noviembre") {
            int actual = 304;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else {
            int actual = 334;
            int barra = dia + actual;
            sbar.setValue(barra);
        }


    }//GEN-LAST:event_cDiaItemStateChanged

    private void cMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cMesItemStateChanged
        // TODO add your handling code here:
        String mes = (cMes.getSelectedItem());
        int cantidad = cDia.getItemCount();
        if (cantidad == 28) {
            int dias = 29;
            String cad_dias = "";
            for (int i = 0; i <= 2; i++) {
                cad_dias = String.valueOf(dias);
                cDia.addItem(cad_dias);
                dias++;
            }
        } else if (cantidad == 30) {
            int dia = 31;
            String cad_dias = "";
            cad_dias = String.valueOf(dia);
            cDia.addItem(cad_dias);
        } else if (mes == "Febrero") {
            cDia.remove(30);
            cDia.remove(29);
            cDia.remove(28);
            System.out.println("28 días");
        } else if (mes == "Abril" || mes == "Junio" || mes == "Septiembre" || mes == "Noviembre") {
            cDia.remove(30);
            System.out.println("30 dias");
        } else {
            System.out.println("31 días");
        }

        int dia = Integer.parseInt(cDia.getSelectedItem());
        String mess = (cMes.getSelectedItem());
        if (mess == "Enero") {
            sbar.setValue(dia);

        } else if (mess == "Febrero") {
            int actual = 31;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Marzo") {
            int actual = 59;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Abril") {
            int actual = 89;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Mayo") {
            int actual = 120;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Junio") {
            int actual = 151;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Julio") {
            int actual = 181;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Agosto") {
            int actual = 212;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Septiembre") {
            int actual = 243;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Octubre") {
            int actual = 273;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else if (mess == "Noviembre") {
            int actual = 304;
            int barra = dia + actual;
            sbar.setValue(barra);
        } else {
            int actual = 334;
            int barra = dia + actual;
            sbar.setValue(barra);
        }
    }//GEN-LAST:event_cMesItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ejercicio2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label Dia;
    private java.awt.Choice cDia;
    private java.awt.Choice cMes;
    private java.awt.Label label1;
    private java.awt.Button reset;
    private java.awt.Scrollbar sbar;
    // End of variables declaration//GEN-END:variables

}
