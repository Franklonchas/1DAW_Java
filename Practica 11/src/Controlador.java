
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class Controlador {
    
    DefaultTableModel modelo;
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;

    public Controlador() {
        String url = ".\\alumnos.s3db";

        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            System.out.println("Conectado con Alumnos BD");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
