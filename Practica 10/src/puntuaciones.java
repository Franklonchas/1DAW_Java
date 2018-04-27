/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class puntuaciones {
    String codigoJornada, codigoPartido, codigoEquipo;
    int intentos1, canastas1, intentos2, canastas2, intentos3, canastas3;

    public puntuaciones (String codigoJornada, String codigoPartido, String codigoEquipo, int intentos1, int canastas1, int intentos2, int canastas2, int intentos3, int canastas3) {
        this.codigoJornada = codigoJornada;
        this.codigoEquipo = codigoEquipo;
        this.codigoPartido = codigoPartido;
        this.intentos1 = intentos1;
        this.canastas1 = canastas1;
        this.canastas2 = canastas2;
        this.canastas3 = canastas3;
        this.intentos2 = intentos2;
        this.intentos3 = intentos3;
    }

    public String getcodigoJornada() {
        return codigoJornada;
    }

    public String getcodigoPartido() {
        return codigoPartido;
    }

    public String getcodigoEquipo() {
        return codigoEquipo;
    }

    public int getintentos1() {
        return intentos1;
    }

    public int getintentos2() {
        return intentos2;
    }

    public int getintentos3() {
        return intentos3;
    }

    public int getcanastas1() {
        return canastas1;
    }

    public int getcanastas2() {
        return canastas2;
    }

    public int getcanastas3() {
        return canastas3;
    }
}
