/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Medina vega
 */
import java.sql.*;

public class AlumnosBD {

    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;

    public AlumnosBD() {
        String url = ".\\alumnos.s3db";
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            System.out.println("Conexion realizada");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public ResultSet obtenerRegistro(String tabla) {
        String sentenciaSQL = "SELECT * FROM " + tabla + "";

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta");
            System.out.println(sentenciaSQL);
            return null;
        }
        return resultado;
    }

    public ResultSet obtenerIdCurso(String curso) {
        String sentenciaSQL = "SELECT  idCurso FROM cursos WHERE curso= '" + curso + "'";

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta Id Curso");
            System.out.println(sentenciaSQL);
            return null;
        }
        return resultado;
    }

    public ResultSet obtenerAsignaturas(int idCurso) {
        String sentenciaSQL = "SELECT asignatura FROM asignaturas WHERE idCurso= '" + idCurso + "'";

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta");
            System.out.println(sentenciaSQL);
            return null;
        }
        return resultado;
    }

    public ResultSet obtenerAlumnos(String idCurso) {
        String sentenciaSQL = "SELECT  nombre FROM alumnos WHERE idCurso= '" + idCurso + "'";

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta");
            System.out.println(sentenciaSQL);
            return null;
        }
        return resultado;
    }

    public ResultSet obtenerNotas(int idAsignatura, String evaluacion) {
        String sentenciaSQL = "SELECT  nota FROM notas WHERE  idAsignatura= " + idAsignatura + " AND evaluacion= '" + evaluacion + "'";

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta obtener notas");

            return null;
        }
        return resultado;
    }

    public ResultSet obtenerAlumnos(int idCurso) {
        String sentenciaSQL = "SELECT idAlumno FROM alumnos WHERE idCurso= '" + idCurso + "'";

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta");
            System.out.println(sentenciaSQL);
            return null;
        }
        return resultado;
    }

    public ResultSet obtenerIdAsignatura(int idCurso) {
        String sentenciaSQL = "SELECT idAsignatura FROM asignaturas WHERE idCurso= '" + idCurso + "'";

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

        } catch (SQLException e) {
            System.out.println("No se puede realizar la consulta ID asignatura");
            System.out.println(sentenciaSQL);
            return null;
        }
        return resultado;
    }

}
