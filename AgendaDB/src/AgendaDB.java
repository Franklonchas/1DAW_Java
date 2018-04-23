/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class AgendaDB {

    private String nombre, direccion, localidad, telefono, email;
    private int edad;

    public AgendaDB() {
    }

    public AgendaDB(String nom, String dir, String loc, String tlf, String email, int edad) {
        nombre = nom;
        direccion = dir;
        telefono = tlf;
        localidad = loc;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getEdad() {
        return edad;
    }

}
