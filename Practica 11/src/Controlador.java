
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

    public ResultSet ObtenerCursos() {
        String sentenciaSQL = "SELECT * FROM cursos";
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.print("No se pudo realizar consulta");
            e.printStackTrace();
            return null;
        }
        return resultado;
    }

    public ResultSet ObtenerAsignaturas(int cursoSeleccionado) {
        String sentenciaSQL = "SELECT * FROM asignaturas,cursos WHERE ASIGNATURAS.idCurso = CURSOS.idCurso AND Asignaturas.idCurso ='" + cursoSeleccionado + "'";
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.print("No se pudo realizar consulta");
            e.printStackTrace();
            return null;
        }
        return resultado;
    }
    
    public ResultSet rellenarLista1(int cursoSeleccionado) {
        String sentenciaSQL = "SELECT * FROM alumnos,cursos WHERE alumnos.idCurso = CURSOS.idCurso AND alumnos.idCurso ='" + cursoSeleccionado + "'";
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.print("No se pudo realizar consulta");
            e.printStackTrace();
            return null;
        }
        return resultado;
    }
    

}
