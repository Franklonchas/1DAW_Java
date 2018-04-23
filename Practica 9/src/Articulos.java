/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran de la Torre
 */
public class Articulos {

    private String articulo;
    private int codigoArticulo, stock, pvp;

    public Articulos(int codigoArticulo, String articulo, int stock, int pvp) {
        this.codigoArticulo = codigoArticulo;
        this.articulo = articulo;
        this.stock = stock;
        this.pvp = pvp;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public int getStock() {
        return stock;
    }

    public int getPvp() {
        return pvp;
    }

    public String getArticulo() {
        return articulo;
    }
}
