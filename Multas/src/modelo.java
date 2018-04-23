/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class modelo {

    private String infraccion, fecha, penalizacion;
    
    public modelo(String infraccion, String fecha, String penalizacion){
        this.infraccion = infraccion;
        this.fecha = fecha;
        this.penalizacion = penalizacion;
    }
    
    public String getInfraccion() {
        return infraccion;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public String getPenalizacion() {
        return penalizacion;
    }
    
}
