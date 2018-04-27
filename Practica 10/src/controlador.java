
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fran De La Torre
 */
public class controlador {

    DefaultTableModel modelo;
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;

    public controlador() {
        String url = ".\\baloncesto.s3db";

        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            System.out.println("Conectado con Baloncesto BD");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet obtenerRegistroJornada(String tabla) {
        String sentenciaSQL = "SELECT * FROM " + tabla;
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

    public ResultSet obtenerRegistroPartido(String jornadaSeleccionada) {
        String sentenciaSQL = "SELECT * FROM PARTIDOS,JORNADAS WHERE JORNADAS.jornada = PARTIDOS.jornada AND JORNADAS.jornada = '" + jornadaSeleccionada + "'";
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

    public ResultSet obtenerEquipo1(String codigoEquipo1) {
        String sentenciaSQL = "SELECT nombre FROM EQUIPOS WHERE codigoEquipo = '" + codigoEquipo1 + "'";
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

    public ResultSet obtenerEquipo2(String codigoEquipo2) {
        String sentenciaSQL = "SELECT nombre FROM EQUIPOS WHERE codigoEquipo = '" + codigoEquipo2 + "'";
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

    public ResultSet obtenerIntentos(String codigoPartido, String codigoEquipo) {
        String sentenciaSQL = "SELECT * FROM PUNTUACIONES WHERE PUNTUACIONES.codigoPartido = '" + codigoPartido + "'" + "AND PUNTUACIONES.codigoEquipo = '" + codigoEquipo + "'";
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
