/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class coche {

    String codigo, nif, nombre, direccion, matricula, coche;

    public coche(String codigo, String nif, String nombre, String direccion, String matricula, String coche) {
        this.codigo = codigo;
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.matricula = matricula;
        this.coche = coche;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNIF() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCoche() {
        return coche;
    }

}
