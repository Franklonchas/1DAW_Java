
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author francisco
 */
public class Agenda extends java.awt.Frame {

    Persona p;
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    /**
     * Creates new form Agenda
     */
    public Agenda() {
        initComponents();
    }

    public void limpiar() {
        tfnombre.setText("");
        tfdireccion.setText("");
        tfedad.setText("");
        tftelefono.setText("");
    }

    public void nuevo() {
        try{
            String n = tfnombre.getText();
            String d = tfdireccion.getText();
            String t = tftelefono.getText();
            int e = Integer.parseInt(tfedad.getText());



            if ((!"".equals(tfnombre.getText())) && (!"".equals(tfdireccion.getText()))
                    && (!"".equals(tfedad.getText())) && (!"".equals(tftelefono.getText()))) {
                p = new Persona(n, d, e, t);
                listaPersonas.add(p);

                System.out.println(listaPersonas);
                System.out.println(p);

                chseleccionar.add(n);
            } else {
                System.err.println("Algun campo esta vacio");
            }
        } catch(NumberFormatException evt){
            System.err.println("Algun campo esta vacio o es erroneo");
            dialogo.setVisible(true);
        }
    }

    public void borrar() {
        try {
            int i = chseleccionar.getSelectedIndex();
            chseleccionar.remove(i);
            listaPersonas.remove(i);
            System.out.println(listaPersonas);
            tfnombre.setText("");
            tfdireccion.setText("");
            tftelefono.setText("");
            tfedad.setText("");
        } catch (Exception evt) {
        }
    }
    
    public void mostrar(){
        int i = chseleccionar.getSelectedIndex();
        Persona j = listaPersonas.get(i);
        tfnombre.setText(j.getNombre());
        tfdireccion.setText(j.getDireccion());
        tftelefono.setText(j.getTelefono());
        String edad = Integer.toString(j.getEdad());
        tfedad.setText(edad);
    }

    public class Persona {

        private String nombre;
        private String direccion;
        private Integer edad;
        private String telefono;

        public Persona(String n, String d, Integer e, String t) {
            this.nombre = n;
            this.direccion = d;
            this.edad = e;
            this.telefono = t;
        }

        public Persona() {
        }

        public String getNombre() {
            return nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public Integer getEdad() {
            return edad;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setNombre(String n) {
            this.nombre = n;
        }

        public void setDireccion(String d) {
            this.direccion = d;
        }

        public void setEdad(Integer e) {
            this.edad = e;
        }

        public void setTelefono(String t) {
            this.telefono = t;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogo = new javax.swing.JDialog();
        lwow = new java.awt.Label();
        okay = new java.awt.Button();
        lseleccionar = new java.awt.Label();
        chseleccionar = new java.awt.Choice();
        borrar = new java.awt.Button();
        limpiar = new java.awt.Button();
        nuevo = new java.awt.Button();
        lnombre = new java.awt.Label();
        ldireccion = new java.awt.Label();
        ledad = new java.awt.Label();
        lnumero = new java.awt.Label();
        tfnombre = new java.awt.TextField();
        tfdireccion = new java.awt.TextField();
        tfedad = new java.awt.TextField();
        tftelefono = new java.awt.TextField();

        dialogo.setMinimumSize(new java.awt.Dimension(580, 180));
        dialogo.getContentPane().setLayout(null);

        lwow.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lwow.setForeground(new java.awt.Color(255, 51, 51));
        lwow.setText("WOW!");
        dialogo.getContentPane().add(lwow);
        lwow.setBounds(200, 20, 150, 70);

        okay.setLabel("OKAY");
        okay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okayActionPerformed(evt);
            }
        });
        dialogo.getContentPane().add(okay);
        okay.setBounds(240, 110, 47, 24);

        setMinimumSize(new java.awt.Dimension(580, 380));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);

        lseleccionar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lseleccionar.setText("Seleccionar");
        add(lseleccionar);
        lseleccionar.setBounds(30, 60, 100, 23);

        chseleccionar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chseleccionarItemStateChanged(evt);
            }
        });
        add(chseleccionar);
        chseleccionar.setBounds(130, 60, 330, 20);

        borrar.setActionCommand("Button1");
        borrar.setLabel("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        add(borrar);
        borrar.setBounds(480, 60, 50, 24);

        limpiar.setLabel("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar);
        limpiar.setBounds(480, 100, 58, 24);

        nuevo.setLabel("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        add(nuevo);
        nuevo.setBounds(490, 240, 51, 24);

        lnombre.setText("Nombre");
        add(lnombre);
        lnombre.setBounds(50, 160, 50, 20);

        ldireccion.setText("Direccion");
        add(ldireccion);
        ldireccion.setBounds(50, 200, 60, 20);

        ledad.setText("Edad");
        add(ledad);
        ledad.setBounds(50, 240, 33, 20);

        lnumero.setText("Telefono");
        add(lnumero);
        lnumero.setBounds(50, 280, 52, 20);
        add(tfnombre);
        tfnombre.setBounds(110, 160, 350, 20);
        add(tfdireccion);
        tfdireccion.setBounds(110, 200, 350, 20);
        add(tfedad);
        tfedad.setBounds(110, 240, 100, 20);
        add(tftelefono);
        tftelefono.setBounds(110, 280, 150, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_nuevoActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        borrar();
    }//GEN-LAST:event_borrarActionPerformed

    private void chseleccionarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chseleccionarItemStateChanged
        mostrar();
    }//GEN-LAST:event_chseleccionarItemStateChanged

    private void okayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okayActionPerformed
        dialogo.setVisible(false);
    }//GEN-LAST:event_okayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button borrar;
    private java.awt.Choice chseleccionar;
    private javax.swing.JDialog dialogo;
    private java.awt.Label ldireccion;
    private java.awt.Label ledad;
    private java.awt.Button limpiar;
    private java.awt.Label lnombre;
    private java.awt.Label lnumero;
    private java.awt.Label lseleccionar;
    private java.awt.Label lwow;
    private java.awt.Button nuevo;
    private java.awt.Button okay;
    private java.awt.TextField tfdireccion;
    private java.awt.TextField tfedad;
    private java.awt.TextField tfnombre;
    private java.awt.TextField tftelefono;
    // End of variables declaration//GEN-END:variables
}
