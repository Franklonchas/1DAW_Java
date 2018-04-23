
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class controlador {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;

    public controlador() {
        String url = "C:\\Users\\Fran De La Torre\\Dropbox\\Desarrollo de Aplicaciones WEB\\2 DAW\\Programacion\\Proyectos NetBeans\\AgendaDB2\\agenda.s3db";
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
        } catch (SQLException evt) {
            System.out.println("No se pudo establecer la conexion: " + evt);
        }
        if (conexion != null) {
            System.out.println("Conexion realizada correctamente");
        }
    }

    public ResultSet obtenerRegistros(String tabla) {
        String sentenciaSQL = "select * from " + tabla + " order by nombre";
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);
        } catch (SQLException evt) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }

    public modelo obtenerContacto(String valor) {
        String sentenciaSQL = "select * from contacto where nombre = '" + valor + "'";
        //System.out.println(sentenciaSQL);
        modelo contacto = null;
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

            if (resultado.next()) {

                String nom = resultado.getString("nombre");
                String dir = resultado.getString("direccion");
                String tlf = resultado.getString("telefonos");
                String loc = resultado.getString("localidad");
                String email = resultado.getString("correo");
                int edad = resultado.getInt("edad");
                contacto = new modelo(nom, dir, tlf, loc, email, edad);
            }
        } catch (SQLException evt) {
            System.err.println("No se pudo realizar la consulta");
            contacto = null;
        }
        return contacto;
    }

    public void nuevoContacto(modelo contacto) {

        String nom = contacto.getNombre();
        String dir = contacto.getDireccion();
        String tlf = contacto.getTelefono();
        String loc = contacto.getLocalidad();
        String email = contacto.getEmail();
        int edad = contacto.getEdad();

        String sentenciaSQL = "INSERT INTO contacto(nombre, direccion, localidad, telefonos, correo, edad) VALUES('" + nom + "','" + dir + "','" + loc + "','" + tlf + "','" + email + "'," + edad + ")";
        System.out.println(sentenciaSQL);

        try {
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException evt) {
            System.err.println("No se pudo realizar la consulta");
        }
    }

    public void modificarContacto(modelo contacto) {
        String nom = contacto.getNombre();
        String dir = contacto.getDireccion();
        String tlf = contacto.getTelefono();
        String loc = contacto.getLocalidad();
        String email = contacto.getEmail();
        int edad = contacto.getEdad();

        String sentenciaSQL = "UPDATE contacto SET direccion='" + dir + "', localidad='" + loc + "', telefonos='" + tlf + "', correo='" + email + "', edad=" + edad + " WHERE nombre='" + nom + "';";
        System.out.println(sentenciaSQL);

        try {
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException evt) {
            System.err.println("No se pudo realizar la consulta");
        }
    }

    public void borrarContacto(String valor) {

        String sentenciaSQL = "DELETE FROM contacto WHERE nombre='" + valor + "'";
        System.out.println(sentenciaSQL);

        try {
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException evt) {
            System.err.println("No se pudo borrar el registro.");
        }

    }
}
