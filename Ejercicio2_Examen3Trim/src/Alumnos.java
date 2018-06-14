/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran De La Torre
 */
public class Alumnos {

    int idAlumno, idCurso;
    String nombre;

    public Alumnos(int idAlumno, String nombre, int idCurso) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

}
