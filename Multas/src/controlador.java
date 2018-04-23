
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
        String url = ".\\infracciones.s3db";
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
        String sentenciaSQL = "SELECT * FROM " + tabla;
        System.out.println(sentenciaSQL);
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);
        } catch (SQLException evt) {
            System.err.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }

}
