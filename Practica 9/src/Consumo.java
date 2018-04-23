/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran de la Torre
 */
public class Consumo {

    private int id, codigoArticulo, codigoBarra, unidades;
    private String fecha;

    public Consumo(int id, String fecha, int codigoArticulo, int codigoBarra, int unidades) {
        this.id = id;
        this.fecha = fecha;
        this.codigoArticulo = codigoArticulo;
        this.codigoBarra = codigoBarra;
        this.unidades = unidades;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public int getUnidades() {
        return unidades;
    }
}
