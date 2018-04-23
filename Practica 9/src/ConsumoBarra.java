
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fran de la Torre
 */
public class ConsumoBarra {

    DefaultTableModel modelo;
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;

    public ConsumoBarra() {
        String url = ".\\Consumo.s3db";

        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet obtenerRegistroBarra(String tabla) {
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

    public Barras obtenerBarra(String valor) {
        String sentenciaSQL = "SELECT * FROM Barras WHERE nombre= '" + valor + "'";
        System.out.print(sentenciaSQL);
        Barras barras = null;
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);

            if (resultado.next()) {
                int codigoBarra = resultado.getInt("codigoBarra");
                String barra = resultado.getString("barra");
                barras = new Barras(codigoBarra, barra);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            barras = null;
        }
        return barras;
    }

    public ResultSet obtenerDatosBarra(String barra, String fecha) {
        String sentenciaSQL = "SELECT * FROM Articulos,Consumo,Barras WHERE Consumo.codigoArticulo=Articulos.codigoArticulo AND Barras.codigoBarra = Consumo.codigoBarra AND Barras.barra LIKE'" + barra + "' AND Consumo.fecha LIKE '" + fecha + "'";
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);
            System.out.println(sentencia);
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }

    public ResultSet obtenerConsumosBarra(String barra, String fecha) {
        String sentenciaSQL = "SELECT Consumo.unidades * Articulos.pvp AS Importe FROM Articulos,Consumo,Barras WHERE Consumo.codigoArticulo=Articulos.codigoArticulo AND Barras.codigoBarra = Consumo.codigoBarra AND Barras.barra LIKE'" + barra + "' AND Consumo.fecha LIKE '" + fecha + "'";
        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);
            System.out.println(sentencia);
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }

}
