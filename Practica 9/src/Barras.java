/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran de la Torre
 */
public class Barras {

    private String barra;
    private int codigoBarra;

    public Barras(int codigoBarra, String barra) {
        this.codigoBarra = codigoBarra;
        this.barra = barra;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public String getBarra() {
        return barra;
    }
}
