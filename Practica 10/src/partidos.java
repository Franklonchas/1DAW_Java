/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class partidos {

    String jornada, codigoPartido, codigoEquipo1, codigoEquipo2;

    public partidos(String jornada, String codigoPartido, String codigoEquipo1, String codigoEquipo2) {
        this.jornada = jornada;
        this.codigoPartido = codigoPartido;
        this.codigoEquipo1 = codigoEquipo1;
        this.codigoEquipo2 = codigoEquipo2;
    }

    public String getjornada() {
        return jornada;
    }

    public String getcodigoPartido() {
        return codigoPartido;
    }

    public String getcodigoEquipo1() {
        return codigoEquipo1;
    }

    public String getcodigoEquipo2() {
        return codigoEquipo2;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public void setCodigoEquipo1(String codigoEquipo1) {
        this.codigoEquipo1 = codigoEquipo1;
    }

    public void setCodigoEquipo2(String codigoEquipo2) {
        this.codigoEquipo2 = codigoEquipo2;
    }
    
    
}
