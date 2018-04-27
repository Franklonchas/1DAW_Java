/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class jornadas {

    String jornada, fecha;

    public jornadas(String jornada, String fecha) {
        this.jornada = jornada;
        this.fecha = fecha;
    }

    
    public String getJornada(){
        return jornada;
    }
    
    public String getFecha(){
        return fecha;
    }
    
}
